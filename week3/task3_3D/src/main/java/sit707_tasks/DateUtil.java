package sit707_tasks;

public class DateUtil {
    private int day, month, year, hour, minute, second;

    public DateUtil(int day, int month, int year) 
    {
        if (!isValidDate(day, month, year) || !isValidTime(hour, minute, second)) {
            throw new IllegalArgumentException("Invalid date or time");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void incrementDate() {
        if (day < monthDuration(month, year)) {
            day++;
        } else if (month < 12) {
            day = 1;
            month++;
        } else {
            day = 1;
            month = 1;
            year++;
        }
    }
    
    public void decrementDate() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = monthDuration(month, year);
        } else {
            // It's the first day of the year; roll back to last day of December of the previous year
            month = 12;
            year--;
            day = monthDuration(month, year);
        }
    }


    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) return false;
        int maxDay = monthDuration(month, year);
        return day >= 1 && day <= maxDay;
    }

    public static boolean isValidTime(int hour, int minute, int second) {
        return (hour >= 0 && hour <= 23) &&
               (minute >= 0 && minute <= 59) &&
               (second >= 0 && second <= 59);
    }

    public static int monthDuration(int month, int year) {
        if (month == 2) return isLeapYear(year) ? 29 : 28;
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        return 31;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String toString() {
        return String.format("%02d-%02d-%04d %02d:%02d:%02d",
                             day, month, year, hour, minute, second);
    }
}
