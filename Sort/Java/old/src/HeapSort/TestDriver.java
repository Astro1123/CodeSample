package HeapSort;

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
		
		HeapSort hs = new HeapSort();
		int[] result = hs.sort(arr);
		t.print(result);
	}
}