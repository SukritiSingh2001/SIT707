package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestViewQ3 {

    @Test
    public void testTrueMultiply() {
        Assert.assertEquals(MathQuestionService.q3Multiplication("2", "3"), 6.0, 0.0001);
    }

    @Test
    public void testMultiplyNumber1Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", "3"));
    }

    @Test
    public void testMultiplyInvalidInput() {
        try {
            MathQuestionService.q3Multiplication("a", "3");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Invalid numeric input");
        }
    }
}
