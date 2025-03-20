package sit707_week2;

public class Main {
    public static void main(String[] args) {
        // Run Officeworks registration
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");

        // Run Zara registration
       SeleniumOperations.zara_registration_page("https://www.zara.com/au/en/signup");
    }
}