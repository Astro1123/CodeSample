package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class CombSortFast extends CombSort {
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		int h = dst.length;
		boolean swapped = false;
		
		while (h > 1 || swapped) {
			swapped = false;
			if (h > 1) {
				h = (int)(h / 1.3);
			}
			for (int j = h; j < dst.length; j++) {
				if ( dst[j-h] > dst[j] ) {
					swap(dst, j-h, j);
					swapped = true;
				}
			}
		}
		
		return dst;
	}
}
