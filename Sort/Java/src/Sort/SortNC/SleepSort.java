package Sort.SortNC;

import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import Debug.Log;
import Sort.Sort;
import Sort.Const.Order;

public class SleepSort implements Sort {
	private Order order;
	private final String methodName = "Sleep sort";
	
	public SleepSort() {
		setOrder(Order.ASC);
	}
	
	public SleepSort(Order order) {
		setOrder(order);
	}
	
	public SleepSort(boolean order) {
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
	public String getName() {
		return methodName;
	}
	
	@Override
	public int[] sort(final int[] src) {
		if (src == null) {
			return null;
		}
		
		List<Integer> l = new ArrayList<>();
		
		sleepThread[] thread = new sleepThread[src.length];
		for (int i = 0; i < src.length; i++) {
			if (src[i] < 0) {
				return null;
			}
			thread[i] = new sleepThread(l, src[i], order);
		}
		for (int i = 0; i < src.length; i++) {
			thread[i].start();
		}
		for (int i = 0; i < src.length; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
			}
		}
		
		int[] dst = new int[src.length];
		for (int i = 0; i < src.length; i++) {
			try {
				dst[i] = l.get(i);
			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		return dst;
	}
	
	private class sleepThread extends Thread {
		private List<Integer> list;
		int num;
		SetPos sp;
		
		private enum SetPos {
			HEAD {
				@Override
				void add(List<Integer> list, int num) {
					list.add(0, num);
				}
			},
			TAIL {
				@Override
				void add(List<Integer> list, int num) {
					list.add(num);
				}
			};
			abstract void add(List<Integer> list, int num);
		}
		
		public sleepThread(List<Integer> list, int num, Order order) {
			this.list = list;
			this.num = num;
			if (order == Order.ASC) {
				sp = SetPos.TAIL;
			} else {
				sp = SetPos.HEAD;
			}
		}
		
		public void run() {
			try {
				TimeUnit.MILLISECONDS.sleep(num*10);
			} catch (InterruptedException e) {
			}
			set(num);
		}
		
		private synchronized void set(int num) {
			sp.add(list, num);
		}
	}
}
