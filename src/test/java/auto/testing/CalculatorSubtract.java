package auto.testing;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by HINSHEVA on 7/8/2017.
 */


@RunWith(Parameterized.class)
public class CalculatorSubtract {
    private int first;
    private int second;
    private int result;
    private Calculator calculator;


    @org.junit.Before
    public void setUp() {
        calculator = new Calculator();
    }

    public CalculatorSubtract(int first, int second, int result) {
        this.first = first;
        this.second = second;
        this.result = result;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {7, 7, 0},
                        {10, 9, 1}
                }
        );
    }


    @Test
    public void testSubtract() {
        String message = "Test data is invalid";
        Assert.assertEquals(result, calculator.subtract(first, second));
    }

}
