package auto.WebAppTesting;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.ExpectedException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorTest {
    private static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("Testing CalculatorJUnit4 for Adding function")
    @ParameterizedTest()
    @MethodSource("addDataProvider")
    void testCalculatorAddFunction(int first, int second, int result) {
        assertEquals(result, calculator.add(first, second));
    }

    static Stream<Arguments> addDataProvider() {
        return Stream.of(
                Arguments.of(15, 0, 15),
                Arguments.of(9, 1, 10)
        );
    }

    @DisplayName("Testing CalculatorJUnit4 for Subtracting function")
    @ParameterizedTest()
    @MethodSource("subtracDataProvider")
    void testCalculatorSubtractFunction(int first, int second, int result) {
        assertEquals(result, calculator.subtract(first, second));
    }

    static Stream<Arguments> subtracDataProvider() {
        return Stream.of(
                Arguments.of(200, 1, 199),
                Arguments.of(999, 0, 999)
        );
    }

    @DisplayName("Testing CalculatorJUnit4 for Multiplication function")
    @ParameterizedTest()
    @MethodSource("multiplyDataProvider")
    void testCalculatorMultiply(int first, int second, int result) {
        assertEquals(result, calculator.multiply(first, second));
    }

    static Stream<Arguments> multiplyDataProvider() {
        return Stream.of(
                Arguments.of(1, 0, 0),
                Arguments.of(99, 99, 9801)
        );
    }

    @DisplayName("Testing CalculatorJUnit4 for Dividing function")
    @ParameterizedTest()
    @MethodSource("divideDataProvider")
    void testCalculatorDivide(int first, int second, int result) {
        assertEquals(result, calculator.divide(first, second));
    }

    static Stream<Arguments> divideDataProvider() {
        return Stream.of(
                Arguments.of(55, 5, 11),
                Arguments.of(123, 1, 123)
        );
    }

    @Rule
    final ExpectedException exception = ExpectedException.none();

    @DisplayName("Testing CalculatorJUnit4 for Dividing by Zero function")
    @ParameterizedTest()
    @MethodSource("divideByZeroDataProvider")
    void testCalculatorDivideByZero(int first, int second) {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(first, second));
        assertEquals("/ by zero", exception.getMessage());
    }

    static Stream<Arguments> divideByZeroDataProvider() {
        return Stream.of(
                Arguments.of(100, 0, 0),
                Arguments.of(123, 0, 0)
        );
    }
}
