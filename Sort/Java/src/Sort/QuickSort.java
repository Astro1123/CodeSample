package Sort;

import java.util.Arrays;
import java.util.Random;

import Debug.Log;
import Sort.Const.Order;
import Sort.Const.Pivot;
import Sort.Comparator.*;

public class QuickSort implements Sort {
	private Order order;
	private Pivot piv;
	protected final String methodName = "Quick sort";
	private PivotFunc pf;
	
	public QuickSort() {
		setPivot(Pivot.MID);
		setOrder(Order.ASC);
	}
	
	public QuickSort(Order order) {
		setPivot(Pivot.MID);
		setOrder(order);
	}
	
	public QuickSort(boolean order) {
		setPivot(Pivot.MID);
		setOrder(order);
	}
	
	public QuickSort(Pivot piv) {
		setPivot(piv);
		setOrder(Order.ASC);
	}
	
	public QuickSort(Pivot piv, Order order) {
		setPivot(piv);
		setOrder(order);
	}
	
	public QuickSort(Pivot piv, boolean order) {
		setPivot(piv);
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
	
	public void setPivot(Pivot piv) {
		this.piv = piv;
		pf = selectPivot();
	}
	
	@Override
	public int[] sort(final int[] src) {
		if (src == null) {
			return null;
		}
		int[] dst = Arrays.copyOf(src, src.length);
		
		quickSort(dst, 0, dst.length-1);
		
		return dst;
	}
	
	@Override
	public String getName() {
		return methodName;
	}
	
	private PivotFunc selectPivot() {
		PivotFunc pf;
		switch (this.piv) {
			case MEDIAN:
				pf = new MedianFunc();
				break;
			case RAND:
				pf = new RndFunc();
				break;
			case MID:
				pf = new MidFunc();
				break;
			case LEFT:
				pf = new LeftFunc();
				break;
			case RIGHT:
				pf = new RightFunc();
				break;
			default:
				pf = new LeftFunc();
				break;
		}
		return pf;
	}
	
	protected void quickSort(int[] arr, final int left, final int right) {
		if (left >= right) return;
		int l = left;
		int r = right;
		int pivot = pf.func(arr, left, right);
		while ( true ) {
			while ( comp( arr[l], pivot ) ) {
				l++;
			}
			while ( comp( pivot, arr[r] ) ) {
				r--;
			}
			if (l >= r) {
				break;
			}
			swap(arr, l, r);
			l++;
			r--;
		}
		quickSort(arr, left, l-1);
		quickSort(arr, r+1, right);
	}
	
	private boolean comp(int i, int j) {
		return this.order.compR(i, j);
	}
	
	protected void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
	}
	
	private interface PivotFunc {
		public int func(int[] arr, int left, int right);
	}
	
	private class MidFunc implements PivotFunc {
		@Override
		public int func(int[] arr, int left, int right) {
			return arr[(left+right)/2];
		}
	}
	
	private class LeftFunc implements PivotFunc {
		@Override
		public int func(int[] arr, int left, int right) {
			return arr[left];
		}
	}
	
	private class RightFunc implements PivotFunc {
		@Override
		public int func(int[] arr, int left, int right) {
			return arr[right];
		}
	}
	
	private class RndFunc implements PivotFunc {
		@Override
		public int func(int[] arr, int left, int right) {
			return arr[rand(left, right)];
		}
	
		private int rand(int min, int max) {
			Random rand = new Random();
			double r = rand.nextDouble();
			
			int result = (int)(r * (max + 1 - min) + min);
			return result;
		}
	}
	
	private class MedianFunc implements PivotFunc {
		@Override
		public int func(int[] arr, int left, int right) {
			int p = -1;
			int l = arr[left];
			int r = arr[right];
			int m = arr[(left + right) / 2];
			
			if (l <= m) {
				if (m <= r) {
					p = m;
				} else if (r <= l) {
					p = l;
				} else {
					p = r;
				}
			} else {
				if (r <= m) {
					p = m;
				} else if (l <= r) {
					p = l;
				} else {
					p = r;
				}
			}
			return p;
		}
	}
}
