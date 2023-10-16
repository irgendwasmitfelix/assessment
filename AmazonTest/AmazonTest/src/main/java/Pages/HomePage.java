package Pages;

import Base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Utils.common.*;

public class HomePage extends TestBase {

    public String addedZipCode;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "accept")
    public WebElement acceptCookieBtn;
    @FindBy(xpath = "//form[@action=\"/errors/validateCaptcha\"]")
    public List<WebElement> captchaBox;
    @FindBy(id = "glow-ingress-line1")
    public WebElement deliverToBtn;

    @FindBy(id = "GLUXZipUpdateInput")
    public WebElement zipField;

    @FindBy(css = "#GLUXZipUpdate > span > input")
    public WebElement applyBtn;

    @FindBy(xpath = "(//*[@id=\"GLUXConfirmClose\"])[2]")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@data-action-type=\"SELECT_LOCATION\"]")
    public WebElement changeAddressButton;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchBtn;

    @FindBy(id = "glow-ingress-line2")
    public WebElement deliverToPinCode;

    public void visitURL(String url){
        driver.get(url);

//        click(acceptCookieBtn);
    }

    public void clickOnDeliverTo() throws InterruptedException {
        if(!captchaBox.isEmpty()) {
            Thread.sleep(3000);
            driver.navigate().refresh();
        }
        try {
            click(changeAddressButton);
        }catch (Exception e){
            click(deliverToBtn);
        }
    }

    public void enterZipCode(String zipCode){
        addedZipCode = zipCode;
        sendKey(zipField, zipCode);
    }

    public void clickOnApply(){
        click(applyBtn);
    }

    public void clickOnContinue(){
        click(continueBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\""+addedZipCode+"\")]")));
    }

    public void enterItemName(String item) throws InterruptedException {
        sendKey(searchBar, item);
    }

    public void clickOnSearch(){
        click(searchBtn);
    }
}
