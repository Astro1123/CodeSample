package QuickSort;

import Test.Test;

public class TestDriver {
	private final int LENGTH = 16;
	
	public static void main(String[] args) {
		TestDriver td = new TestDriver();
		td.test();
	}
	
	private void test() {
		Test t = new Test();
		int[] arr = t.make(LENGTH);
		t.print(arr);
		
		QuickSort qs = new QuickSort();
		int[] result = qs.sort(arr);
		t.print(result);
	}
}