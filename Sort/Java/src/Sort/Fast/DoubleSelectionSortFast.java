package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class DoubleSelectionSortFast extends DoubleSelectionSort {
	@Override
	public int[] sort(final int[] src) {
		if (src == null) {
			return null;
		}
		int[] dst = Arrays.copyOf(src, src.length);
		int minpos;
		int maxpos;
		int i, j;
		
		for (i = 0; i < dst.length / 2; i++) {
			minpos = i;
			maxpos = dst.length - (i + 1);
			for (j = i+1; j < dst.length-i; j++) {
				if ( dst[minpos] > dst[j] ) {
					minpos = j;
				}
				if ( dst[maxpos] < dst[j] ) {
					maxpos = j;
				}
			}
			if (maxpos == i) {
				maxpos = minpos;
			}
			swap(dst, i, minpos);
			swap(dst, dst.length - (i + 1), maxpos);
		}
		
		return dst;
	}
}
