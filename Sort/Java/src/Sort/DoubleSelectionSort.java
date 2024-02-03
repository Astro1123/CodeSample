package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;

public class DoubleSelectionSort implements Sort {
	private Order order;
	private final String methodName = "Double Selection sort";
	
	public DoubleSelectionSort() {
		setOrder(Order.ASC);
	}
	
	public DoubleSelectionSort(Order order) {
		setOrder(order);
	}
	
	public DoubleSelectionSort(boolean order) {
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
		int l_extpos;
		int r_extpos;
		int i, j;
		
		for (i = 0; i < dst.length / 2; i++) {
			l_extpos = i;
			r_extpos = dst.length - (i + 1);
			for (j = i+1; j < dst.length-i; j++) {
				if ( comp( dst[l_extpos], dst[j] ) ) {
					l_extpos = j;
				}
				if ( comp( dst[j], dst[r_extpos] ) ) {
					r_extpos = j;
				}
			}
			if (r_extpos == i) {
				r_extpos = l_extpos;
			}
			swap(dst, i, l_extpos);
			swap(dst, dst.length-(i+1), r_extpos);
		}
		
		return dst;
	}
	
	@Override
	public String getName() {
		return methodName;
	}
	
	private boolean comp(int i, int j) {
		return this.order.comp(i, j);
	}
	
	protected void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
	}
}
