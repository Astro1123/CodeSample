package Debug;

public enum ErrorCode {
	ERROR(-1),
	SUCCESS(0);
	
	private int id;
	
	private ErrorCode(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
}
