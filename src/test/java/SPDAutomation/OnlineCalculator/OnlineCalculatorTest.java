package SPDAutomation.OnlineCalculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OnlineCalculatorTest {
    private static WebDriver driver;
    private static OnlineCalcInternalMethods element;

    @BeforeAll
    static void setUp() {
        if (element == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.navigate().to("http://www.calculatoria.com/");
            WebDriver.Options manage = driver.manage();
            manage.window().setSize(new Dimension(1920, 1080));

            element = new OnlineCalcInternalMethods(driver);
        }
    }

    @DisplayName("Test Online Calculator for 'ADD' FUNCTION")
    @ParameterizedTest()
    @MethodSource("addDataProvider")
    void testCalculatorAdd(String expression, String expected) {
        String actual = element.generateExpression(expression, "paska");
        assertEquals(expected, actual);
    }

    @DisplayName("Test Online Calculator for 'SUBTRACT' FUNCTION")
    @ParameterizedTest()
    @MethodSource("subtractDataProvider")
    void testCalculatorSubtract(String expression, String expected) {
        String actual = element.generateExpression(expression, "paska");
        assertEquals(expected, actual);
    }

    @DisplayName("Test Online Calculator for 'MULTIPLY' FUNCTION")
    @ParameterizedTest()
    @MethodSource("multiplyDataProvider")
    void testCalculatorMultiply(String expression, String expected) {
        String actual = element.generateExpression(expression, "paska");
        assertEquals(expected, actual);
    }

    @DisplayName("Test Online Calculator for 'DIVIDE' FUNCTION")
    @ParameterizedTest()
    @MethodSource("divideDataProvider")
    void testCalculatorDivide(String expression, String expected) {
        String actual = element.generateExpression(expression, "paska");
        assertEquals(expected, actual);
    }

    @DisplayName("Test Online Calculator for 'DIVIDE BY ZERO' FUNCTION")
    @ParameterizedTest()
    @MethodSource("divideByZeroDataProvider")
    void testCalculatorDivideByZero(String expression, String expected) {
        String actual = element.generateExpression(expression, "paska");
        assertEquals(expected, actual);
    }

    static Stream<Arguments> addDataProvider() {
        return Stream.of(
                Arguments.of("2+1=", "2+1=3"),
                Arguments.of("5+8=", "5+8=13"),
                Arguments.of("(2+5)+0=", "(2+5)+0=7")
        );
    }

    static Stream<Arguments> subtractDataProvider() {
        return Stream.of(
                Arguments.of("2-0=", "2-0=2"),
                Arguments.of("5-8=", "5-8=-3"),
                Arguments.of("101-(3-1)=", "101-(3-1)=99")
        );
    }

    static Stream<Arguments> multiplyDataProvider() {
        return Stream.of(
                Arguments.of("2×0=", "2*0=0"),
                Arguments.of("5×8=", "5*8=40"),
                Arguments.of("(2×5)×1=", "(2*5)*1=10")
        );
    }

    static Stream<Arguments> divideDataProvider() {
        return Stream.of(
                Arguments.of("2÷1=", "2/1=2"),
                Arguments.of("100÷10=", "100/10=10"),
                Arguments.of("0÷2=", "0/2=0")
        );
    }

    static Stream<Arguments> divideByZeroDataProvider() {
        return Stream.of(
                Arguments.of("99÷0=", "99/0=Infinity"),
                Arguments.of("100÷0=", "100/0=Infinity"),
                Arguments.of("0÷0=", "0/0=NaN")
        );
    }

    @AfterEach
    void clearInput() {
        element.clear("btn27", "paskabox");
    }

    @AfterAll
    static void tearDown() {
        driver.close();
    }
}
