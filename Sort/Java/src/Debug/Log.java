package Debug;

import java.io.PrintStream;

public class Log {
	private int level;
	private boolean color;
	private StackTraceElement throwableStackTraceElement;
	private PrintStream ps;
	
	public Log() {
		init(LogLevel.LOG_ERROR, true, System.out);
	}
	
	public Log(boolean color) {
		init(LogLevel.LOG_ERROR, color, System.out);
	}
	
	public Log(PrintStream ps) {
		init(LogLevel.LOG_ERROR, true, ps);
	}
	
	public Log(LogLevel level) {
		init(level, true, System.out);
	}
	
	public Log(LogLevel level, boolean color) {
		init(level, color, System.out);
	}
	
	public Log(LogLevel level, PrintStream ps) {
		init(level, true, ps);
	}
	
	public Log(LogLevel level, boolean color, PrintStream ps) {
		init(level, color, ps);
	}
	
	public Log(int level) {
		init(level, true, System.out);
	}
	
	public Log(int level, boolean color) {
		init(level, color, System.out);
	}
	
	public Log(int level, PrintStream ps) {
		init(level, true, ps);
	}
	
	public Log(int level, boolean color, PrintStream ps) {
		init(level, color, ps);
	}
	
	private void init(LogLevel level, boolean color, PrintStream ps) {
		setLogLevel(level);
		this.color = color;
		this.ps = ps;
	}
	
	private void init(int level, boolean color, PrintStream ps) {
		setLogLevel(level);
		this.color = color;
		this.ps = ps;
	}
	
	public void printLogInfo(Object obj) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		printLogMain(LogLevel.LOG_INFO.getID(), obj.toString());
	}
	
	public void printLogInfo(String format, Object... obj) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		printLogMain(LogLevel.LOG_INFO.getID(), format, obj);
	}
	
	public void printLogDebug(Object obj) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		printLogMain(LogLevel.LOG_DEBUG.getID(), obj.toString());
	}
	
	public void printLogDebug(String format, Object... obj) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		printLogMain(LogLevel.LOG_DEBUG.getID(), format, obj);
	}
	
	public void printLog(LogLevel level, Object obj) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		printLogMain(level.getID(), obj.toString());
	}
	
	public void printLog(LogLevel level, String format, Object... obj) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		printLogMain(level.getID(), format, obj);
	}
	
	public void printLog(int level, Object obj) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		printLogMain(level, obj.toString());
	}
	
	public void printLog(int level, String format, Object... obj) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		printLogMain(level, format, obj);
	}
	
	public void printError(LogLevel level, ErrorCode ec) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		String str = Error.getError(ec);
		printLogMain(level.getID(), str);
	}
	
	public void printError(int level, ErrorCode ec) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		String str = Error.getError(ec);
		printLogMain(level, str);
	}
	
	public void printError(LogLevel level, String process, ErrorCode ec) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		String str = Error.getError(process, ec);
		printLogMain(level.getID(), str);
	}
	
	public void printError(int level, String process, ErrorCode ec) {
		throwableStackTraceElement = new Throwable().getStackTrace()[1];
		String str = Error.getError(process, ec);
		printLogMain(level, str);
	}
	
	public void setLogLevel(LogLevel level) {
		this.level = level.getID();
	}
	
	public void setLogLevel(int level) {
		if (level < LogLevel.LOG_ALERT.getID()) {
			this.level = LogLevel.LOG_ALERT.getID();
		} else if (level > LogLevel.LOG_DEBUG.getID()) {
			this.level = LogLevel.LOG_DEBUG.getID();
		} else {
			this.level = level;
		}
	}
	
	private void printLogMain(int level, String format, Object... obj) {
		if (level > this.level) return;
		
		StringBuilder sb = new StringBuilder();
		sb.append(header(level));
		String str = String.format(format, obj);
		sb.append(str);
		sb.append(footer(level));
		
		this.ps.println(sb.toString());
	}
	
	private String header(int level) {
		int line = throwableStackTraceElement.getLineNumber();
		String mName = throwableStackTraceElement.getMethodName();
		String cName = throwableStackTraceElement.getClassName();
		
		String str = "";
		String head;
		switch (level) {
			case 1:
				head = (this.color ? "\u001b[00;41m\u001b[1m" : "") + "[***ALERT***]";
				break;
			case 2:
				head = (this.color ? "\u001b[45m\u001b[1m" : "") + "[***CRITICAL***]";
				break;
			case 3:
				head = (this.color ? "\u001b[31m\u001b[1m" : "") + "[***ERROR***]";
				break;
			case 4:
				head = (this.color ? "\u001b[33m\u001b[1m" : "") + "[*WARNING*]";
				break;
			case 5:
				head = (this.color ? "\u001b[33m" : "") + "[NOTICE]";
				break;
			case 6:
				head = "[INFO]";
				break;
			case 7:
				head = "[DEBUG]";
				break;
			default:
				return str;
		}
        str = String.format("%s %s [%d] %s(): ", head, cName, line, mName);
		return str;
	}
	
	private String footer(int level) {
		String str = "";
		if (!this.color) return str;
		
		switch (level) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
        		str = "\u001b[00m";
				break;
			default:
				break;
		}
		return str;
	}
	
	public enum LogLevel {
		LOG_ALERT(1),
		LOG_CRIT(2),
		LOG_ERROR(3),
		LOG_WARN(4),
		LOG_NOTICE(5),
		LOG_INFO(6),
		LOG_DEBUG(7);
		
		private int id;
		
		private LogLevel(int id) {
			this.id = id;
		}
		
		public int getID() {
			return id;
		}
	}
}
