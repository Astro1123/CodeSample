public class Main {
	public static void main(String[] args) {
		Change c = new Change(args);
		if (c.start() < 0) {
			System.out.println("Error");
		}
	}
}