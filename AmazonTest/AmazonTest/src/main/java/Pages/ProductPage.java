package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utils.common.*;

public class ProductPage extends TestBase {
    public static String totalProducts;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "productTitle")
    WebElement productTitle;

    @FindBy(xpath = "//a[contains(text(),\"Back to results\")]")
    WebElement productDetailPageIdentification;

    @FindBy(xpath = "(//span[@class=\"a-offscreen\"])[1]")
    WebElement offSetPrice;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    @FindBy(id = "nav-cart-count")
    WebElement cartCount;

    @FindBy(css = ".a-price-whole")
    public List<WebElement> priceWhole;

    @FindBy(xpath = "(//span[@class=\"a-price-whole\"]/span)[1]")
    public WebElement priceDecimal;

    @FindBy(css = ".a-price-whole")
    public WebElement priceWholeIndividual;

    @FindBy(css = ".a-price-fraction")
    public List<WebElement> priceFraction;

    @FindBy(css = ".a-price-fraction")
    public WebElement priceFractionIndividual;

    public String verifyProductPrice(){
        waitForElementToBeVisible(productDetailPageIdentification);
        String wholePrice = getPriceWholeElements().get(0).getText();
        String fractionPrice = getPriceFractionElements().get(0).getText();
        return wholePrice + priceDecimal.getAttribute("innerText") + fractionPrice.trim();
    }

    public List<WebElement> getPriceWholeElements() {
        waitForElementToBeVisible(priceWholeIndividual);
        return priceWhole;
    }

    public List<WebElement> getPriceFractionElements() {
        return priceFraction;
    }

    public void clickOnAddToCart(){
        click(addToCartBtn);
    }

    public String verifyCartCount(){
        totalProducts = cartCount.getText();
        return totalProducts;
    }

    public void getTitle(){
        productTitle.getText();
    }
}
