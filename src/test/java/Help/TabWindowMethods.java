package Help;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabWindowMethods {
    public WebDriver driver;

    public TabWindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTab(int index){
        List<String> multiplewindow = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(multiplewindow.get(index));
        System.out.println("Titlul paginii: "+ driver.getTitle());


    }

    public void closeCurrentTab(){
        driver.close();
    }
}
