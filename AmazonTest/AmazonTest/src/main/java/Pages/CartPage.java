package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static Pages.ProductPage.totalProducts;
import static Utils.common.*;

public class CartPage extends TestBase {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sc-subtotal-label-buybox")
    WebElement noOfItems;

    @FindBy(xpath = "//span[@id=\"sc-subtotal-amount-buybox\"]/span")
    WebElement cartTotal;

    @FindBy(name = "proceedToRetailCheckout")
    WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//h1[contains(text(),\"Sign in\")]")
    WebElement signInTitle;

    @FindBy(xpath = "//h3[contains(text(),\"Sign in to continue\")]")
    WebElement signInCardTitle;

    @FindBy(id = "sw-gtc")
    WebElement goToCart;

    public void clickOnGoToCart(){
        click(goToCart);
    }

    public boolean verifyNoOfItems(String totalProducts){
        return elementByText(totalProducts).isDisplayed();
    }

    public String verifyCartTotal(){
        return cartTotal.getText();
    }

    public void clickOnCheckOutButton(){
        click(proceedToCheckOutBtn);
    }

    public boolean verifySignInPage(){
        try {
            waitForElementToBeVisible(signInTitle);
            return signInTitle.isDisplayed();
        }catch (Exception e){
            waitForElementToBeVisible(signInCardTitle);
            return signInCardTitle.isDisplayed();
        }
    }

    public static double sumOfList(List<String> values) {
        double sum = 0.0;

        for (String value : values) {
            log.info(value);
            String cleanedValue = value.replace(",", ".");
            log.info(cleanedValue);
            double numericValue = Double.parseDouble(cleanedValue);
            log.info(numericValue);
            sum += numericValue;
        }
        log.info(sum);
        return sum;
    }

    public static String formatValue(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat("#0.00", symbols);
        return df.format(value);
    }
}
