package GnomeSort;

import java.util.Arrays;

import Debug.Log;
import Const.Order;

public class GnomeSort {
	private Order order;
	
	public GnomeSort() {
		setOrder(Order.ASC);
	}
	
	public GnomeSort(Order order) {
		setOrder(order);
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		for (int i = 0; i < dst.length-1; i++) {
			int j = i;
			while (j >= 0) {
				if ( comp( dst[j], dst[j+1] ) ) break;
				swap(dst, j, j+1);
				j--;
			}
		}
		
		return dst;
	}
	
	private boolean comp(int i, int j) {
		if (this.order == Order.ASC) {
			return i <= j;
		}
		return i >= j;
	}
	
	private void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
	}
}