package Sort;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

import Debug.Log;
import Sort.Const.Order;
import Sort.Const.ShellGapMethod;

public class ShellSort implements Sort {
	private Order order;
	private ShellGapMethod method;
	protected final String methodName = "Shell sort";
	private Deque<Integer> queue;
	
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
		makeQueue(dst.length);
		
		if (this.queue == null) {
			return null;
		}
		while (this.queue.size() > 0) {
			int h = this.queue.removeLast();
			for (int i = h; i < dst.length; i++) {
				if ( comp( dst[i - h], dst[i] ) ) {
					insert(dst, i, h);
				}
			}
		}
		
		return dst;
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
	
	protected void insert(int[] arr, int i, int h) {
		int tmp = arr[i];
		int j = i;
		do {
			arr[j] = arr[j-h];
			j -= h;
		} while (j >= h && comp( arr[j - h], tmp ) );
		arr[j] = tmp;
	}
	
	private void makeQueue(final int len) {
		if (len <= 0) {
			this.queue = null;
			return;
		}
		this.queue = new ArrayDeque<>();
		int gap;
		switch (this.method) {
			case SHELL: {
				gap = len;
				do {
					gap = (int)(gap / 2);
					this.queue.addLast(gap);
				} while(gap > 1);
				break;
			}
			case FRANK_LAZARUS: {
				int k = 1;
				do {
					gap = 2 * (int)(len / Math.pow(2, k+1)) + 1;
					k++;
					this.queue.addLast(gap);
				} while(gap > 1);
				break;
			}
			case KNUTH: {
				int k = 1;
				while (true) {
					gap = (int)((Math.pow(3, k) - 1) / 2);
					k++;
					if (gap <= Math.ceil(len / 3)) {
						this.queue.addFirst(gap);
					} else {
						break;
					}
				}
				break;
			}
			case HIBBARD: {
				int k = 1;
				while (true) {
					gap = (int)(Math.pow(2, k) - 1);
					k++;
					if (gap < len) {
						this.queue.addFirst(gap);
					} else {
						break;
					}
				}
				break;
			}
			case PAPERNOV_STASEVICH: {
				int k = 1;
				this.queue.addLast(1);
				while (true) {
					gap = (int)(Math.pow(2, k) + 1);
					k++;
					if (gap < len) {
						this.queue.addFirst(gap);
					} else {
						break;
					}
				}
				break;
			}
			case SEDGEWICK: {
				int k = 1;
				this.queue.addLast(1);
				while (true) {
					gap = (int)(Math.pow(4, k) + 3 * Math.pow(2, k-1) + 1);
					k++;
					if (gap < len) {
						this.queue.addFirst(gap);
					} else {
						break;
					}
				}
				break;
			}
			default:
				this.queue = null;
				break;
		}
	}
}