package Search;

import java.util.ArrayList;
import Debug.Log;
import Search.Const.Order;

public class BinarySearch implements Search {
	private final String methodName = "Binary Search";
	private Order order;
	
	public BinarySearch() {
		setOrder(Order.ASC);
	}
	
	public BinarySearch(Order order) {
		setOrder(order);
	}
	
	public BinarySearch(boolean border) {
		setOrder(border);
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void setOrder(boolean border) {
		this.order = (border ? Order.ASC : Order.DESC);
	}
	
	@Override
	public int search(final int n, final int[] src) {
		int result = -1;
		int left = 0;
		int right = src.length;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid < 0 || mid >= src.length) {
				break;
			} else if (src[mid] == n) {
				result = mid;
				break;
			} else if (src[mid] < n) {
				if (this.order == Order.ASC) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (this.order == Order.ASC) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return result;
	}
	
	@Override
	public int search(final int n, final ArrayList<Integer> src) {
		int result = -1;
		int left = 0;
		int right = src.size();
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid < 0 || mid >= src.size()) {
				break;
			} else if (src.get(mid) == n) {
				result = mid;
				break;
			} else if (src.get(mid) < n) {
				if (this.order == Order.ASC) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (this.order == Order.ASC) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return result;
	}
	
	@Override
	public String getName() {
		return methodName;
	}
}