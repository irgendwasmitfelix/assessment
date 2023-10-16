package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static Utils.common.*;

public class ProductListingsPage extends TestBase {

    public static String productPrice;
    public static List<String> totalProductPrice = new ArrayList<>();
    public static String productTitle;

    public ProductListingsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".a-color-state.a-text-bold")
    public WebElement searchResult;

    @FindBy(xpath = "//span[text()=\"Featured\"]")
    public WebElement sortingDrp;

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

    @FindBy(css = ".a-size-base-plus.a-color-base.a-text-normal")
    public List<WebElement> productTitles;

    public String verifySearchResult(){
        waitForElementToBeVisible(searchResult);
        return searchResult.getText();
    }

    public void selectSorting(String sortBy){
        click(sortingDrp);
        waitForElementToBeVisible(driver.findElement(By.xpath("//a[text()=\""+sortBy+"\"]")));
        waitForElementToBeClickable(driver.findElement(By.xpath("//a[text()=\""+sortBy+"\"]")));
        driver.findElement(By.xpath("//a[text()=\""+sortBy+"\"]")).click();
//        Select selectSorting = new Select(sortingDrp);
//        selectSorting.selectByIndex(1);
    }

    public void getLowestProductPrice(){
        String wholePrice = getPriceWholeElements().get(0).getText();
        String fractionPrice = getPriceFractionElements().get(0).getText();
        productPrice = wholePrice + priceDecimal.getAttribute("innerText") + fractionPrice.trim();
        totalProductPrice.add(wholePrice + priceDecimal.getAttribute("innerText") + fractionPrice.trim());
    }

    public List<WebElement> getPriceWholeElements() {
        waitForElementToBeVisible(priceWholeIndividual);
        return priceWhole;
    }

    public List<WebElement> getPriceFractionElements() {
        return priceFraction;
    }

    public List<WebElement> getProductTitleElements() {
        waitForElementToBeVisible(priceWholeIndividual);
        return productTitles;
    }

    public void clickOnLowestPriceProduct(){
        waitForElementToBeVisible(getProductTitleElements().get(0));
        waitForElementToBeClickable(getProductTitleElements().get(0));
        productTitle = getProductTitleElements().get(0).getText();
        getProductTitleElements().get(0).click();
    }
}
