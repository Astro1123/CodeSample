import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DateTime {
	public int year;
	public int month;
	public int day;
	public Integer hour;
	public Integer min;
	public Integer sec;
	
	public DateTime(String str) {
		Pattern pat = Pattern.compile("[0-9]{4}/[0-9]{2}/[0-9]{2}(?: [0-9]{2}(?::[0-9]{2}(?::[0-9]{2})?)?)?");
		
		if (pat.matcher(str).find()) {
			Pattern pNum = Pattern.compile("[0-9]+");
			Matcher m = pNum.matcher(str);
			if (m.find()) {
				this.year = Integer.parseInt(m.group());
			}
			if (m.find()) {
				this.month = Integer.parseInt(m.group());
			}
			if (m.find()) {
				this.day = Integer.parseInt(m.group());
			}
			if (m.find()) {
				this.hour = Integer.parseInt(m.group());
			}
			if (m.find()) {
				this.min = Integer.parseInt(m.group());
			}
			if (m.find()) {
				this.sec = Integer.parseInt(m.group());
			}
		}
	}

	public boolean isLeapYear() {
		boolean result = false;
		if (year % 400 == 0) {
			result = true;
		} else if (year % 100 == 0) {
			result = false;
		} else if (year % 4 == 0) {
			result = true;
		}
		return result;
	}
	
	public void timeDifference(double time) {
		if (Long.parseLong(String.valueOf(time).substring(String.valueOf(time).indexOf('.')+1)) == 0) {
			this.hour += (int)time;
			if (this.hour > 24) {
				this.hour -= 24;
				this.day++;
				if (this.day > lengthOfMonth(this.month)) {
					this.day -= lengthOfMonth(this.month);
					this.month++;
					if (this.month > 12) {
						this.month -= 12;
						this.year++;
					}
				}
			} else if (this.hour < 0) {
				this.hour += 24;
				this.day--;
				if (this.day < 1) {
					this.month--;
					if (this.month < 1) {
						this.month += 12;
						this.year--;
					}
					this.day += lengthOfMonth(this.month);
				}
			}
		}
	}
	
	public double dayOfYear() {
		DateTime dt = new DateTime(String.format("%d/01/01", this.year));
		return ModifiedJulianDay() - dt.ModifiedJulianDay();
	}
	
	public int dayOfWeek() {
		int y = this.year;
		int m;
		if (this.month <= 2) {
			m = this.month + 12;
			y--;
		} else {
			m = this.month;
		}
		int d = this.day;
		int ly = y % 100;
		int c = (int)(y / 100);
		int g = 5 * c + (int)(c / 4);
		int result = (d + (int)(26 * (m + 1) / 10) + ly + (int)(ly / 4) + g + 6) % 7;
		return result;
	}
	
	public double JulianDay() {
		return ModifiedJulianDay() + 2_400_000.5;
	}
	
	public double ModifiedJulianDay() {
		double y = this.year;
		double m;
		if (this.month <= 2) {
			m = this.month+12;
			y--;
		} else {
			m=this.month;
		}
		double d = this.day;
		double mjd;
		
		mjd = (int)(365.25*y);
		mjd += (int)(y/400.0);
		mjd -= (int)(y/100.0);
		mjd += (int)(30.59*(m-2));
		mjd += d;
		mjd -= 678912;
		mjd += timeToDay();
		
		return mjd;
	}
	
	public double delta(DateTime dt) {
		return  ModifiedJulianDay() - dt.ModifiedJulianDay();
	}
	
	private int lengthOfMonth(int m) {
		int result = -1;
		switch (m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				result = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				result = 30;
				break;
			case 2:
				result = 28 + (isLeapYear() ? 1 : 0);
				break;
		}
		return result;
	}
	
	private double timeToDay() {
		double d = 0;
		if (this.hour == null) return 0.0;
		d += this.hour.doubleValue() / 24.0;
		if (this.min == null) return d;
		d += this.min.doubleValue() / (24.0 * 60.0);
		if (this.sec == null) return d;
		d += this.sec.doubleValue() / (24.0 * 60.0 * 60.0);
		return d;
	}
}