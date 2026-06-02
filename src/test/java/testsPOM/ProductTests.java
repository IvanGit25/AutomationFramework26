package testsPOM;

import baseTestCases.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesPOM.LoginPage;
import pagesPOM.ProductsPage;

public class ProductTests extends TestUtils {

    @Test
    public void addItemToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToTheCart("bike-light");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 1);
    }

    @Test
    public void addItemsToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        // Create NEW SOFT ASSERT!
        SoftAssert softAssert = new SoftAssert();

        productsPage.addItemToTheCart("bike-light");
        softAssert.assertEquals(productsPage.getItemsInTheCart(), 1, "We added one item");

        productsPage.addItemToTheCart("backpack");
        softAssert.assertEquals(productsPage.getItemsInTheCart(), 2, "We added 2nd item");

        softAssert.assertAll();
    }
}
