package BubbleSort;

import java.util.Arrays;

import Debug.Log;
import Const.Order;

public class BubbleSort {
	private Order order;
	
	public BubbleSort() {
		setOrder(Order.ASC);
	}
	
	public BubbleSort(Order order) {
		setOrder(order);
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		for (int i = 0; i < dst.length-1; i++) {
			for (int j = 1; j < dst.length - i; j++) {
				if ( comp( dst[j-1], dst[j] ) ) {
					swap(dst, j-1, j);
				}
			}
		}
		
		return dst;
	}
	
	private boolean comp(int i, int j) {
		if (this.order == Order.ASC) {
			return i > j;
		}
		return i < j;
	}
	
	private void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
	}
}