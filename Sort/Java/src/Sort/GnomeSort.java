package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;
import Sort.Comparator.*;

public class GnomeSort implements Sort {
	private Order order;
	private final String methodName = "Gnome sort";
	
	public GnomeSort() {
		setOrder(Order.ASC);
	}
	
	public GnomeSort(Order order) {
		setOrder(order);
	}
	
	public GnomeSort(boolean order) {
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
		
		for (int i = 0; i < dst.length-1; i++) {
			int j = i;
			while (j >= 0) {
				if ( comp( dst[j], dst[j+1] ) ) break;
				swap(dst, j, j+1);
				j--;
			}
		}
		
		return dst;
	}
	
	@Override
	public String getName() {
		return methodName;
	}
	
	private boolean comp(int i, int j) {
		return !this.order.comp(i, j);
	}
	
	protected void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
	}
}
