package sit707_week5;

import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static List<Double> hourlyTemps;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Setting up WeatherController...");
        wController = WeatherController.getInstance();

        // Arrange: retrieve and store hourly temps only once
        hourlyTemps = new ArrayList<>();
        int nHours = wController.getTotalHours();
        for (int i = 0; i < nHours; i++) {
            hourlyTemps.add(wController.getTemperatureForHour(i + 1));
        }
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Tearing down WeatherController...");
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "S220369846"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Sukriti"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Act
        double minTemp = hourlyTemps.stream().min(Double::compare).get();
        double cachedMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals(minTemp, cachedMin, 0.001);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Act
        double maxTemp = hourlyTemps.stream().max(Double::compare).get();
        double cachedMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals(maxTemp, cachedMax, 0.001);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Act
        double sum = hourlyTemps.stream().mapToDouble(Double::doubleValue).sum();
        double avg = sum / hourlyTemps.size();
        double cachedAvg = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals(avg, cachedAvg, 0.001);
    }
}
