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
	    public void testValidDateCreation() {
	        DateUtil date = new DateUtil(15, 5, 2024);
	        Assert.assertNotNull(date);
	        Assert.assertEquals("15-05-2024 00:00:00", date.toString());
	    }

	    @Test
	    public void testValidLeapYearDate() {
	        DateUtil date = new DateUtil(29, 2, 2024);
	        Assert.assertEquals("29-02-2024 00:00:00", date.toString());
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testInvalidNonLeapYearDate() {
	        new DateUtil(29, 2, 2023); // 2023 is not a leap year
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testInvalidMonth() {
	        new DateUtil(10, 13, 2024);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testInvalidDay() {
	        new DateUtil(31, 4, 2024); // April has 30 days
	    }

	    @Test
	    public void testIncrementEndOfMonth() {
	        DateUtil date = new DateUtil(31, 1, 2024);
	        date.incrementDate();
	        Assert.assertEquals("01-02-2024 00:00:00", date.toString());
	    }

	    @Test
	    public void testDecrementStartOfMonth() {
	        DateUtil date = new DateUtil(1, 3, 2024);
	        date.decrementDate(); // Should become 29 Feb (leap year)
	        Assert.assertEquals("29-02-2024 00:00:00", date.toString());
	    }

	    @Test
	    public void testDecrementNewYear() {
	        DateUtil date = new DateUtil(1, 1, 2024);
	        date.decrementDate(); // Should be 31-12-2023
	        Assert.assertEquals("31-12-2023 00:00:00", date.toString());
	    }

	@Test
	public void testInvalidDateFebruary30() {
		Assert.assertThrows(IllegalArgumentException.class, () -> {
	        new DateUtil(30, 2, 2024);
	    });
	}
}
