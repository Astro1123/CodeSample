package Sort.Fast;

import java.util.Arrays;

import Debug.Log;
import Sort.*;

public class ShellSortFastPratt extends ShellSortFast {
	protected final String methodName = "Shell sort (Pratt)";
	@Override
	public int[] sort(final int[] src) {
		int[] dst = Arrays.copyOf(src, src.length);
		int n = dst.length;
		int h = sortSub(n);
		
		while (h > 0) {
			for (int i = h; i < n; i++) {
				if ( dst[i - h] > dst[i] ) {
					insert(dst, i, h);
				}
			}
			h /= 3;
		}
		return dst;
	}
	
	private int sortSub(final int n) {
		int k = 1;
		int h;
		
		do {
			h = ((int)Math.pow(3, k) - 1) / 2;
			k++;
		} while ( h <= Math.ceil((double)n / 3) );
		return h / 3;
	}
	
	@Override
	public String getName() {
		return methodName;
	}
}