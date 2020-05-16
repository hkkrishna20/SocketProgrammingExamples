package name.javacode.java.java8impatient.datentime;

import static name.javacode.java.java8impatient.datentime.PracticeQuestionsCh5.cal;
import static name.javacode.java.java8impatient.datentime.PracticeQuestionsCh5.fridayTheThirteenth;
import static name.javacode.java.java8impatient.datentime.PracticeQuestionsCh5.getAllOffsets;
import static name.javacode.java.java8impatient.datentime.PracticeQuestionsCh5.getAllOffsetsWithFractionalHours;
import static name.javacode.java.java8impatient.datentime.PracticeQuestionsCh5.getFlightDurationInMinutes;
import static name.javacode.java.java8impatient.datentime.PracticeQuestionsCh5.getLocalTimeAtDestination;
import static name.javacode.java.java8impatient.datentime.PracticeQuestionsCh5.getProgrammersDayForYear;
import static name.javacode.java.java8impatient.datentime.PracticeQuestionsCh5.next;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

import org.junit.Test;

public class PracticeQuestionsCh5Test {

	@Test
	public void testGetProgrammersDayForNonLeapYear() {
		int year = 2014;

		LocalDate programmersDayExpected = LocalDate.of(year, 9, 13);
		assertEquals(programmersDayExpected, getProgrammersDayForYear(year));
	}

	@Test
	public void testGetProgrammersDayForLeapYear() {
		int year = 2016;

		LocalDate programmersDayExpected = LocalDate.of(year, 9, 12);
		assertEquals(programmersDayExpected, getProgrammersDayForYear(year));
	}

	@Test
	public void testNextWithASaturday() {
		LocalDate nextWorkingDay = LocalDate.of(2015, 1, 5);

		assertEquals(nextWorkingDay, LocalDate.of(2015, 1, 3).with(next(w -> w.getDayOfWeek().getValue() < 6)));
	}

	@Test
	public void testNextWithAFriday() {
		LocalDate nextWorkingDay = LocalDate.of(2015, 1, 2);

		assertEquals(nextWorkingDay, LocalDate.of(2015, 1, 2).with(next(w -> w.getDayOfWeek().getValue() < 6)));
	}

	@Test
	public void testCal() {
		/*
		 * Not much can be tested for a void method that doesn't have side effects; just print the calendars for the
		 * current year.
		 */
		Year currentYear = Year.now();
		IntStream.rangeClosed(1, 12).forEach(month -> cal(currentYear.getValue(), month));
	}

	@Test
	public void testFridayTheThirteenth() {
		fridayTheThirteenth().forEach(date -> System.out.println(DateTimeFormatter.ISO_DATE.format(date)));
	}

	@Test
	public void testGetAllOffsets() {
		System.out.println(getAllOffsets());
	}

	@Test
	public void testGetAllOffsetsWithFractionalHours() {
		System.out.println(getAllOffsetsWithFractionalHours());
	}

	@Test
	public void testGetLocalTimeAtDestination() {
		String localZoneId = "America/Los_Angeles";
		LocalDateTime localDateTime = LocalDateTime.of(2014, 12, 31, 15, 5);

		/* Frankfurt is in the same time zone as Berlin and is 9 hours ahead of Los Angeles. */
		String destinationZoneId = "Europe/Berlin";
		long flightDurationInMinutes = 10 * 60 + 50;

		LocalDateTime localTimeAtDestination = getLocalTimeAtDestination(localZoneId, localDateTime, destinationZoneId,
				flightDurationInMinutes);

		assertEquals(LocalDateTime.of(2015, 1, 1, 10, 55), localTimeAtDestination);
	}

	@Test
	public void testGetFlightDurationInMinutes() {
		String localZoneId = "America/Los_Angeles";
		LocalDateTime localDateTime = LocalDateTime.of(2014, 12, 31, 15, 5);

		/* Frankfurt is in the same time zone as Berlin and is 9 hours ahead of Los Angeles. */
		String destinationZoneId = "Europe/Berlin";
		LocalDateTime destinationDateTime = LocalDateTime.of(2015, 1, 1, 10, 55);

		assertEquals(10 * 60 + 50,
				getFlightDurationInMinutes(localZoneId, localDateTime, destinationZoneId, destinationDateTime));
	}

}
