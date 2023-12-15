package Test;

import java.util.Random;

public class Test {
	public int[] make(final int len) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = i + 1;
		}
		shuffle(arr);
		return arr;
	}
	
	public int[] make(final int len, int count) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = i + 1;
		}
		shuffleCount(arr, count);
		return arr;
	}
	
	public int[] make2(final int len, int max, int min) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = rand(min, max);
		}
		return arr;
	}
	
	public void print(final int[] arr) {
		if (arr == null || arr.length <= 0) {
			return;
		}
		
		System.out.print("[ ");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.printf("%d, ", arr[i]);
		}
		System.out.printf("%d ]\n", arr[arr.length-1]);
	}
	
	private void shuffle(int[] arr) {
		for (int i = arr.length - 1; i >= 1; i--) {
			int j = rand(0, i);
			swap(arr, i, j);
		}
	}
	
	private void shuffleCount(int[] arr, int count) {
		for (int i = 0; i < count; i--) {
			int j = rand(0, arr.length);
			int k = rand(0, arr.length);
			swap(arr, j, k);
		}
	}
	
	private void swap(int[] arr, int e1, int e2) {
		int tmp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = tmp;
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
}