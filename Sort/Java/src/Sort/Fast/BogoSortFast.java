package Sort.Fast;

import java.util.Arrays;
import java.util.Random;

import Debug.Log;
import Sort.*;

public class BogoSortFast extends BogoSort {
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		while (!isSorted(dst)) {
			shuffle(dst);
		}
		
		return dst;
	}
	
	@Override
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
