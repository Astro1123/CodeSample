package ShellSort;

import java.util.Arrays;

import Debug.Log;
import Const.Order;

public class ShellSort {
	private Order order;
	
	public ShellSort() {
		setOrder(Order.ASC);
	}
	
	public ShellSort(Order order) {
		setOrder(order);
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		int h = (int)(dst.length / 2);
		
		while (h > 0) {
			for (int i = h; i < dst.length; i++) {
				if ( comp( dst[i - h], dst[i] ) ) {
					insert(dst, i, h);
				}
			}
			h /= 2;
		}
		
		return dst;
	}
	
	private boolean comp(int i, int j) {
		if (this.order == Order.ASC) {
			return i > j;
		}
		return i < j;
	}
	
	private void insert(int[] arr, int i, int h) {
		int tmp = arr[i];
		int j = i;
		do {
			arr[j] = arr[j-h];
			j -= h;
		} while (j >= h && comp( arr[j - h], tmp ) );
		arr[j] = tmp;
	}
}