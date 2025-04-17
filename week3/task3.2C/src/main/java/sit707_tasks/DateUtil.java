package sit707_tasks;

/**
 * @author Ahsan Habib
 */
public class DateUtil {

	// Months in order 0-11 maps to January-December.
	private static String[] MONTHS = new String[] {
			"January", "February", "March", "April", "May", "June", 
			"July", "August", "September", "October", "November", "December"
	};
	
	private int day, month, year;
	
	/*
	 * Constructs object from given day, month and year.
	 */
	public DateUtil(int day, int month, int year) {
		// Is supplied day/month/year a valid date?
		if (day < 1 || day > 31)
			throw new RuntimeException("Invalid day: " + day + ", expected range 1-31");
		if (month < 1 || month > 12)
			throw new RuntimeException("Invalid month: " + month + ", expected range 1-12");
		if (year < 1700 || year > 2024)
			throw new RuntimeException("Invalid year: " + year + ", expected range 1700-2024");
		if (day > monthDuration(month, year))
			throw new RuntimeException("Invalid day: " + day + ", max day: " + monthDuration(month, year));
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	/**
	 * Increment one day.
	 */
	public void increment() {
		if (day < monthDuration(month, year)) {
			// At least 1 day remaining in current month of year.
			day++;
		} else if (month < 12) {
			// Last day of a month AND month is less than December, so +1d is first day of next month.
			day = 1;
			month++;
		} else {
			// Month is December, so +1d is 1st January next year.
			day = 1;
			month = 1;
			year++;
		}
	}
	
	/**
	 * Decrement one day from current date.
	 */
	public void decrement() {
		if (day > 1) {
			day--;
		} else if (month > 1) {
			month--;
			day = monthDuration(month, year);
		} else {
			month = 12;
			year--;
			day = monthDuration(month, year);
		}
	}
	
	/**
	 * Calculate duration of current month of year.
	 * @param month
	 * @param year
	 * @return
	 */
	public static int monthDuration(int month, int year) {        
	    if (month == 2) {
	        return isLeapYear(year) ? 29 : 28; // Handle leap year for February
	    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
	        return 30; // April, June, September, November have 30 days
	    }
	    return 31; // All other months have 31 days
	}

	/**
	 * Helper method to check if a year is a leap year.
	 * @param year
	 * @return true if it's a leap year, false otherwise
	 */
	private static boolean isLeapYear(int year) {
	    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	/**
	 * User friendly output.
	 */
	public String toString() {
		return day + " " + MONTHS[month - 1] + " " + year;
	}
	
	
	/**
	 * Checks if the current date is valid.
	 * @return true if the date is valid, false otherwise
	 */
	public boolean isValidDate() {
	    if (year < 1700 || year > 2024) {
	        return false; // Year is out of range
	    }
	    
	    if (month < 1 || month > 12) {
	        return false; // Invalid month
	    }

	    int maxDays = monthDuration(month, year); // Get max days in the given month
	    return (day >= 1 && day <= maxDays); // Check if day is within valid range
	}
	
}
