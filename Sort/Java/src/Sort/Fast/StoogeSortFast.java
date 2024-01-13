package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class StoogeSortFast extends StoogeSort {
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		stoogeSort(dst, 0, dst.length - 1);
		
		return dst;
	}
	
	@Override
	protected void stoogeSort(int[] dst, final int left, final int right) {
		if (dst[left] > dst[right]) {
			swap(dst, left, right);
		}
		if (right - left + 1 >= 3) {
			int t = (right - left + 1) / 3;
			stoogeSort(dst, left, right - t);
			stoogeSort(dst, left + t, right);
			stoogeSort(dst, left, right - t);
		}
	}
}