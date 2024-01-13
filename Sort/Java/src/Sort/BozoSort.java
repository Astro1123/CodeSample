package Sort;

import java.util.Arrays;
import java.util.Random;

import Debug.Log;
import Sort.Const.Order;

public class BozoSort implements Sort {
	private Order order;
	private final String methodName = "Bozo sort";
	
	public BozoSort() {
		setOrder(Order.ASC);
	}
	
	public BozoSort(Order order) {
		setOrder(order);
	}
	
	public BozoSort(boolean order) {
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
		
		while (!isSorted(dst)) {
			int i = rand(0, n - 1);
			int j = rand(0, n - 1);
			swap(dst, i, j);
		}
		
		return dst;
	}
	
	protected boolean isSorted(int[] dst) {
		boolean result = true;
		
		for (int i = 0; i < dst.length - 1; i++) {
			if (comp(dst[i], dst[i+1])) {
				result = false;
				break;
			}
		}
		return result;
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
	
	protected int rand(int min, int max) {
		Random random = new Random();
		double r = random.nextDouble();
		if (min > max) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		int result = (int)(r * (max + 1 - min) + min);
		return result;
	}
}