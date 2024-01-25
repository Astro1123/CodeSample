package Sort.SortNC;

import Debug.Log;
import Sort.Sort;
import Sort.Const.Order;

public class BinSort implements Sort {
	private Order order;
	private Bin bin;
	private final String methodName = "Bin sort (Bucket sort)";
	
	public BinSort(int max) {
		bin = new Bin(0, max);
		setOrder(Order.ASC);
	}
	
	public BinSort(int max, Order order) {
		bin = new Bin(0, max);
		setOrder(order);
	}
	
	public BinSort(int max, boolean order) {
		bin = new Bin(0, max);
		setOrder(order);
	}
	
	public BinSort(int max, int min) {
		bin = new Bin(min, max);
		setOrder(Order.ASC);
	}
	
	public BinSort(int max, int min, Order order) {
		bin = new Bin(min, max);
		setOrder(order);
	}
	
	public BinSort(int max, int min, boolean order) {
		bin = new Bin(min, max);
		setOrder(order);
	}
	
	public void setMin(int min) {
		bin.setMin(min);
	}
	
	public void setMax(int max) {
		bin.setMax(max);
	}
	
	@Override
	public void setOrder(boolean order) {
		this.order = (order ? Order.ASC : Order.DESC);
		bin.setOrder(this.order);
	}
	
	@Override
	public void setOrder(Order order) {
		this.order = order;
		bin.setOrder(this.order);
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
	public String getName() {
		return methodName;
	}
	
	@Override
	public int[] sort(final int[] src) {
		if (src == null) {
			return null;
		}
		
		int[] dst = new int[src.length];
		
		for (int i = 0; i < src.length; i++) {
			bin.add(src[i]);
		}
		
		for (int i = 0; i < dst.length; i++) {
			Integer tmp = bin.pull();
			dst[i] = tmp;
		}
		
		return dst;
	}
}
