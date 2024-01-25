package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class SelectionSortFast extends SelectionSort {
	@Override
	public int[] sort(final int[] src) {
		if (src == null) {
			return null;
		}
		int[] dst = Arrays.copyOf(src, src.length);
		int ext;
		int extpos;
		int i, j;
		
		for (i = 0; i < dst.length-1; i++) {
			ext = dst[i];
			extpos = i;
			for (j = i+1; j < dst.length; j++) {
				if ( ext > dst[j] ) {
					extpos = j;
					ext = dst[j];
				}
			}
			swap(dst, i, extpos);
		}
		
		return dst;
	}
}
