package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;

public class InsertionSort implements Sort {
	private Order order;
	private final String methodName = "Insertion sort";
	
	public InsertionSort() {
		setOrder(Order.ASC);
	}
	
	public InsertionSort(Order order) {
		setOrder(order);
	}
	
	public InsertionSort(boolean order) {
		setOrder(order);
	}
	
	@Override
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public void setOrder(boolean order) {
		this.order = (order ? Order.ASC : Order.DESC);
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
		
		for (int i = 1; i < dst.length; i++) {
			if ( comp( dst[i-1], dst[i] ) ) {
				insert(dst, i);
			}
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
	
	protected void insert(int[] arr, int i) {
		int tmp = arr[i];
		int j = i;
		do {
			arr[j] = arr[j-1];
			j--;
		} while (j > 0 && comp( arr[j - 1], tmp ) );
		arr[j] = tmp;
	}
}
