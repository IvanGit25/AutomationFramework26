package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {

    // Strings with elements to be used in Method for Products in Cart!
    private static final String PRODUCT_BASE_ID = "add-to-cart-sauce-lab-";

    private static final String REMOVE_PRODUCT_BASE_ID = "remove-sauce-lab-";

    // Find elements for Products Page Title and Shopping Cart Badge!
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productsPageTitle;

    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;

    // Constructor for driver
    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);// MANDATORY to implements driver!
    }

    // Expected result after LogIn - Products Page Title to be visible!
    @Override
    public boolean isAt() {
        return productsPageTitle.isDisplayed();
    }

    // Methods for add/remove products in Cart!
    public void addItemToTheCart(String itemName){
        WebElement itemToBeAdded = driver.findElement(By.id(PRODUCT_BASE_ID + itemName));
        itemToBeAdded.click();
    }

    public void removeItemFromTheCart(String itemName){
        WebElement itemToBeRemoved = driver.findElement(By.id(REMOVE_PRODUCT_BASE_ID + itemName));
        itemToBeRemoved.click();
    }

    // Method to read and convert ItemsInTheCart text as number int!
    public int getItemsInTheCart(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }
}