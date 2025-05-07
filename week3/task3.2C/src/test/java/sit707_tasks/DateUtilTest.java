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

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testD1_ValidDay28_March_NonLeapYear() {
	    DateUtil date = new DateUtil(28, 3, 2023); // Valid day
	    date.increment();
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testD2_February29_LeapYear() {
	    DateUtil date = new DateUtil(29, 2, 2024); // Leap year
	    Assert.assertTrue(date.isValidDate());
	}

	@Test(expected = RuntimeException.class)
	public void testD2_February29_NonLeapYear_Invalid() {
	    new DateUtil(29, 2, 2023); // Not a leap year → Invalid
	}

	@Test
	public void testD3_April30_Valid() {
	    DateUtil date = new DateUtil(30, 4, 2023);
	    Assert.assertTrue(date.isValidDate());
	}

	@Test(expected = RuntimeException.class)
	public void testD3_February30_Invalid() {
	    new DateUtil(30, 2, 2024); // Feb never has 30
	}

	@Test
	public void testD4_March31_Valid() {
	    DateUtil date = new DateUtil(31, 3, 2023);
	    Assert.assertTrue(date.isValidDate());
	}

	@Test(expected = RuntimeException.class)
	public void testD4_April31_Invalid() {
	    new DateUtil(31, 4, 2023); // April has only 30 days
	}

	@Test
	public void testYearLeapCheck_Valid() {
	    Assert.assertTrue(DateUtil.monthDuration(2, 2024) == 29); // Leap year
	}

	@Test
	public void testYearNonLeapCheck_Valid() {
	    Assert.assertTrue(DateUtil.monthDuration(2, 2023) == 28); // Non-leap year
	}
	
	@Test
	public void testD1_Day1_January_Valid() {
	    DateUtil date = new DateUtil(1, 1, 2023);
	    Assert.assertTrue(date.isValidDate());
	}

	@Test
	public void testD1_Day2_January_Valid() {
	    DateUtil date = new DateUtil(2, 1, 2023);
	    Assert.assertTrue(date.isValidDate());
	}

	@Test
	public void testTransition_Jan31ToFeb1_NonLeap() {
	    DateUtil date = new DateUtil(31, 1, 2023);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testTransition_Dec31ToJan1() {
	    DateUtil date = new DateUtil(31, 12, 2023);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}


	
}
