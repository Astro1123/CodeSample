
public class Main {
	public static void main(String[] args) {
		DateTime dt = new DateTime("2023/08/03 02:27");
		System.out.println(dt.year);
		System.out.println(dt.month);
		System.out.println(dt.day);
		System.out.println(dt.hour);
		System.out.println(dt.min);
		System.out.println(dt.sec);
		System.out.println(dt.delta(new DateTime("2023/08/01 01:27")));
		System.out.println(dt.ModifiedJulianDay());
		System.out.println(dt.dayOfWeek());
		System.out.println(dt.dayOfYear());
	}
}