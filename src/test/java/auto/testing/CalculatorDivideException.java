package auto.testing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * Created by HINSHEVA on 7/8/2017.
 */


@RunWith(Parameterized.class)
public class CalculatorDivideException {
    private int first;
    private int second;
    private int result;

    private Calculator calculator;

    @Parameterized.Parameters
    public static Collection<Object[]> dataProvider() {
        return Arrays.asList(
                new Object[][]{
                        {8, 0, 4},
                        {6, 0, 1}
                }
        );

    }

    public CalculatorDivideException(int first, int second, int res) {
        this.first = first;
        this.second = second;
        this.result = res;

        calculator = new Calculator();
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test(expected = ArithmeticException.class)
    public void testDivide() {
        calculator.divide(first, second);
    }

/** Alternative methods for handling exception:
    @Test
    public void testDivide3() {
        try {
            calculator.divide(first, second);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException/didviden by zero");
        }
    }

    @Test
    public void testDivide2() {
        exception.expect(ArithmeticException.class);
        calculator.divide(first, second);
    }
    */
}
