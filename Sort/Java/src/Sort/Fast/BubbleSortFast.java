package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class BubbleSortFast extends BubbleSort {
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		for (int i = 0; i < dst.length-1; i++) {
			for (int j = 1; j < dst.length - i; j++) {
				if ( dst[j-1] > dst[j] ) {
					swap(dst, j-1, j);
				}
			}
		}
		
		return dst;
	}
}
