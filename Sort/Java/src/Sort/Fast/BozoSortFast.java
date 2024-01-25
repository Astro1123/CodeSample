package Sort.Fast;

import java.util.Arrays;
import java.util.Random;

import Debug.Log;
import Sort.*;

public class BozoSortFast extends BozoSort {
	@Override
	public int[] sort(final int[] src) {
		int n = src.length;
		int[] dst = Arrays.copyOf(src, n);
		
		while (!isSorted(dst)) {
			int i = rand(0, n - 1);
			int j = rand(0, n - 1);
			swap(dst, i, j);
		}
		
		return dst;
	}
	
	protected boolean isSorted(int[] dst) {
		boolean result = true;
		
		for (int i = 0; i < dst.length - 1; i++) {
			if (dst[i] > dst[i+1]) {
				result = false;
				break;
			}
		}
		return result;
	}
}
