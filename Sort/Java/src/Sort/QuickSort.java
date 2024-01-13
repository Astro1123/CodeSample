package Sort;

import java.util.Arrays;
import java.util.Random;

import Debug.Log;
import Sort.Const.Order;
import Sort.Const.Pivot;

public class QuickSort implements Sort {
	private Order order;
	private Pivot piv = Pivot.MEDIAN;
	protected final String methodName = "Quick sort";
	
	public QuickSort() {
		setOrder(Order.ASC);
	}
	
	public QuickSort(Order order) {
		setOrder(order);
	}
	
	public QuickSort(boolean order) {
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
	
	protected void quickSort(int[] arr, final int left, final int right) {
		if (left >= right) return;
		PivInfo pivot;
		int l = left;
		int r = right;
		pivot = selPivot(arr, left, right);
		while ( true ) {
			while ( comp( arr[l], pivot.value ) ) {
				l++;
			}
			while ( comp( pivot.value, arr[r] ) ) {
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
		if (this.order == Order.ASC) {
			return i < j;
		}
		return i > j;
	}
	
	protected void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
	}
	
	private PivInfo selPivot(int[] arr, int left, int right) {
		PivInfo p;
		switch (this.piv) {
			case MEDIAN:
				p = median(arr, left, right);
				break;
			case RAND:
				int tmp = rand(left, right);
				p = new PivInfo( arr[tmp], tmp );
				break;
			case MID:
				int mid = (left + right) / 2;
				p = new PivInfo( arr[mid], mid );
				break;
			case LEFT:
				p = new PivInfo( arr[left], left );
				break;
			case RIGHT:
				p = new PivInfo( arr[right], right );
				break;
			default:
				p = new PivInfo( arr[left], left );
				break;
		}
		return p;
	}
	
	private PivInfo median(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		PivInfo[] p = new PivInfo[3];
		p[0] = new PivInfo(arr[left], left);
		p[1] = new PivInfo(arr[mid], mid);
		p[2] = new PivInfo(arr[right], right);
		
		int max;
		int pos;
		for (int i = 0; i < 2; i++) {
			max = p[0].value;
			pos = 0;
			for (int j = 1; j < 3-i; j++) {
				if (max < p[j].value) {
					max = p[j].value;
					pos = j;
				}
			}
			PivInfo tmp = p[2-i];
			p[2-i] = p[pos];
			p[pos] = tmp;
		}
		return p[1];
	}
	
	private int rand(int min, int max) {
		Random rand = new Random();
		double r = rand.nextDouble();
		if (min > max) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		int result = (int)(r * (max + 1 - min) + min);
		return result;
	}
	
	private class PivInfo {
		int value;
		int pos;
		
		public PivInfo() {}
		
		public PivInfo(int value, int pos) {
			this.value = value;
			this.pos = pos;
		}
	}
}