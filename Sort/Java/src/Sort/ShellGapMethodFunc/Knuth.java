package Sort.ShellGapMethodFunc;

public class Knuth implements ShellGapMethodFunc {
	private int h;
	
	public Knuth() {
		h = -1;
	}
	
	@Override
    public int init(final int n) {
		int k = 1;
		
		do {
			h = ((int)Math.pow(3, k) - 1) / 2;
			k++;
		} while ( h <= Math.ceil((double)n / 3) );
		return h;
    }
    
	@Override
    public int next() {
    	if (h <= 1) return -1;
    	h /= 3;
    	return h;
    }
}
