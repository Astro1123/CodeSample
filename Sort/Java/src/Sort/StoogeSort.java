package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;

public class StoogeSort implements Sort {
	private Order order;
	private final String methodName = "Stooge sort";
	
	public StoogeSort() {
		setOrder(Order.ASC);
	}
	
	public StoogeSort(Order order) {
		setOrder(order);
	}
	
	public StoogeSort(boolean order) {
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
		
		stoogeSort(dst, 0, dst.length - 1);
		
		return dst;
	}
	
	protected void stoogeSort(int[] dst, final int left, final int right) {
		if (comp(dst[left], dst[right])) {
			swap(dst, left, right);
		}
		if (right - left + 1 >= 3) {
			int t = (right - left + 1) / 3;
			stoogeSort(dst, left, right - t);
			stoogeSort(dst, left + t, right);
			stoogeSort(dst, left, right - t);
		}
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
	
	protected void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
	}
}