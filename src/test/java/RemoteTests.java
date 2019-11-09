import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTests {
    WebDriver driver;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        URL hubUrl = new URL("http://192.168.99.100:5000/wd/hub");
        this.driver = new RemoteWebDriver(hubUrl, capabilities);
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    //Todo сделать ноормальные имена функций. нормально поченить ввод текста
    public void openTicketSerchPage() throws InterruptedException {
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.getComplexRoute().click();
        mainPage.getAddFly().click();
        mainPage.iterr("Orlando", "New York", "New York", "Chicago", "Chicago", "Minneapolis");
        mainPage.getDropdownPeopleAndClass().click();
        mainPage.getPlusOneAdult();
        mainPage.getBusinessClass().click();
        mainPage.iterrData("Fri Nov 15 2019","Sat Nov 16 2019","Sun Nov 17 2019");
        var ticketListPage = mainPage.openTicketListPage();
        Assert.assertTrue(ticketListPage.getMakeChaingesButton().size()==1);
    }
}
