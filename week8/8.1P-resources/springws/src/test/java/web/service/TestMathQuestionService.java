package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestMathQuestionService {

    // ✅ Positive test: valid addition
    @Test
    public void testQ1Addition_ValidNumbers() {
        assertEquals(5.5, MathQuestionService.q1Addition("2.5", "3.0"), 0.001);
    }

    // ✅ Negative test: empty string input
    @Test(expected = IllegalArgumentException.class)
    public void testQ1Addition_EmptyInput() {
        MathQuestionService.q1Addition("", "3");
    }

    // ✅ Negative test: non-numeric input
    @Test(expected = IllegalArgumentException.class)
    public void testQ1Addition_InvalidInput() {
        MathQuestionService.q1Addition("abc", "3");
    }

    // ✅ Negative test: both inputs invalid
    @Test(expected = IllegalArgumentException.class)
    public void testQ1Addition_BothInvalid() {
        MathQuestionService.q1Addition("abc", "xyz");
    }

    // ✅ Positive test: valid subtraction
    @Test
    public void testQ2Subtraction_ValidNumbers() {
        assertEquals(1.5, MathQuestionService.q2Subtraction("5.5", "4.0"), 0.001);
    }

    // ✅ Negative test: empty string input
    @Test(expected = IllegalArgumentException.class)
    public void testQ2Subtraction_EmptyInput() {
        MathQuestionService.q2Subtraction("", "3");
    }

    // ✅ Negative test: non-numeric input
    @Test(expected = IllegalArgumentException.class)
    public void testQ2Subtraction_InvalidInput() {
        MathQuestionService.q2Subtraction("abc", "3");
    }

    // ✅ Negative test: both inputs invalid
    @Test(expected = IllegalArgumentException.class)
    public void testQ2Subtraction_BothInvalid() {
        MathQuestionService.q2Subtraction("one", "two");
    }
}
