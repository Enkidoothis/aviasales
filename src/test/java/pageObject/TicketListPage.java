package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TicketListPage extends BasePage {

    public TicketListPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getMakeChaingesButton(){
        return wait.until(x -> driver.findElements(By.cssSelector(".b-button__text")));
    }


}
