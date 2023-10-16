package StepDefinitions;

import Base.TestBase;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductListingsPage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

import static Pages.CartPage.formatValue;
import static Pages.CartPage.sumOfList;
import static Pages.ProductListingsPage.productPrice;
import static Pages.ProductListingsPage.totalProductPrice;
import static Pages.ProductPage.totalProducts;

public class CheapestPriceCheckoutTest extends TestBase {

    HomePage homePage = new HomePage();
    ProductListingsPage productListingsPage = new ProductListingsPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Given("I am on the {string} page")
    public void i_am_on_the_page(String url) {
        log.info(url);
        homePage.visitURL(url);
    }

    @When("I set delivery location to zipcode {string}")
    public void iSetDeliveryLocationToZipcode(String zipCode) throws InterruptedException {
        try {
            homePage.clickOnDeliverTo();
        }catch (Exception e){
            driver.navigate().refresh();
            homePage.clickOnDeliverTo();
        }
        homePage.enterZipCode(zipCode);
        homePage.clickOnApply();
        homePage.clickOnContinue();
    }
    @When ("I reload the page")
    public void reloadpage(){

    }
    @When("I search for {string}")
    public void iSearchFor(String item) throws InterruptedException {
        homePage.enterItemName(item);
        homePage.clickOnSearch();
    }

    @Then("Verify that result for {string} is displayed")
    public void verifyThatResultForIsDisplayed(String item) {
        Assert.assertEquals(productListingsPage.verifySearchResult(), '"'+item+'"', "Search Result keyword not equal");
    }

    @When("I apply sorting as {string}")
    public void iApplySortingAs(String sortBy) {
        productListingsPage.selectSorting(sortBy);
    }

    @Then("I get first lowest price product")
    public void iGetFirstLowestPriceProduct() {
        productListingsPage.getLowestProductPrice();
    }

    @When("I click on first lowest price product")
    public void iClickOnFirstLowestPriceProduct() {
        productListingsPage.clickOnLowestPriceProduct();
    }

    @Then("Verify that product detail page is displayed")
    public void verifyThatProductDetailPageIsDisplayed() {
        Assert.assertEquals(productPage.verifyProductPrice(), productPrice, "Product Price not matched on product detail page");
    }

    @When("I click on Add to Cart")
    public void iClickOnAddToCart() {
        productPage.clickOnAddToCart();
    }

    @Then("Verify that header cart count increased to {string}")
    public void verifyThatHeaderCartCountIncreasedTo(String count) {
        Assert.assertEquals(count, productPage.verifyCartCount(), "Added Product count not matched on cart count");
    }

    @When("I click on cart icon from header")
    public void iClickOnCartIconFromHeader() {
        cartPage.clickOnGoToCart();
    }

    @Then("Verify that cart page is displayed with {string}")
    public void verifyThatCartPageIsDisplayed(String noOfItems) {
        Assert.assertTrue(cartPage.verifyNoOfItems(noOfItems), "Total Number of items not matched on cart page");
    }

    @Then("Verify that product wise total price calculated")
    public void verifyThatProductWiseTotalPriceCalculated() {
        double sum = sumOfList(totalProductPrice);
        String formattedSum = formatValue(sum);
        System.out.println("Formatted Sum: " + formattedSum);
        Assert.assertEquals(cartPage.verifyCartTotal(), prop.getProperty("currency") + formattedSum, "Cart total not matched on cart page");
    }

    @When("I click on checkout button")
    public void iClickOnCheckoutButton() {
        cartPage.clickOnCheckOutButton();
    }

    @Then("Verify that Sign In page is displayed")
    public void verifyThatSignInPageIsDisplayed() {
        Assert.assertTrue(cartPage.verifySignInPage(), "Sign In page not visible for guest checkout");
    }


}
