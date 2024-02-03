package Test;

//import Sort.*;
import Sort.Sort;
import Sort.Fast.*;

public class SortTimeTestDriver {
	private final int LENGTH = 1024*16;
	private final int LOOP_COUNT = 100;
	private final Sort[] LIST = {
		new BubbleSortFast(), 
		new ShakerSortFast(),
		new CombSortFast(),
		new GnomeSortFast(),
		new InsertionSortFast(),
		new ShellSortFast(),
		new ShellSortFastKnuth(),
		new SelectionSortFast(), 
		new DoubleSelectionSortFast(), 
		new HeapSortFast(), 
		new MergeSortFast(), 
		new QuickSortFast(),
		new QuickSortFastMid(),
	};
	
	public static void main(String[] args) {
		SortTimeTestDriver td = new SortTimeTestDriver();
		td.startDriver();
	}
	
	private void startDriver() {
		System.out.println(String.format("Length: %d", LENGTH));
		System.out.println(String.format("Loop: %d\n", LOOP_COUNT));
		for (Sort s : LIST) {
			System.out.print("Method: ");
			System.out.println(s.getName());
			test(s);
			System.out.println("----------------------------------------");
		}
	}
	
	private void test(Sort sort) {
		Test t = new Test();
		int[] arr = t.make(LENGTH);
		System.out.print(String.format("%-10s", "Random:"));
		testSub(sort, arr);
		
		arr = t.makeASC(LENGTH);
		System.out.print(String.format("%-10s", "Sorted:"));
		testSub(sort, arr);
		
		arr = t.makeDESC(LENGTH);
		System.out.print(String.format("%-10s", "Reverse:"));
		testSub(sort, arr);
	}
	
	private void testSub(Sort sort, int[] arr) {
		long time = 0;
		for (int i = 0; i < LOOP_COUNT; i++) {
			//long startTime = System.currentTimeMillis();
			long startTime = System.nanoTime();
			sort.sort(arr);
			//long endTime = System.currentTimeMillis();
			long endTime = System.nanoTime();
			time += endTime - startTime;
		}
		System.out.println(String.format("Time: %.2f ns", (double)time / LOOP_COUNT));
	}
}
