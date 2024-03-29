package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;

public class HeapSort implements Sort {
	private Order order;
	private final String methodName = "Heap sort";
	
	public HeapSort() {
		setOrder(Order.ASC);
	}
	
	public HeapSort(Order order) {
		setOrder(order);
	}
	
	public HeapSort(boolean order) {
		setOrder(order);
	}
	
	@Override
	public void setOrder(boolean order) {
		this.order = (order ? Order.ASC : Order.DESC);
	}
	
	@Override
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public void printOrder() {
		if (order == Order.ASC) {
			System.out.println("Order: Ascending");
		} else {
			System.out.println("Order: Descending");
		}
	}
	
	@Override
	public int[] sort(final int[] src) {
		if (src == null) {
			return null;
		}
		int[] dst = Arrays.copyOf(src, src.length);
		
		int i;
		int tmp;
		
		for (i = (dst.length / 2) - 1; i >= 0; i--) {
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
		
	@Override
	public String getName() {
		return methodName;
	}
	
	protected void extHeap(int[] arr, int root, int bottom) {
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
		return this.order.comp(i, j);
	}
}
