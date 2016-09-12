import java.util.*;

public class DateUtility {
	public String getCalendar(int month, int year) {

		String output = "";

		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String dayName = "S  M  T  W  T  F  S";

		GregorianCalendar gc = new GregorianCalendar(year, month - 1, 1);
		int dayOfWeek = gc.get(Calendar.DAY_OF_WEEK);
		int daysInMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
		String[] monthCal = new String[daysInMonth + dayOfWeek];

		for (int i = 0; i < dayOfWeek; i++) {
			monthCal[i] = " ";
		}
		int cal = 1;
		for (int i = dayOfWeek - 1; i < daysInMonth + dayOfWeek; i++) {
			monthCal[i] = String.valueOf(cal);
			cal++;
		}

		output += monthName[month - 1] + " " + year + "\n";
		output += dayName + "\n";

		String dateLine = "";
		dateLine = "";
		for (int i = 0; i < 7; i++) {
			if (monthCal[i].length() == 1)
				dateLine += monthCal[i] + "  ";
			else
				dateLine += monthCal[i] + " ";
		}
		output += dateLine + "\n";
		dateLine = "";
		for (int i = 7; i < 14; i++) {
			if (monthCal[i].length() == 1)
				dateLine += monthCal[i] + "  ";
			else
				dateLine += monthCal[i] + " ";
		}
		output += dateLine + "\n";
		dateLine = "";
		for (int i = 14; i < 21; i++) {
			if (monthCal[i].length() == 1)
				dateLine += monthCal[i] + "  ";
			else
				dateLine += monthCal[i] + " ";
		}
		output += dateLine + "\n";
		dateLine = "";
		for (int i = 21; i < 28; i++) {
			if (monthCal[i].length() == 1)
				dateLine += monthCal[i] + "  ";
			else
				dateLine += monthCal[i] + " ";
		}
		output += dateLine + "\n";
		if (daysInMonth + dayOfWeek - 1 > 35) {
			dateLine = "";
			for (int i = 28; i < 35; i++) {
				if (monthCal[i].length() == 1)
					dateLine += monthCal[i] + "  ";
				else
					dateLine += monthCal[i] + " ";
			}
			output += dateLine + "\n";
			dateLine = "";
			for (int i = 35; i < daysInMonth + dayOfWeek - 1; i++) {
				if (monthCal[i].length() == 1)
					dateLine += monthCal[i] + "  ";
				else
					dateLine += monthCal[i] + " ";
			}
			output += dateLine + "\n";
		}
		else{
			dateLine = "";
			for (int i = 28; i < daysInMonth + dayOfWeek - 1; i++) {
				if (monthCal[i].length() == 1)
					dateLine += monthCal[i] + "  ";
				else
					dateLine += monthCal[i] + " ";
			}
			output += dateLine + "\n";
		}

		return output;
	}

	public int getLastDayOfMonth(int month, int year) {
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, 1);
		int daysInMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
		return daysInMonth;
	}

	public String toString(int month, int day, int year, String delimeter) {
		String formattedDate = String.format("%02d", month) + delimeter + String.format("%02d", day) + delimeter + year;
		return formattedDate;
	}

	public boolean isLeapYear(int year) {
		boolean bLeapYear = false;
		bLeapYear = bLeapYear && (year % 100 != 0);
		bLeapYear = bLeapYear || (year % 400 == 0);
		return bLeapYear;
	}
	
	public long numberOfDaysInBetween(int day1, int month1, int year1, int day2, int month2, int year2) {
		GregorianCalendar gc = new GregorianCalendar(year1, month1 - 1, day1);
		Date myDate1 = gc.getTime();
		myDate1.getTime();
		long numberOfDays1 = myDate1.getTime() / (24*60*60*1000);
		
		GregorianCalendar gc2 = new GregorianCalendar(year2, month2 - 1, day2);
		Date myDate2 = gc2.getTime();
		long numberOfDays2 = myDate2.getTime() / (24*60*60*1000);
		
		return Math.abs(numberOfDays2 - numberOfDays1);
	}
	
	public long numberOfDaysInBetween(int day, int month, int year) {
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
		Date myDate1 = gc.getTime();
		myDate1.getTime();
		long numberOfDays1 = myDate1.getTime() / (24*60*60*1000);
		
		GregorianCalendar gc2 = new GregorianCalendar();
		Date myDate2 = gc2.getTime();
		long numberOfDays2 = myDate2.getTime() / (24*60*60*1000);
		
		return Math.abs(numberOfDays2 - numberOfDays1);
	}
	
	public int dayOfTheWeek(int day, int month, int year) {
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
		int dayOfWeek = gc.get(Calendar.DAY_OF_WEEK);

		return dayOfWeek;
	}
	
	public String now() {
		GregorianCalendar gc = new GregorianCalendar();
		int month = gc.get(Calendar.MONTH) + 1;
		int date = gc.get(Calendar.DATE);
		int year = gc.get(Calendar.YEAR);

		return month + "-" + date + "-" + year;
	}
	
	public String now(String format) {
		int mCount = format.length() - format.replace("m", "").length();
		int yCount = format.length() - format.replace("y", "").length();
		int dCount = format.length() - format.replace("d", "").length();
		format = format.replace("m", "");
		format = format.replace("y", "");
		format = format.replace("d", "");
		String delimeter = format.substring(format.length() - 1);
	
		String month, day, year;
		GregorianCalendar gc = new GregorianCalendar();
		if(mCount == 2){
			month = String.format("%02d",gc.get(Calendar.MONTH) + 1);
		}
		else if(mCount == 3){
			month = String.format("%03d",gc.get(Calendar.MONTH) + 1);
		}
		else{
			month = String.format("%01d",gc.get(Calendar.MONTH) + 1);
		}
		
		if(dCount == 2){
			day = String.format("%02d",gc.get(Calendar.DATE));
		}
		else if(dCount == 3){
			day = String.format("%03d",gc.get(Calendar.DATE));
		}
		else{
			day = String.format("%01d",gc.get(Calendar.DATE));
		}
		
		if(yCount == 2){
			year = String.format("%02d",gc.get(Calendar.YEAR));
		}
		else{
			year = gc.get(Calendar.YEAR) + "";
		}
		
		return month + delimeter + day + delimeter + year;

	}
	

}
