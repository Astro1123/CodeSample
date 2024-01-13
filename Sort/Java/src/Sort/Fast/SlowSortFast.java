package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class SlowSortFast extends SlowSort {
	@Override
	public int[] sort(final int[] src) {
		int n = src.length;
		int[] dst = Arrays.copyOf(src, n);
		
		slowSort(dst, 0, n-1);
		
		return dst;
	}
	
	@Override
	protected void slowSort(int[] dst, final int left, final int right) {
		if (left >= right) {
			return;
		}
		int mid = (int)(left + right) / 2;
		slowSort(dst, left, mid);
		slowSort(dst, mid+1, right);
		if (dst[mid] > dst[right]) {
			swap(dst, mid, right);
		}
		slowSort(dst, left, right-1);
	}
}