package Sort;

import java.util.Arrays;
import java.util.Random;

import Debug.Log;
import Sort.Const.Order;

public class BogoSort implements Sort {
	private Order order;
	private final String methodName = "Bogo sort";
	
	public BogoSort() {
		setOrder(Order.ASC);
	}
	
	public BogoSort(Order order) {
		setOrder(order);
	}
	
	public BogoSort(boolean order) {
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
		
		while (!isSorted(dst)) {
			shuffle(dst);
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
	
	protected void shuffle(int[] arr) {
		for (int i = arr.length - 1; i >= 1; i--) {
			int j = rand(0, i);
			swap(arr, i, j);
		}
	}
	
	private void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
	}
	
	private int rand(int min, int max) {
		Random random = new Random();
		double r = random.nextDouble();
		
		int result = (int)(r * (max + 1 - min) + min);
		return result;
	}
}