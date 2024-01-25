package Sort.ShellGapMethodFunc;

public class Hibbard implements ShellGapMethodFunc {
	private int h;
	
	public Hibbard() {
		h = -1;
	}
	
	@Override
    public int init(final int n) {
    	int k = 1;
    	h = 1;
    	
    	while (h < n) {
			h = (int)(Math.pow(2, k)) - 1;
			k++;
		}
		return h;
    }
    
	@Override
    public int next() {
    	if (h <= 0) return -1;
    	h >>= 1;
    	return h;
    }
}
