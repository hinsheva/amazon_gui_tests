package auto.testing;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by HINSHEVA on 7/11/2017.
 */
public class CalculatorTestsNG {
    private Calculator calculator = new Calculator();

    @DataProvider(name = "addData")
    public Object[][] calculatorAdd() {
        return new Object[][]{
                {1, -1, 0}, {2, 2, 4}, {7, 3, 10}
        };
    }


    @DataProvider(name = "subtractData")
    public Object[][] calculatorSubtract() {
        return new Object[][]{
                {1, 1, 0}, {10, -2, 12}, {13, 4, 9}
        };
    }

    @DataProvider(name = "multiplyData")
    public Object[][] calculatorMultiply() {
        return new Object[][]{
                {0, 0, 0}, {9, -9, -81}, {11, 11, 121}
        };
    }

    @DataProvider(name = "divideData")
    public Object[][] calculatorDivide() {
        return new Object[][]{
                {8, 8, 1}, {144, -12, -12}, {10, 2, 5}
        };
    }

    @DataProvider(name = "divideExceptionData")
    public Object[][] calculatorDivideException() {
        return new Object[][]{
                {8, 0, 1}, {144, 0, -12}, {10, 0, 5}
        };
    }

    @Test(dataProvider = "addData")
    public void testAdd(int first, int second, int result) {
        String message = "Test data is invalid: ";
        Assert.assertEquals(calculator.add(first, second), result, message);
    }

    @Test(dataProvider = "subtractData")
    public void testSubtract(int first, int second, int result) {
        String message = "Test data is invalid: ";
        Assert.assertEquals(calculator.subtract(first, second), result, message);
    }

    @Test(dataProvider = "multiplyData")
    public void testMultiply(int first, int second, int result) {
        String message = "Test data is invalid: ";
        Assert.assertEquals(calculator.multiply(first, second), result, message);
    }

    @Test(dataProvider = "divideData")
    public void testDivide(int first, int second, int result) {
        String message = "Test data is invalid: ";
        Assert.assertEquals(calculator.divide(first, second), result, message);

    }

    @Test(dataProvider = "divideExceptionData", expectedExceptions = ArithmeticException.class)
    public void testDivideException(int first, int second, int result) {
        calculator.divide(first, second);
    }
}

