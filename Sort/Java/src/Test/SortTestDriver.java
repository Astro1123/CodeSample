package Test;

import Sort.*;
import Sort.Const.*;
import Sort.Fast.*;
import Sort.SortNC.*;

public class SortTestDriver {
	private final int LENGTH = 16;
	private final Sort[] LIST = {
		new BubbleSort(), 
		new SelectionSort(), 
		new InsertionSort(), 
		new HeapSort(), 
		new MergeSort(), 
		new QuickSort(),
		
		//new ShellSort(),
		//new ShellSort(ShellGapMethod.FRANK_LAZARUS),
		//new ShellSort(ShellGapMethod.KNUTH),
		//new ShellSort(ShellGapMethod.HIBBARD),
		//new ShellSort(ShellGapMethod.PAPERNOV_STASEVICH),
		//new ShellSort(ShellGapMethod.SEDGEWICK),
		//new ShellSort(ShellGapMethod.PRATT),
		//new CombSort(),
		//new GnomeSort(),
		//new ShakerSort(),
		//new DoubleSelectionSort(),
		/*
		new BubbleSortFast(), 
		new SelectionSortFast(), 
		new InsertionSortFast(), 
		new HeapSortFast(), 
		new MergeSortFast(), 
		new QuickSortFast(),
		new QuickSortFastMid(),
		new ShellSortFast(),
		new ShellSortFastKnuth(),
		new CombSortFast(),
		new GnomeSortFast(),
		new ShakerSortFast(),
		new StoogeSortFast(),
		new DoubleSelectionSortFast(),
		*/
		//new StoogeSort(),
		//new BogoSort(),
		//new BozoSort(),
		//new SlowSort(),
		
		//new SleepSort(),
		//new CountingSort(LENGTH),
		//new BinSort(LENGTH),
		//new LSDRadixSort(),
	};
	
	public static void main(String[] args) {
		SortTestDriver td = new SortTestDriver();
		td.startDriver();
	}
	
	private void startDriver() {
		for (Sort s : LIST) {
			System.out.print("Method: ");
			System.out.println(s.getName());
			s.printOrder();
			test(s);
			System.out.println("----------------------------------------");
		}
	}
	
	private void test(Sort sort) {
		Test t = new Test();
		int[] arr = t.make(LENGTH);
		t.print(arr);
		
		//long startTime = System.currentTimeMillis();
		long startTime = System.nanoTime();
		int[] result = sort.sort(arr);
		//long endTime = System.currentTimeMillis();
		long endTime = System.nanoTime();
		if (result != null) {
			t.print(result);
			//System.out.println(String.format("Result: %s", t.state(result)));
			System.out.println(String.format("Time: %d ns", endTime - startTime));
		}
	}
}
