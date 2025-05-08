package web.service;

public class MathQuestionService {

    public static double q1Addition(String number1, String number2) {
        try {
            return Double.parseDouble(number1) + Double.parseDouble(number2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric input");
        }
    }

    public static double q2Subtraction(String number1, String number2) {
        try {
            return Double.parseDouble(number1) - Double.parseDouble(number2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric input");
        }
    }

    public static double q3Multiplication(String number1, String number2) {
        try {
            return Double.parseDouble(number1) * Double.parseDouble(number2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric input");
        }
    }
}
