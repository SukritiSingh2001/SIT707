package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
    
    @Test
    public void testStudentIdentity() {
        String studentId = "s220369846"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Sukriti"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTrueNumberIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(5));
    }

    @Test
    public void testPrimeNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
    }

    @Test
    public void testNonPrimeNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(8));
    }

    @Test
    public void testOneIsNotPrime() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
    }

    @Test
    public void testTwoIsPrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testCancelWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testCancelByRainfall() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(20.0, 6.1));
    }

    @Test
    public void testCancelByCombinedCondition() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
    }

    @Test
    public void testWarnByWindOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 2.0));
    }

    @Test
    public void testWarnByRainOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(10.0, 5.0));
    }

    @Test
    public void testAllClear() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(30.0, 2.0));
    }
}
