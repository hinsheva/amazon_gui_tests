package calculatoria.com.test;

import calculatoria.com.settings.BrowserSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestOnlineCalculatorCommonFunctions extends BrowserSetting {

    @DisplayName("Test Online Calculator for 'ADD' FUNCTION")
    @ParameterizedTest()
    @MethodSource("addDataProvider")
    void testCalculatorAdd(String expression, String expectedExpression) {
        executeAndCheckExpression(expression, expectedExpression);
    }

    @DisplayName("Test Online Calculator for 'SUBTRACT' FUNCTION")
    @ParameterizedTest()
    @MethodSource("subtractDataProvider")
    void testCalculatorSubtract(String expression, String expectedExpression) {
        executeAndCheckExpression(expression, expectedExpression);
    }

    @DisplayName("Test Online Calculator for 'MULTIPLY' FUNCTION")
    @ParameterizedTest()
    @MethodSource("multiplyDataProvider")
    void testCalculatorMultiply(String expression, String expectedExpression) {
        executeAndCheckExpression(expression, expectedExpression);
    }

    @DisplayName("Test Online Calculator for 'DIVIDE' FUNCTION")
    @ParameterizedTest()
    @MethodSource("divideDataProvider")
    void testCalculatorDivide(String expression, String expectedExpression) {
        executeAndCheckExpression(expression, expectedExpression);
    }

    @DisplayName("Test Online Calculator for 'DIVIDE BY ZERO' FUNCTION")
    @ParameterizedTest()
    @MethodSource("divideByZeroDataProvider")
    void testCalculatorDivideByZero(String expression, String expectedExpression) {
        executeAndCheckExpression(expression, expectedExpression);
    }

    @DisplayName("Test Online Calculator for 'SQRT' FUNCTION")
    @ParameterizedTest()
    @MethodSource("sqrtDataProvider")
    void testCalculatorSqrt(String expression, String expectedExpression) {
        executeAndCheckExpression(expression, expectedExpression);
    }

    @DisplayName("Test Online Calculator for 'POW' FUNCTION")
    @ParameterizedTest()
    @MethodSource("powDataProvider")
    void testCalculatorPow(String expression, String expectedExpression) {
        executeAndCheckExpression(expression, expectedExpression);
    }

    private void executeAndCheckExpression(String expression, String expectedExpression) {
        String noteElementId = "paska";
        String actualExpression = calcElement.executeExpression(expression, noteElementId);
        assertEquals(expectedExpression, actualExpression);
    }

    private static Stream<Arguments> addDataProvider() {
        return Stream.of(
                Arguments.of("2+1=", "2+1=3"),
                Arguments.of("5+8=", "5+8=13"),
                Arguments.of("(2+5)+0=", "(2+5)+0=7")
        );
    }

    private static Stream<Arguments> subtractDataProvider() {
        return Stream.of(
                Arguments.of("2-0=", "2-0=2"),
                Arguments.of("5-8=", "5-8=-3"),
                Arguments.of("101-(3-1)=", "101-(3-1)=99")
        );
    }

    private static Stream<Arguments> multiplyDataProvider() {
        return Stream.of(
                Arguments.of("2×0=", "2*0=0"),
                Arguments.of("5×8=", "5*8=40"),
                Arguments.of("(2×5)×1=", "(2*5)*1=10")
        );
    }

    private static Stream<Arguments> divideDataProvider() {
        return Stream.of(
                Arguments.of("2÷1=", "2/1=2"),
                Arguments.of("100÷10=", "100/10=10"),
                Arguments.of("0÷2=", "0/2=0")
        );
    }

    private static Stream<Arguments> divideByZeroDataProvider() {
        return Stream.of(
                Arguments.of("99÷0=", "99/0=Infinity"),
                Arguments.of("100÷0=", "100/0=Infinity"),
                Arguments.of("0÷0=", "0/0=NaN")
        );
    }

    private static Stream<Arguments> sqrtDataProvider() {
        return Stream.of(
                Arguments.of("25√", "&radic; 25=5"),
                Arguments.of("100√", "&radic; 100=10"),
                Arguments.of("0√", "&radic; 0=0")
        );
    }

    private static Stream<Arguments> powDataProvider() {
        return Stream.of(
                   Arguments.of("4^4=", "4^4=256"),
                  Arguments.of("0^0=", "0^0=1"),
                Arguments.of("99^2=", "99^2=9801")
        );
    }
}
