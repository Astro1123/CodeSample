package Sort.ShellGapMethodFunc;

import java.util.List;
import java.util.ArrayList;

public class Pratt implements ShellGapMethodFunc {
	private int h;
	
	public Pratt() {
		h = -1;
	}
	
	@Override
    public int init(final int n) {
    	h = 1;
    	int tmp = h;
    	
		while (h < n) {
			while (!is_3smooth(tmp)) {
			    tmp++;
			}
			h = tmp;
			tmp++;
		}
		return h;
    }
    
	@Override
    public int next() {
    	if (h <= 1) return -1;
    	h--;
    	while (!is_3smooth(h)) {
    		h--;
    	}
    	return h;
    }
    
    private boolean is_3smooth(final int n) {
    	int x = n;
    	int i;
    	List<Integer> l = new ArrayList<>();
    	
    	l.add(3);
    	for (i = 0; i < 5 && x % l.get(i) == 0; i++) {
    		l.add(l.get(i) * l.get(i));
    	}
    	
    	while (!l.isEmpty()) {
    		if (x % l.get(l.size()-1) == 0) {
    			x /= l.get(l.size()-1);
    		}
    		l.remove(l.size()-1);
    	}
    	return ((x & x - 1) == 0);
    }
}
