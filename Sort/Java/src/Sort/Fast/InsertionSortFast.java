package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class InsertionSortFast extends InsertionSort {
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		for (int i = 1; i < dst.length; i++) {
			if ( dst[i-1] > dst[i] ) {
				insert(dst, i);
			}
		}
		
		return dst;
	}
	
	@Override
	protected void insert(int[] arr, int i) {
		int tmp = arr[i];
		int j = i;
		do {
			arr[j] = arr[j-1];
			j--;
		} while (j > 0 && arr[j - 1] > tmp );
		arr[j] = tmp;
	}
}
