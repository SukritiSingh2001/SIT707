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
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
        System.out.println("=======================================================================");
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        System.out.println("=======================================================================");
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
        System.out.println("=======================================================================");
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		  DateUtil date = new DateUtil(1, 1, 2024); // January 1st, 2024
		  System.out.println("Before increment: " + date);
		    date.increment();
		    System.out.println("After increment: " + date);
		    Assert.assertEquals(2, date.getDay()); // Expected: January 2
		    Assert.assertEquals(1, date.getMonth()); // Month should remain January
		    System.out.println("=======================================================================");
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024); // January 1st, 2024
		 System.out.println("Before decrement: " + date);
	    date.decrement();
	    System.out.println("After decrement: " + date);
	    Assert.assertEquals(31, date.getDay()); // Expected: December 31
	    Assert.assertEquals(12, date.getMonth()); // Month should be December
	    Assert.assertEquals(2023, date.getYear()); // Year should decrement
	    System.out.println("=======================================================================");
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	//Test February 28 to March 1 (Non-Leap Year)
	@Test
	public void testMaxFebruary28ShouldIncrementToMarch1() {
		 DateUtil date = new DateUtil(28, 2, 2023);
	        System.out.println("Before increment: " + date);
	        date.increment();
	        System.out.println("After increment: " + date);
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(3, date.getMonth());
	        System.out.println("=======================================================================");
	}
	
	@Test
	public void testMaxFebruary29ShouldIncrementToMarch1() {
		 DateUtil date = new DateUtil(29, 2, 2024);
	        System.out.println("Before increment: " + date);
	        date.increment();
	        System.out.println("After increment: " + date);
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(3, date.getMonth());
	        System.out.println("=======================================================================");
	}
	
	@Test
	//Test March 1 to February 28 (Decrement)
	public void testMinMarch1ShouldDecrementToFebruary28() {
		DateUtil date = new DateUtil(1, 3, 2023);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        System.out.println("=======================================================================");
	}
	
	@Test
	// Test June 30 to July 1
	public void testMaxJune30ShouldIncrementToJuly1() {
		DateUtil date = new DateUtil(30, 6, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        System.out.println("=======================================================================");
	}
	
	@Test
	//Test December 31 to January 1 (New Year Case)
	public void testMaxDecember31ShouldIncrementToJanuary1() {
		 DateUtil date = new DateUtil(31, 12, 2024);
	        System.out.println("Before increment: " + date);
	        date.increment();
	        System.out.println("After increment: " + date);
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(1, date.getMonth());
	        Assert.assertEquals(2025, date.getYear());
	        System.out.println("=======================================================================");
	}
	
	@Test
	// Test April 30 to May 1
	public void testMaxApril30ShouldIncrementToMay1() {
		 DateUtil date = new DateUtil(30, 4, 2024);
	        System.out.println("Before increment: " + date);
	        date.increment();
	        System.out.println("After increment: " + date);
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(5, date.getMonth());
	        System.out.println("=======================================================================");
	}
	
	@Test
	//Test Invalid Date Handling (February 30)
	public void testInvalidDate_February30() {
		try {
			DateUtil date = new DateUtil(30, 2, 2024);
			System.out.println("Testing invalid date: " + date);
	        Assert.assertFalse(date.isValidDate());
		}
		catch(RuntimeException ex)
		{
			System.out.println("Exception: " + ex);
		}
		
        
	}

}
