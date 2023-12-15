package InsertionSort;

import java.util.Arrays;

import Debug.Log;
import Const.Order;

public class InsertionSort {
	private Order order;
	
	public InsertionSort() {
		setOrder(Order.ASC);
	}
	
	public InsertionSort(Order order) {
		setOrder(order);
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		for (int i = 1; i < dst.length; i++) {
			if ( comp( dst[i-1], dst[i] ) ) {
				insert(dst, i);
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
	
	private void insert(int[] arr, int i) {
		int tmp = arr[i];
		int j = i;
		do {
			arr[j] = arr[j-1];
			j--;
		} while (j > 0 && comp( arr[j - 1], tmp ) );
		arr[j] = tmp;
	}
}