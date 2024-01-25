package Sort.Const;

import Sort.Comparator.*;

public enum Order {
	ASC ( new AscComparator() ),		//Ascending
	DESC ( new DescComparator() );	//Descending

    public final Comparator comp;

    Order(Comparator comp) {
        this.comp = comp;
    }

   public  boolean comp(int i, int j) {
        return this.comp.func(i, j);
    }

   public  boolean compR(int i, int j) {
        return this.comp.funcR(i, j);
    }
}
