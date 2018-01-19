package SPDAutomation.OnlineCalculator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class OnlineCalcInternalMethods {
    private WebDriver driver;

    private Map<String, WebElement> controls;

    OnlineCalcInternalMethods(WebDriver driver) {
        this.driver = driver;

        final List<WebElement> buttons = new LinkedList<>();
        buttons.addAll(driver.findElements(By.cssSelector(".btn1 a")));
        buttons.addAll(driver.findElements(By.cssSelector(".btn2 a")));
        buttons.addAll(driver.findElements(By.cssSelector(".btn3p a")));

        Map<String, WebElement> map = new HashMap<>();
        for (WebElement e : buttons) {
            map.put(e.getText(), e);
        }
        controls = map;
    }

    String generateExpression(String expression, String elementId) {
        final char[] expressionElements = expression.toCharArray();
        for (int i = 0; i < expressionElements.length; i++) {
            clickByText(String.valueOf(expressionElements[i]));
        }
        return getTextAreaValue(elementId);
    }

    private void clickByText(String text) {
        controls.get(text).click();
    }

    private String getTextAreaValue(String elementId) {
        return driver.findElement(By.xpath("//*[@id=\"" + elementId + "\"]"))
                .getAttribute("value")
                .trim()
                .replace("\n", "")
                .replace("\r", "");
    }

    void clear(String calcId, String noteId) {
        driver.findElement(By.xpath("//*[@id=\"" + noteId + "\"]/div[2]/div[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"" + calcId + "\"]/a")).click();
    }
}
