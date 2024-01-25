package Sort.ShellGapMethodFunc;

public class Sedgewick implements ShellGapMethodFunc {
	private int h;
	private int k;
	
	public Sedgewick() {
		h = -1;
	}
	
	@Override
    public int init(final int n) {
    	k = 0;
    	
		while (h < n) {
			k++;
			h = (int)(Math.pow(4, k) + 3 * Math.pow(2, k-1) + 1);
		}
		return h;
    }
    
	@Override
    public int next() {
    	if (h <= 1) {
    		return -1;
    	} else if (k == 1) {
    		h = 1;
    	} else {
    		k--;
    		h = (int)(Math.pow(4, k) + 3 * Math.pow(2, k-1) + 1);
    	}
    	return h;
    }
}
