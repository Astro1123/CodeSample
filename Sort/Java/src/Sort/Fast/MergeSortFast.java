package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class MergeSortFast extends MergeSort {
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		int[] tmp = new int[src.length];
		
		mergeSort(dst, tmp, 0, dst.length-1);
		
		return dst;
	}
	
	@Override
	protected void merge(int[] arr, int[] tmp, int left, int mid, int right) {
		int lp = left;
		int rp = mid+1;
		int tp = 0;
		
		while ((lp <= mid) && (rp <= right)) {
			if ( arr[lp] <= arr[rp] ) {
				tmp[tp++] = arr[lp++];
			} else {
				tmp[tp++] = arr[rp++];
			}
		}
		while (rp <= right) {
			tmp[tp++] = arr[rp++];
		}
		while (lp <= mid) {
			tmp[tp++] = arr[lp++];
		}
		for (int i = 0; i < tp; i++) {
			arr[left + i] = tmp[i];
		}
	}
}