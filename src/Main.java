
public class Main {

	public static void main(String[] args) {
		
		DateUtility date = new DateUtility();
		System.out.println(date.getCalendar(5, 2016) + "\n");
		System.out.println(date.getLastDayOfMonth(9, 2015) + "\n");
		System.out.println(date.toString(19, 92, 2015, "-") + "\n");
		System.out.println(date.isLeapYear(2017) + "\n");
		System.out.println(date.numberOfDaysInBetween(16, 10, 2016, 16, 8, 2016) + "\n");
		System.out.println(date.dayOfTheWeek(12, 9, 2016) + "\n");
		System.out.println(date.numberOfDaysInBetween(15, 9, 2016) + "\n");
		System.out.println(date.now() + "\n");
		System.out.println(date.now("mmmm*yy*dddddd") + "\n");
	}

}
