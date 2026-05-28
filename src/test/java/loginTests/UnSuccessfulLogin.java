package loginTests;

import baseTestCases.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnSuccessfulLogin extends TestUtils {
    // public class TestUtils extends DataProviders !!!

    @Test(dataProvider = "wrongUsers") //Used Method for reading CSV files from resources!!!
    public void UnsuccessfulLogin(String username, String password) {

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username); // Before was String "Wrong_user"

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password); // Before was String "secret_sauce"

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement closeErrorMsgBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(closeErrorMsgBtn.isDisplayed());
    }
}