package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class ShakerSortFast extends ShakerSort {
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		int left = 0;
		int right = dst.length-1;
		
		while (true) {
			int lastSwap;
			
			lastSwap = left;
			for (int i = left; i < right; i++) {
				if ( dst[i] > dst[i+1] ) {
					swap(dst, i, i+1);
					lastSwap = i;
				}
			}
			right = lastSwap;
			if (right == left) break;
			
			lastSwap = right;
			for (int i = right; i > left; i--) {
				if ( dst[i-1] > dst[i] ) {
					swap(dst, i-1, i);
					lastSwap = i;
				}
			}
			left = lastSwap;
			if (right == left) break;
		}
		return dst;
	}
}
