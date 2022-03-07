package org.runewriters.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.runewriters.pom.*;
import org.runewriters.webdrivers.WebDriverFactory;
import org.runewriters.webdrivers.model.WebDriverManager;
import org.runewriters.webdrivers.model.WebDriverType;

public class CheckoutOneStepdefs {

    private LoginPage loginPage;
    private static WebDriverManager manager;
    private static WebDriver webDriver;
    private InventoryPage inventory;
    private CartPage cartPage;
    private CheckoutOnePage checkoutOnePage;
    private CheckoutTwoPage checkoutTwoPage;


    @Given("I am on the Checkout One page")
    public void iAmOnTheCheckoutOnePage() {
        manager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = manager.getDriver();
        webDriver.get("https://www.saucedemo.com");

        loginPage = new LoginPage(webDriver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogInButton();
        inventory = new InventoryPage(webDriver);
        inventory.clickAddToCartOrRemoveButtonAtIndex(0);
        inventory.clickCartIcon();
        cartPage = new CartPage(webDriver);
        cartPage.clickCheckoutButton();
    }

    @When("I enter my first name")
    public void iEnterMyFirstName() {
        checkoutOnePage = new CheckoutOnePage(webDriver);
        checkoutOnePage.enterFirstNameInTextBox("Suyash");
    }

    @And("I enter my last name")
    public void iEnterMyLastName() {
        checkoutOnePage.enterLastNameInTextBox("Srivastava");
    }

    @And("I enter my postal code")
    public void iEnterMyPostalCode() {
        checkoutOnePage.enterZipCodeInTextBox("E14 NS");
    }

    @And("I click on the Continue button")
    public void iClickOnTheContinueButton() {
        checkoutOnePage.clickContinueButton();
    }

    @Then("I will go to the Checkout Two page")
    public void iWillGoToTheCheckoutTwoPage() {
        checkoutTwoPage = new CheckoutTwoPage(webDriver);
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutTwoPage.getCurrentURL());
    }

    @When("I click on Cancel button")
    public void iClickOnCancelButton() {
        checkoutOnePage = new CheckoutOnePage(webDriver);
        checkoutOnePage.clickCancelButton();
    }

    @Then("I will go to the Your Cart page")
    public void iWillGoToTheYourCartPage() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", cartPage.getCurrentURL());
    }

    @When("I click on Cart icon")
    public void iClickOnCartIcon() {
        checkoutOnePage = new CheckoutOnePage(webDriver);
       checkoutOnePage.clickCartIcon();
    }

    @Then("I will go to the Inventory page")
    public void iWillGoToTheInventoryPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventory.getCurrentURL());
    }

    @Then("I will go to the Side bar")
    public void iWillGoToTheSideBar() {
        //Assertions.assertEquals(checkoutOnePage.isSideBarPresent());
    }

    @When("I click on Side bar icon")
    public void iClickOnSideBarIcon() {
        checkoutOnePage = new CheckoutOnePage(webDriver);
        checkoutOnePage.clickSideMenu();
    }
    @After
    public void tearDown(){
        if(webDriver != null){
            manager.quitDriver();
        System.out.println("tearDown co");
        }
    }
}
