package Sort.Fast;

import java.util.Arrays;
import java.util.Random;

import Debug.Log;
import Sort.*;

public class QuickSortFast extends QuickSort {
	protected final String methodName = "Quick sort (Left)";
	
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		quickSort(dst, 0, dst.length-1);
		
		return dst;
	}
	
	@Override
	protected void quickSort(int[] arr, final int left, final int right) {
		if (left >= right) return;
		int l = left;
		int r = right;
		int p = arr[left];
		while ( true ) {
			while ( arr[l] < p ) {
				l++;
			}
			while ( p < arr[r] ) {
				r--;
			}
			if (l >= r) {
				break;
			}
			swap(arr, l, r);
			l++;
			r--;
		}
		quickSort(arr, left, l-1);
		quickSort(arr, r+1, right);
	}
	
	@Override
	public String getName() {
		return methodName;
	}
}
