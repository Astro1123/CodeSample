package Sort.SortNC;

import Debug.Log;
import Sort.Sort;
import Sort.Const.Order;

public class CountingSort implements Sort {
	private Order order;
	private Counter counter;
	private final String methodName = "Counting sort";
	
	public CountingSort(int max) {
		counter = new Counter(0, max);
		setOrder(Order.ASC);
	}
	
	public CountingSort(int max, Order order) {
		counter = new Counter(0, max);
		setOrder(order);
	}
	
	public CountingSort(int max, boolean order) {
		counter = new Counter(0, max);
		setOrder(order);
	}
	
	public CountingSort(int max, int min) {
		counter = new Counter(min, max);
		setOrder(Order.ASC);
	}
	
	public CountingSort(int max, int min, Order order) {
		counter = new Counter(min, max);
		setOrder(order);
	}
	
	public CountingSort(int max, int min, boolean order) {
		counter = new Counter(min, max);
		setOrder(order);
	}
	
	public void setMin(int min) {
		counter.setMin(min);
	}
	
	public void setMax(int max) {
		counter.setMax(max);
	}
	
	@Override
	public void setOrder(boolean order) {
		this.order = (order ? Order.ASC : Order.DESC);
		counter.setOrder(this.order);
	}
	
	@Override
	public void setOrder(Order order) {
		this.order = order;
		counter.setOrder(this.order);
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
			counter.add(src[i]);
		}
		
		for (int i = 0; i < dst.length; i++) {
			Integer tmp = counter.pull();
			dst[i] = tmp;
		}
		
		return dst;
	}
}

class Counter {
	private int min;
	private int max;
	private int len;
	private int[] counter;
	private SetPos sp;
	
	private enum SetPos {
		HEAD {
			@Override
			int index(int len, int idx) {
				return idx;
			}
		},
		TAIL {
			@Override
			int index(int len, int idx) {
				return len - idx - 1;
			}
		};
		abstract int index(int len, int idx);
	}
	
	public Counter(int min, int max) {
		if (max < min) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		this.min = min;
		this.max = max;
		this.len = this.max + 1 - this.min;
		
		counter = new int[this.len];	
	}
	
	public void setMin(int min) {
		if (this.max < min) {
			this.min = this.max;
			this.max = min;
		} else {
			this.min = min;
		}
		this.len = this.max + 1 - this.min;
		
		counter = new int[this.len];	
	}
	
	public void setAuto(int[] src) {
		int min = src[0];
		int max = src[0];
		for (int i = 1; i < src.length; i++) {
			if (max < src[i]) {
				max = src[i];
			}
			if (min > src[i]) {
				min = src[i];
			}
		}
		this.min = min;
		this.max = max;
		
		this.len = this.max + 1 - this.min;
		
		counter = new int[this.len];	
	}
	
	public void setMax(int max) {
		if (max < this.min) {
			this.max = this.min;
			this.min = max;
		} else {
			this.max = max;
		}
		this.len = this.max + 1 - this.min;
		
		counter = new int[this.len];	
	}
	
	public void setOrder(Order order) {
		if (order == Order.ASC) {
			sp = SetPos.HEAD;
		} else {
			sp = SetPos.TAIL;
		}
	}
	
	public boolean add(int element) {
		counter[element - this.min]++;
		return true;
	}
	
	public int pull() {
		int result = -1 - this.min;
		
		for (int i = 0; i < this.len; i++) {
			int idx = sp.index(this.len, i);
			if (counter[idx] > 0) {
				result = idx + this.min;
				counter[idx]--;
				break;
			}
		}
		return result;
	}
}
