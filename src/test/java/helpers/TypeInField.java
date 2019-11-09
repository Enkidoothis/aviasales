package helpers;

import org.openqa.selenium.WebElement;

public class TypeInField {

    public static void typeInField(WebElement pole, String value){
        WebElement element = pole;
        element.clear();
        String val = value;
        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }
}
