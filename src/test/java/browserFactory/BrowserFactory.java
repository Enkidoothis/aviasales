package browserFactory;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public WebDriver createWebDriver(BrowserType browser) throws NoSuchMethodException {
        switch (browser){
            case CHROME:
                return GetChromeDriver();
            case FIREFOX:
                return GetFirefoxDriver();
            default:
                throw new NoSuchMethodException();
        }
    }

    private WebDriver GetFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        return new FirefoxDriver();
    }

    private WebDriver GetChromeDriver() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        return new ChromeDriver();
    }
}