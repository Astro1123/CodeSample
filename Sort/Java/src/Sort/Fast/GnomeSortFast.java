package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class GnomeSortFast extends GnomeSort {
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		for (int i = 0; i < dst.length-1; i++) {
			int j = i;
			while (j >= 0) {
				if ( dst[j] <= dst[j+1] ) break;
				swap(dst, j, j+1);
				j--;
			}
		}
		
		return dst;
	}
}
