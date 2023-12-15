package HeapSort;

import java.util.Arrays;

import Debug.Log;
import Const.Order;

public class HeapSort {
	private Order order;
	
	public HeapSort() {
		setOrder(Order.ASC);
	}
	
	public HeapSort(Order order) {
		setOrder(order);
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		
		int i;
		int tmp;
		
		for (i = (dst.length-1) / 2; i >= 0; i--) {
			extHeap(dst, i, dst.length - 1);
		}
		
		for (i = dst.length-1; i > 0; i--) {
			tmp = dst[0];
			dst[0] = dst[i];
			dst[i] = tmp;
			extHeap(dst, 0, i - 1);
		}
		
		return dst;
	}
	
	private void extHeap(int[] arr, int root, int bottom) {
		int child = (2 * root) + 1;
		int tmp = arr[root];
		
		while (child <= bottom) {
			if (child < bottom && comp( arr[child + 1], arr[child] ) ) {
				child = child + 1;
			}
			if ( comp( tmp, arr[child] ) ) {
				break;
			} else {
				arr[(child - 1) / 2] = arr[child];
				child = (2 * child) + 1;
			}
		}
		arr[(child - 1) / 2] = tmp;
		return;
	}
	
	private boolean comp(int i, int j) {
		if (this.order == Order.ASC) {
			return i > j;
		}
		return i < j;
	}
}