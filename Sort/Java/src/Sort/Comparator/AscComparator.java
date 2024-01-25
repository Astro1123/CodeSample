package Sort.Comparator;

public class AscComparator implements Comparator {
    
    @Override
    public boolean func(int i, int j) {
    	return i > j;
    }
    
    @Override
    public boolean funcR(int i, int j) {
    	return i < j;
    }
}
