package testsPOM;

import baseTestCases.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;
import pagesPOM.ProductsPage;

public class LoginTests extends TestUtils {

    @Test
    // New method for successfulLogin
    public void successfulLogin(){

        // New object for LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // New object ProductPage with Method .login !
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        // Expected result with Asserts !
        Assert.assertTrue(productsPage.isAt());
    }
}
