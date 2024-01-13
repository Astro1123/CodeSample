package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;

public class SlowSort implements Sort {
	private Order order;
	private final String methodName = "Slow sort";
	
	public SlowSort() {
		setOrder(Order.ASC);
	}
	
	public SlowSort(Order order) {
		setOrder(order);
	}
	
	public SlowSort(boolean order) {
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
		int n = src.length;
		int[] dst = Arrays.copyOf(src, n);
		
		slowSort(dst, 0, n-1);
		
		return dst;
	}
	
	protected void slowSort(int[] dst, final int left, final int right) {
		if (left >= right) {
			return;
		}
		int mid = (int)(left + right) / 2;
		slowSort(dst, left, mid);
		slowSort(dst, mid+1, right);
		if (comp(dst[mid], dst[right])) {
			swap(dst, mid, right);
		}
		slowSort(dst, left, right-1);
	}
	
	@Override
	public String getName() {
		return methodName;
	}
	
	protected boolean comp(int i, int j) {
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