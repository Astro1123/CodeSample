package Sort.ShellGapMethodFunc;

public class Shell implements ShellGapMethodFunc {
	private int h;
	
	public Shell() {
		h = -1;
	}
	
	@Override
    public int init(final int length) {
    	h = length;
    	return h;
    }
    
	@Override
    public int next() {
    	if (h <= 0) return -1;
    	h >>= 1;
    	return h;
    }
}
