package sit707_week2;

public class Main {
    public static void main(String[] args) {
        // URL for the Bunnings registration page
        String url = "https://www.bunnings.com.au/register";
        // Sample credentials (will drive test cases in your decision table)
        String email    = "pree@gmail.com";  
        String password = "hello";
        
        // Execute the registration workflow
        boolean success = SeleniumOperations.bunningswarehouse(url, email, password);
        
        // Print the outcome to the console
        if (success) {
            System.out.println("Registration succeeded!");
        } else {
            System.out.println("Registration failed!");
        }
    }
}
