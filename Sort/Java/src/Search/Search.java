package Search;

import java.util.ArrayList;

public interface Search {
	public String getName();
	public int search(final int n, final int[] src);
	public int search(final int n, final ArrayList<Integer> src);
}