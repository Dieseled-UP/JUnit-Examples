package example_two;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {

	private static DateTestExample check;
	@BeforeEach
	static void setClassModel() {
		check = new DateTestExample();
	}
	
	@Test
	void testStartDateDayAndMonth() {
		
		assertEquals("2018-08-04", check.defineDate(4, 8, 2018));
		assertEquals("2018-04-12", check.defineDate(12, 04, 2018));
		assertEquals("2018-11-09", check.defineDate(9, 11, 2018));
		assertEquals("2018-11-21", check.defineDate(21, 11, 2018));
	}
	
	@Test
	void testCalculateNumberOfDaysOnHolidays() {
		
		assertEquals(5, check.calculateNumberOfDaysOnHolidays("2018-08-12", "2018-08-17"));
	}

}
