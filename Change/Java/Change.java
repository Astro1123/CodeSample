import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {
	final int[] money = {10000, 5000, 2000, 1000, 500, 100, 50, 10, 5, 1};
	int[] change;
	int price;
	int payment;
	String[] args;
	
	public Change(String[] args) {
		this.args = args;
	}
	
	public int start() {
		int result = checkArgs();
		if (result < 0) {
			return -1;
		}
		
		if (payment < price) {
			return -2;
		}
		
		calcChange();
		output();
		
		return 0;
	}
	
	private void output() {
		System.out.println("");
		System.out.printf("価格\t：%d円\n", this.price);
		System.out.printf("支払い\t：%d円\n", this.payment);
		System.out.printf("お釣り\t：%d円\n", this.payment - this.price);
		System.out.println("--------------------------------------------------");
		for (int i = 0; i < money.length; i++) {
			String str = (this.money[i] >= 1000 ? "紙幣" : "硬貨");
			System.out.printf("%5d円%s：%d\n", this.money[i], str, this.change[i]);
		}
		System.out.println("--------------------------------------------------");
	}
	
	private void calcChange() {
		this.change = new int[money.length];
		
		int rest = this.payment - this.price;
		for (int i = 0; i < money.length; i++) {
			this.change[i] = rest / this.money[i];
			rest = rest % this.money[i];
		}
	}
	
	private int checkArgs() {
		int result = -1;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			switch (this.args.length) {
				case 0:
					price = input("価格を入力してください：", br);
					payment = input("支払額を入力してください：", br);
					break;
				case 1:
					payment = StrToInt(this.args[0]);
					price = input("価格を入力してください：", br);
					break;
				case 2:
					price = StrToInt(this.args[0]);
					payment = StrToInt(this.args[1]);
					break;
				default:
					result = -1;
					break;
			}
			br.close();
		} catch (IOException e) {
            e.printStackTrace();
			br.close();
            return -1;
        }
        
		if (price <= 0 || payment <= 0) {
			result = -1;
		} else {
			result = 0;
		}
		return result;
	}
	
	private int input(String str, BufferedReader br) throws IOException {
		int result;
		
		System.out.print(str);
		String inputStr = null;
		inputStr = br.readLine();
        result = StrToInt(inputStr);
		return result;
	}
	
	private int StrToInt(String str) {
		int result;
		try {
			result = Integer.parseInt(str);
		} catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
		}
		if (result <= 0) {
			result = -1;
		}
		return result;
	}
}
