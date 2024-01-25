package Sort.SortNC;

import java.util.Arrays;

import Debug.Log;
import Sort.Sort;
import Sort.Const.Order;

public class LSDRadixSort implements Sort {
	private Order order;
	private Bin bin;
	private final String methodName = "Radix sort";
	
	public LSDRadixSort() {
		bin = new Bin(0, 9);
		setOrder(Order.ASC);
	}
	
	public LSDRadixSort(Order order) {
		bin = new Bin(0, 9);
		setOrder(order);
	}
	
	public LSDRadixSort(boolean order) {
		bin = new Bin(0, 9);
		setOrder(order);
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
		
		int[] dst = Arrays.copyOf(src, src.length);
		int max = src[0];
		
		for (int i = 1; i < src.length; i++) {
			if (max < src[i]) max = src[i];
		}
		
		int mod = 10;
		int div = 1;
		for (; div <= max; mod *= 10, div *= 10) {
			for (int i = 0; i < dst.length; i++) {
				bin.add(dst[i], (dst[i] % mod) / div);
			}
			
			for (int i = 0; i < dst.length; i++) {
				Integer tmp = bin.pull();
				dst[i] = tmp;
			}
		}
		
		return dst;
	}
}
