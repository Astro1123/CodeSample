package Sort.SortNC;

import java.util.ArrayList;
import java.util.List;
import Sort.Const.Order;

class Bin {
	private int min;
	private int max;
	private int len;
	private List<List<Integer>> bin;
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
	
	public Bin(int min, int max) {
		if (max < min) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		this.min = min;
		this.max = max;
		
		make();
	}
	
	private void make() {
		this.len = max + 1 - min;
		bin = new ArrayList<>();
		for (int i = 0; i < this.len; i++) {
			bin.add(new ArrayList<>());
		}
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
		
		make();
	}
	
	public void setMin(int min) {
		if (this.max < min) {
			this.min = this.max;
			this.max = min;
		} else {
			this.min = min;
		}
		make();
	}
	
	public void setMax(int max) {
		if (max < this.min) {
			this.max = this.min;
			this.min = max;
		} else {
			this.max = max;
		}
		make();
	}
	
	public void setOrder(Order order) {
		if (order == Order.ASC) {
			sp = SetPos.HEAD;
		} else {
			sp = SetPos.TAIL;
		}
	}
	
	public boolean add(int element) {
		bin.get(element - this.min).add(element);
		return true;
	}
	
	public boolean add(int element, int key) {
		bin.get(key).add(element);
		return true;
	}
	
	public int pull() {
		int result = -1-this.min;
		
		for (int i = 0, j = 0; i < len; i++) {
			int idx = sp.index(len, i);
			if (bin.get(idx).size() > 0) {
				result = bin.get(idx).remove(0);
				break;
			}
		}
		return result;
	}
}
