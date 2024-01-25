package Sort.ShellGapMethodFunc;

public class FrankLazarus implements ShellGapMethodFunc {
	private int len;
	private int h;
	private int k;
	
	public FrankLazarus() {
		h = -1;
	}
	
	@Override
    public int init(final int n) {
    	len = n;
		h = 2 * (int)(len / 2) + 1;
		k = 0;
		return h;
    }
    
	@Override
    public int next() {
    	if (h <= 1) {
    		return -1;
    	}
    	k++;
    	h = 2 * (len / (int)Math.pow(2, k+1)) + 1;
    	return h;
    }
}
