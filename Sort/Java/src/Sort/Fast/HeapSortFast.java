package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class HeapSortFast extends HeapSort {
	@Override
	protected void extHeap(int[] arr, int root, int bottom) {
		int child = (2 * root) + 1;
		int tmp = arr[root];
		
		while (child <= bottom) {
			if (child < bottom && arr[child + 1] > arr[child] ) {
				child = child + 1;
			}
			if ( tmp > arr[child] ) {
				break;
			} else {
				arr[(child - 1) / 2] = arr[child];
				child = (2 * child) + 1;
			}
		}
		arr[(child - 1) / 2] = tmp;
		return;
	}
}