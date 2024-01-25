package Sort.ShellGapMethodFunc;

public class PaprrnovStasevich implements ShellGapMethodFunc {
	private int h;
	
	public PaprrnovStasevich() {
		h = -1;
	}
	
	@Override
    public int init(final int n) {
    	int k = 1;
    	h = 1;
    	
    	while (h < n) {
			h = (int)(Math.pow(2, k)) + 1;
			k++;
		}
		return h;
    }
    
	@Override
    public int next() {
    	if (h <= 1) {
    		return -1;
    	} else if (h == 3) {
    		h = 1;
    	} else {
    		h >>= 1;
    		h++;
    	}
    	return h;
    }
}
