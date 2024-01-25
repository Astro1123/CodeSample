package Test;

import java.util.Random;
import Search.*;
import Search.Const.*;

public class SearchTestDriver {
	private final int LENGTH = 16;
	private final Search[] LIST = {
		new LinearSearch(),
		new BinarySearch(),
	};
	
	public static void main(String[] args) {
		SearchTestDriver td = new SearchTestDriver();
		td.startDriver();
	}
	
	private void startDriver() {
		int n = rand(0, LENGTH + 1);
		System.out.print("Search: ");
		System.out.println(n);
		
		System.out.println("----------------------------------------");
		for (Search s : LIST) {
			System.out.print("Method: ");
			System.out.println(s.getName());
			test(s, n);
			System.out.println("----------------------------------------");
		}
	}
	
	private void test(Search search, int n) {
		Test t = new Test();
		int[] arr = t.makeASC(LENGTH);
		System.out.println("Array: ");
		t.print(arr);
		
		int result = search.search(n, arr);
		System.out.print("Result: ");
		System.out.println(result);
	}
	
	private int rand(int min, int max) {
		Random random = new Random();
		double r = random.nextDouble();
		
		int result = (int)(r * (max + 1 - min) + min);
		return result;
	}
}
