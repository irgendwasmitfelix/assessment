package Utils;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class common extends TestBase {

    public static void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);
        element.click();
    }

    public static void sendKey(WebElement element, String keyToSend){
        waitForElementToBeVisible(element);
        element.sendKeys(keyToSend);
    }

    public static WebElement elementByText(String text){
        return driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
    }

    public static void JSClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();" , element);
    }
}
