package example_two;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTestExample {

	private static Scanner keyIn = new Scanner(System.in);
	private static int day;
	private static int month;
	private static int year;
	
	public static void main(String[] args) {
		
		String startDate;
		String endDate;
		
		System.out.println("Please enter the start date for the holiday");
		getDateFromUser();
		startDate = defineDate(day, month, year);
		
		System.out.println("Please enter the end date for the holiday");
		getDateFromUser();
		endDate = defineDate(day, month, year);
		
		System.out.printf("%nNumbers of days booked: %d",
				calculateNumberOfDaysOnHolidays(startDate, endDate));
	}

	static void getDateFromUser() {
		System.out.println("Please enter day:");
		day = keyIn.nextInt();
		System.out.println("Please enter month");
		month = keyIn.nextInt();
		System.out.println("Please enter year");
		year = keyIn.nextInt();
	}

	static String defineDate(int day, int month, int year) {
		
		if (day < 10 && month < 10) {
			return String.format("%d-%02d-%02d", year, month, day);
		} else if (month < 10 && day > 9) {
			return String.format("%d-%02d-%d", year, month, day);
		} else if (month > 9 && day < 10) {
			return String.format("%d-%d-%02d", year, month, day);
		} else {
			return String.format("%d-%d-%d", year, month, day);
		}
	}
	
	static long calculateNumberOfDaysOnHolidays(String startDate,
			String endDate) {
		
		LocalDate from = LocalDate.parse(startDate);
		LocalDate to = LocalDate.parse(endDate);
		
		System.out.printf("%nStart date: %s, End date: %s", startDate, endDate);

		return ChronoUnit.DAYS.between(from, to);
		
	}

}
