package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;

public class ShakerSort implements Sort {
	private Order order;
	private final String methodName = "Shaker sort";
	
	public ShakerSort() {
		setOrder(Order.ASC);
	}
	
	public ShakerSort(Order order) {
		setOrder(order);
	}
	
	public ShakerSort(boolean order) {
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
		int left = 0;
		int right = dst.length-1;
		
		while (true) {
			int lastSwap;
			
			lastSwap = left;
			for (int i = left; i < right; i++) {
				if ( comp( dst[i], dst[i+1] ) ) {
					swap(dst, i, i+1);
					lastSwap = i;
				}
			}
			right = lastSwap;
			if (right == left) break;
			
			lastSwap = right;
			for (int i = right; i > left; i--) {
				if ( comp( dst[i-1], dst[i] ) ) {
					swap(dst, i-1, i);
					lastSwap = i;
				}
			}
			left = lastSwap;
			if (right == left) break;
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