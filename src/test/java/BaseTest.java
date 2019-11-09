import browserFactory.BrowserFactory;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void startUp(String browserName) throws NoSuchMethodException, NoSuchFieldError, MalformedURLException {
        BrowserType browserType;
        switch (browserName){
            case "FIREFOX": browserType = BrowserType.FIREFOX;
                break;
            case "CHROME": browserType = BrowserType.CHROME;
                break;
            default: throw new NoSuchFieldError(" NO such browser ");
        }
        var factory = new BrowserFactory();
        driver = factory.createWebDriver(browserType);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(1000);
        driver.quit();
    }
}