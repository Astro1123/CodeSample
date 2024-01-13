package Sort;

//import java.util.List;

import Sort.Const.Order;

public interface Sort {
	public String getName();
	public void setOrder(Order order);
	public void setOrder(boolean order);
	public void printOrder();
	//public Order getOrder();
	//public float[] sort(final float[] src);
	//public double[] sort(final double[] src);
	//public byte[] sort(final byte[] src);
	//public char[] sort(final char[] src);
	//public short[] sort(final short[] src);
	public int[] sort(final int[] src);
	//public int[] sortFast(final int[] src);
	//public long[] sort(final long[] src);
	//public List<T> sort(final List<T> src);
}