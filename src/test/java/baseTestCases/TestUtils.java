package baseTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtils extends DataProviders {

    public WebDriver driver;
    private String browser, targetURL;
    private int implicitWait;

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void setupDriverAndOpenTargetUrl(){
        readConfig("src/test/resources/config.properties");
        setupDriver();

        //implicit wait:
        //driver.manage().timeouts().implicitlyWait(Duration.from(Duration.ofSeconds(implicitWait)));

        driver.get(targetURL);

        //Explicit Wait:
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOf(productsPageTitle));
    }

    private void readConfig(String pathToFile){
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            targetURL = properties.getProperty("url");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));

        }catch (IOException e){
            System.out.println(e);
        }
    }

    private void setupDriver(){
        switch (browser){
            // case chrome is no needed as is set up like default!!!
            // case "chrome":
                //driver = setupChromeDriver();
                //break;
            case "safari":
                driver = setupSafariDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
            default:
                driver = setupChromeDriver();
        }
    }

    private WebDriver setupSafariDriver(){
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    private WebDriver setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
