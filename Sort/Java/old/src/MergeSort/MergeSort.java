package MergeSort;

import java.util.Arrays;

import Debug.Log;
import Const.Order;

public class MergeSort {
	private Order order;
	
	public MergeSort() {
		setOrder(Order.ASC);
	}
	
	public MergeSort(Order order) {
		setOrder(order);
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		int[] tmp = new int[src.length];
		
		mergeSort(dst, tmp, 0, dst.length-1);
		
		return dst;
	}
	
	private void mergeSort(int[] arr, int[] tmp, int left, int right) {
		int mid;
		if (right > left) {
			mid = (right + left) / 2;
			mergeSort(arr, tmp, left, mid);
			mergeSort(arr, tmp, mid+1, right);
			
			merge(arr, tmp, left, mid, right);
		}
	}
	
	private void merge(int[] arr, int[] tmp, int left, int mid, int right) {
		int lp = left;
		int rp = mid+1;
		int tp = 0;
		
		while ((lp <= mid) && (rp <= right)) {
			if ( comp( arr[lp], arr[rp] ) ) {
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
	
	private boolean comp(int i, int j) {
		if (this.order == Order.ASC) {
			return i <= j;
		}
		return i >= j;
	}
}