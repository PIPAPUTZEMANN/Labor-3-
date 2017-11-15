/**
 * Blatt 2, Aufgabe 2
 *  
 * @author Tobias Lauer
 */
public class Date {
	private int day, month, year;	
	
	public Date() {
		// Default: set date to 01.01.1970
		day = 1;
		month = 1;
		year = 1970;
	}
	
	public Date(int day, int month, int year) {
		this();						// default (set to 01.01.1970)
		setDate(day, month, year); 	// try to set to given values
	}
	
	
	public Date(Date other) {
		this(other.day, other.month, other.year);
	}
	
	public boolean setDate(int day, int month, int year) {
		// Check if given values form a valid date
		if (!isValidDate(day, month, year))
			return false;
		else {
			this.day = day;
			this.month = month;
			this.year = year;
			return true;
		}
	}
	
	public static boolean isValidDate(int day, int month, int year) {
		// Check for "easy" invalid cases
		if (year < 1583 || month < 1 || month > 12 || day < 1) { 
			return false;
		} else {
			int monthLength;
			switch(month) {
				case 2:  monthLength = isLeapYear(year) ? 29 : 28; break;
				case 4:
				case 6:
				case 9:
				case 11: monthLength = 30; break;
				default: monthLength = 31;
			}
			return day <= monthLength;
		}
	}
	
	public static boolean isLeapYear(int year) {
		return (year%4 == 0 && year%100 !=0 || year%400 == 0);
	}
	
	public boolean isBefore(Date other) {
		return this.year < other.year 
				|| this.year == other.year && this.month < other.month
				|| this.year == other.year && this.month == other.month && this.day < other.day;
	}
	
	public Date nextDay() {
		Date nextDay = new Date();	
		if (!nextDay.setDate(this.day+1, this.month, this.year)
					&& !this.setDate(1, this.month+1, this.year)) {
			nextDay.setDate(1, 1, this.year+1);
		}
		return nextDay;
	}
	
	public String toString() {
		return day+"."+month+"."+year; // TODO: Format stimmt noch nicht
	}
}
