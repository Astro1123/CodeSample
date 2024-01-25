package Search;

import java.util.ArrayList;
import Debug.Log;

public class LinearSearch implements Search {
	private final String methodName = "Linear Search";

	@Override
	public int search(final int n, final int[] src) {
		int result = 0;
		while (result < src.length) {
			if (src[result] == n) {
				break;
			}
			result++;
		}
		if (result >= src.length) {
			result = -1;
		}
		return result;
	}
	
	@Override
	public int search(final int n, final ArrayList<Integer> src) {
		int result = 0;
		while (result < src.size()) {
			if (src.get(result) == n) {
				break;
			}
			result++;
		}
		if (result >= src.size()) {
			result = -1;
		}
		return result;
	}
	
	@Override
	public String getName() {
		return methodName;
	}
}
