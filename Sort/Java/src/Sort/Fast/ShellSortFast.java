package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class ShellSortFast extends ShellSort {
	protected final String methodName = "Shell sort (Shell)";
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		int n = dst.length;
		int h = n / 2;
		
		while (h > 0) {
			for (int i = h; i < n; i++) {
				if ( dst[i - h] > dst[i] ) {
					insert(dst, i, h);
				}
			}
			h /= 2;
		}
		return dst;
	}
	
	@Override
	public String getName() {
		return methodName;
	}
}
