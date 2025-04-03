package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ahsan Habib
 */
public class DateUtilTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "220369846";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Sukriti";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	 public void test1B() {
	 DateUtil date = new DateUtil(1, 6, 1994);
	 date.increment();
	 Assert.assertEquals(2, date.getDay());
	 Assert.assertEquals(6, date.getMonth());
	 Assert.assertEquals(1994, date.getYear());
	 }

	@Test
	public void test2B() {
		DateUtil date = new DateUtil(2, 6, 1994);
		date.increment();
		Assert.assertEquals(3, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test3B() {
		DateUtil date = new DateUtil(15, 6, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test4B() {
		DateUtil date = new DateUtil(30, 6, 1994);
		date.increment();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test5B() {
		DateUtil date = new DateUtil(15, 1, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test6B() {
		DateUtil date = new DateUtil(15, 2, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test7B() {
		DateUtil date = new DateUtil(15, 11, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(11, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test8B() {
		DateUtil date = new DateUtil(15, 12, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test9B() {
		DateUtil date = new DateUtil(15, 6, 1700);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1700, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test10B() {
		DateUtil date = new DateUtil(15, 6, 1701);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1701, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test11B() {
		DateUtil date = new DateUtil(15, 6, 2023);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void test12B() {
	    DateUtil date = new DateUtil(30, 6, 1994); // June 30 is valid
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Expecting it to roll over to July 1
	    Assert.assertEquals(7, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}


	@Test
	public void test13B() {
		DateUtil date = new DateUtil(15, 6, 2024);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
		System.out.println("=======================================================================");
	}

	// Leap Year Test Cases for February
	@Test
	public void testLeapYear_Increment_28_2_2020() {
		DateUtil date = new DateUtil(28, 2, 2020); // 2020 is a leap year
		date.increment();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2020, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void testLeapYear_Increment_29_2_2020() {
		DateUtil date = new DateUtil(29, 2, 2020); // 2020 is a leap year
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2020, date.getYear());
		System.out.println("=======================================================================");
	}

	@Test
	public void testNonLeapYear_Increment_28_2_2021() {
		DateUtil date = new DateUtil(28, 2, 2021); // 2021 is not a leap year
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2021, date.getYear());
		System.out.println("=======================================================================");
	}
}
