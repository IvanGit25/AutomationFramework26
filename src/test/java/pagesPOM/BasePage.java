package pagesPOM;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    // Base Constructor for driver! After to be extended to LoginPage constructor driver!
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    // Abstract method for isAt(...isDisplayed) to be implemented/override !!!
    public abstract boolean isAt();

}