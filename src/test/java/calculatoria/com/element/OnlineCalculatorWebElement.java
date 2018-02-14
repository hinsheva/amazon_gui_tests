package calculatoria.com.element;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class OnlineCalculatorWebElement {
    private WebDriver driver;

    private Map<String, WebElement> controls;

    private Map<String, String> replaceSymbols = ImmutableMap.of(
            "xy", "^"
    );

    public OnlineCalculatorWebElement(WebDriver driver) {
        this.driver = driver;
        collectCalculatorButtonsToMap(driver);
    }


    private void clickElementByText(String text) {
        controls.get(text).click();
    }

    private void collectCalculatorButtonsToMap(WebDriver driver) {
        final List<WebElement> calculatorButtons = new LinkedList<>();
        final List<String> groups = Arrays.asList(".btn1 a", ".btn2 a", ".btn3p a", ".btnx a");

        for (String group : groups) {
            calculatorButtons.addAll(driver.findElements(By.cssSelector(group)));
        }

        final Map<String, WebElement> map = new HashMap<>();
        for (WebElement button : calculatorButtons) {
            final String key;
            if (replaceSymbols.containsKey(button.getText())) {
                key = replaceSymbols.get(button.getText());
            } else {
                key = button.getText();
            }
            map.put(key, button);
        }
        controls = map;
    }

    public String executeExpression(String expression, String elementId) {
        final char[] expressionElements = expression.toCharArray();
        for (char expressionElement : expressionElements) {
            clickElementByText(String.valueOf(expressionElement));
        }
        return getNoteTextAreaValue(elementId);
    }

    private String getNoteTextAreaValue(String elementId) {
        return driver.findElement(By.xpath("//*[@id=\"" + elementId + "\"]"))
                .getAttribute("value")
                .trim()
                .replace("\n", "")
                .replace("\r", "");
    }

    public void clearAll() {
        clearNoteInput();
        clearCalculatorInput();
    }

    private void clearCalculatorInput() {
        driver.findElement(By.xpath("//*[@id=\"" + "btn27" + "\"]/a")).click();
    }

    private void clearNoteInput() {
        driver.findElement(By.xpath("//*[@id=\"" + "paskabox" + "\"]/div[2]/div[4]")).click();
    }
}
