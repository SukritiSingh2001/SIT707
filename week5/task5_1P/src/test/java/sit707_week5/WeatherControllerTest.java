package sit707_week5;

import org.junit.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static List<Double> hourlyTemps;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Setting up WeatherController...");
        wController = WeatherController.getInstance();

        // Inject fixed time for testing persist
        wController.setClock(() -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2023, Calendar.JANUARY, 1, 10, 30, 15);
            return calendar.getTime();
        });

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
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        int hour = 1;
        double temperature = 25.5;

        // Arrange: Set expected time
        SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");
        String expectedTime = sdf.format(wController.persistTemperature(hour, temperature)); // Should match mock

        // Act: Call persist again with same mocked time
        String actualPersistedTime = wController.persistTemperature(hour, temperature);

        // Assert
        Assert.assertEquals("Persisted time mismatch", expectedTime, actualPersistedTime);
    }
}
