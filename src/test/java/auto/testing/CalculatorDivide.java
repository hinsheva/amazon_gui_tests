package auto.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by HINSHEVA on 7/8/2017.
 */


@RunWith(Parameterized.class)
public class CalculatorDivide {
    private int first;
    private int second;
    private int result;
    private Calculator calculator;


    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    public CalculatorDivide(int first, int second, int result) {
        this.first = first;
        this.second = second;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {8, 4, 2},
                        {5, 1, 5}
                }
        );
    }

    @Test
    public void testDivide() {
        String message = "Test data is invalid";
        Assert.assertEquals(result, calculator.divide(first, second));
    }

}
