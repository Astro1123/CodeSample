package Debug;

public class Error {
	public static String getError(ErrorCode ec) {
		return body(ec);
	}
	
	public static String getError(String process, ErrorCode ec) {
		return String.format("%s%s", header(process), body(ec));
	}
	
	public static void printError(ErrorCode ec) {
		String str = body(ec);
		System.out.println(str);
	}
	
	public static void printError(String process, ErrorCode ec) {
		String str = String.format("%s%s", header(process), body(ec));
		System.out.println(str);
	}
	
	private static String header(String process) {
		String head = "";
		if (process != null && process != "") {
			head = String.format("%s: ", process);
		}
		return head;
	}
	
	private static String body(ErrorCode ec) {
		String body;
		switch (ec) {
			case SUCCESS:
				body = "Success";
				break;
			default:
				body = "Unknown";
				break;
		}
		return body;
	}
}
