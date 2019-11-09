import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.MainPage;

public class Tests extends BaseTest{

    @Test
    //Todo сделать ноормальные имена функций. нормально поченить ввод текста
    public void openTicketSerchPage() throws InterruptedException {
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.getComplexRoute().click();
        mainPage.getAddFly().click();
        mainPage.getDropdownPeopleAndClass().click();
        mainPage.getPlusOneAdult();
        mainPage.getBusinessClass().click();
        mainPage.iterr("Orlando", "New York", "New York", "Chicago", "Chicago", "Minneapolis");
        mainPage.iterrData("Fri Nov 15 2019","Sat Nov 16 2019","Sun Nov 17 2019");
        var ticketListPage = mainPage.openTicketListPage();
        Assert.assertTrue(ticketListPage.getMakeChaingesButton().size()==1);
    }
}
