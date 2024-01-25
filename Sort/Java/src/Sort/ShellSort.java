package Sort;

import java.util.Arrays;

import Debug.Log;
import Sort.Const.Order;
import Sort.Const.ShellGapMethod;

public class ShellSort implements Sort {
	private Order order;
	private ShellGapMethod method;
	protected final String methodName = "Shell sort";
	
	public ShellSort() {
		setOrder(Order.ASC);
		setMethod(ShellGapMethod.SHELL);
	}
	
	public ShellSort(Order order) {
		setOrder(order);
		setMethod(ShellGapMethod.SHELL);
	}
	
	public ShellSort(boolean order) {
		setOrder(order);
		setMethod(ShellGapMethod.SHELL);
	}
	
	public ShellSort(ShellGapMethod method) {
		setOrder(Order.ASC);
		setMethod(method);
	}
	
	public ShellSort(Order order, ShellGapMethod method) {
		setOrder(order);
		setMethod(method);
	}
	
	public ShellSort(boolean order, ShellGapMethod method) {
		setOrder(order);
		setMethod(method);
	}
	
	public ShellSort(int methodID) {
		setOrder(Order.ASC);
		setMethod(ShellGapMethod.valueOf(methodID));
	}
	
	public ShellSort(Order order, int methodID) {
		setOrder(order);
		setMethod(ShellGapMethod.valueOf(methodID));
	}
	
	public ShellSort(boolean order, int methodID) {
		setOrder(order);
		setMethod(ShellGapMethod.valueOf(methodID));
	}
	
	public void setMethod(ShellGapMethod method) {
		this.method = method;
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
	
	public void printMethod() {
		System.out.println(method.toStr());
	}
	
	@Override
	public int[] sort(final int[] src) {
		if (src == null) {
			return null;
		}
		int[] dst = Arrays.copyOf(src, src.length);
		this.method.init(dst.length);
		
		//System.out.println(method);
		int h = this.method.next();
		while (h >= 1) {
			//System.out.println(h);
			for (int i = h; i < dst.length; i++) {
				if ( comp( dst[i - h], dst[i] ) ) {
					insert(dst, i, h);
				}
			}
			h = this.method.next();
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
	
	protected void insert(int[] arr, int i, int h) {
		int tmp = arr[i];
		int j = i;
		do {
			arr[j] = arr[j-h];
			j -= h;
		} while (j >= h && comp( arr[j - h], tmp ) );
		arr[j] = tmp;
	}
}
