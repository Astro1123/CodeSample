import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Collatz {
	private final int LOOP_MAX = 10000;
	private final int MAX_LEN = 60;
	
	private class Data {
		boolean result;
		int num;
	}
	
	public static void main(String[] args) {
		Collatz c = new Collatz();
		c.start();
	}
	
	private void start() {
		System.out.println("");
		Data result = input();
		System.out.println("");
		if (!result.result) {
			return;
		}
		calc(result.num);
	}
	
	private void calc(int num) {
		List<Integer> list = new ArrayList<>();
		int n = num;
		for (int i = 0; i < LOOP_MAX; i++) {
			if (list.contains(n)) break;
			list.add(n);
			n = collatz(n);
		}
		print(list);
		list.clear();
		list = null;
	}
	
	private void print(List<Integer> list) {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		int max = list.get(0);
		int min = list.get(0);
		
		for (int n : list) {
			sb.append(String.format("%d", n));
			if (list.get(list.size()-1) == n) {
				System.out.println(sb.toString());
				sb.setLength(0);
			} else if (sb.length() <= MAX_LEN) {
				sb.append(", ");
			} else {
				sb.append(", ");
				System.out.println(sb.toString());
				sb.setLength(0);
			}
			if (max < n) max = n;
			if (max > n) min = n;
		}
		System.out.println("");
		System.out.printf("max: %d\n", max);
		System.out.printf("min: %d\n", min);
		System.out.println("");
	}
	
	private int collatz(int n) {
		int result;
		if (n % 2 == 0) {
			result = n / 2;
		} else {
			result = n * 3 + 1;
		}
		return result;
	}
	
	private Data input() {
		Scanner scanner = new Scanner(System.in);
		String inputStr = null;
		System.out.print("Start: ");
		inputStr = scanner.next();
		return StrToInt(inputStr);
	}
	
	private Data StrToInt(String str) {
		Data result = new Data();
		try {
			result.num = Integer.parseInt(str);
			result.result = true;
		} catch (NumberFormatException e) {
			result.num = 0;
			result.result = false;
            e.printStackTrace();
		}
		return result;
	}
}
