package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // Elements
    @FindBy(id = "user-name")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    // Constructor for Login
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this); //MANDATORY-Always to be used in constructors to...
        //...implement the Elements of Driver!!!
    }

    // Implement method for Expected result : LoginBtn to be visible !
    @Override
    public boolean isAt() {
        return loginBtn.isDisplayed();
    }

    // Methods
    public ProductsPage login(String username, String password){
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();
        return new ProductsPage(driver);
    }
}
