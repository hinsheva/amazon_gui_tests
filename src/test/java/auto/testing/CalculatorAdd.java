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
public class CalculatorAdd {
    private int first;
    private int second;
    private int result;
    private Calculator calculator;


    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    public CalculatorAdd(int first, int second, int result) {
        this.first = first;
        this.second = second;
        this.result = result;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {1, 0, 1},
                        {5, 0, 5}
                }
        );
    }

    @Test
    public void testAdd() {
        String message = "Test data is invalid";
        Assert.assertEquals(result, calculator.add(first, second));
    }

}
