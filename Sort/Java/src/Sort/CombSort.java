package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;

public class CombSort implements Sort {
	private Order order;
	private final String methodName = "Comb sort";
	
	public CombSort() {
		setOrder(Order.ASC);
	}
	
	public CombSort(Order order) {
		setOrder(order);
	}
	
	public CombSort(boolean order) {
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
		int[] dst = Arrays.copyOf(src, src.length);
		int h = dst.length;
		boolean swapped = false;
		
		while (h > 1 || swapped) {
			swapped = false;
			if (h > 1) {
				h = (int)(h / 1.3);
			}
			for (int j = h; j < dst.length; j++) {
				if ( comp( dst[j-h], dst[j] ) ) {
					swap(dst, j-h, j);
					swapped = true;
				}
			}
		}
		
		return dst;
	}
	
	@Override
	public String getName() {
		return methodName;
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