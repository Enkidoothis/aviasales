package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.aviasales.ru/");
    }

    public WebElement getComplexRoute() {
        return wait.until(x -> driver.findElement(By.cssSelector(".of_main_form__change_form_link")));
    }

    public WebElement getAddFly() {
        return wait.until(x -> driver.findElement(By.cssSelector(".of_multiway_segment__add")));
    }

    public WebElement getDropdownPeopleAndClass() {
        return wait.until(x -> driver.findElement(By.xpath("//*[contains(text(),'1, эконом')]")));
    }

    public void getPlusOneAdult() throws InterruptedException {
        Thread.sleep(500);
        Actions clc = new Actions(driver);
        clc.moveToElement(wait.until(x -> driver.findElement(By.xpath("//*[@d='M5 3h3v2H5v3H3V5H0V3h3V0h2v3z']")))).click().perform();
        //return wait.until(x -> driver.findElement(By.xpath("//*[@d='M5 3h3v2H5v3H3V5H0V3h3V0h2v3z']")));
    }

    public WebElement getBusinessClass() {
        return wait.until(x -> driver.findElement(By.xpath("//*[contains(text(),'Бизнес')]")));
    }

    public List<WebElement> getDateOfFly() {
        return wait.until(x -> driver.findElements(By.xpath("//*[@placeholder='Дата вылета']")));
    }

    public WebElement getFindFlyButton() {
        return wait.until(x -> driver.findElement(By.xpath("//*[contains(text(),'Найти билеты')]")));
    }

    /* public WebElement getDepDistField() {
         return wait.until(x -> driver.findElement(By.xpath("//*[@aria-autocomplete='list']")));
     }

     public void getDepDistFieldArr() {
         WebElement ul = driver.findElement(By.xpath("//*[@aria-autocomplete='list']"));
         List<WebElement> allOptions = ul.findElements(By.tagName("input"));
         for (WebElement selectLi : allOptions) {
             if (selectLi.getText().equals(ul)) {
                 selectLi.click();
             }
         }
     }*/
    public void iterrData(String Data1, String Data2, String Data3) {
        String[] cc = new String[]{Data1, Data2, Data3};
        List<WebElement> allLinks = getDateOfFly();
        Iterator<WebElement> itrD = allLinks.iterator();
        while (itrD.hasNext())
            for (String j : cc) {
                itrD.next().click();
                //System.out.println("//*[@aria-label='"+j+"']");
                wait.until(x -> driver.findElement(By.xpath("//*[@aria-label='" + j + "']"))).click();
            }
    }


    public void iterr(String Dep1, String Dest1, String Dep2, String Dest2, String Dep3, String Dest3) {

        String[] dd = new String[]{Dep1, Dest1, Dep2, Dest2, Dep3, Dest3};
        List<WebElement> allLinks = wait.until(x -> driver.findElements(By.xpath("//*[@aria-autocomplete='list']")));
        Iterator<WebElement> itr = allLinks.iterator();
        while (itr.hasNext())
            for (String i : dd) {
                //TypeInField.typeInField(itr.next(), i);
                itr.next().sendKeys("         " + i);
            }
    }


    public TicketListPage openTicketListPage() {
        getFindFlyButton().click();
        TicketListPage ticketListPage = new TicketListPage(driver);
        return ticketListPage;
    }
}



