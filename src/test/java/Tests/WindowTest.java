package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    @Test
    public void windowTest(){

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement switchToButton = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions action = new Actions(driver);
        action.moveToElement(switchToButton).perform();

        WebElement windowElement = driver.findElement(By.xpath("//a[text()='Windows']"));
        windowElement.click();
        driver.navigate().to("http://demo.automationtesting.in/Windows.html");

        List<WebElement> windowOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        windowOptions.get(0).click();
        WebElement clickElement = driver.findElement(By.cssSelector("#Tabbed>a>button"));
        clickElement.click();

        System.out.println("Titlul paginii: "+ driver.getTitle());

        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        System.out.println("Titlul paginii: "+ driver.getTitle());

        driver.close();

        driver.switchTo().window(tabs.get(0));

        System.out.println("Titlul paginii: "+ driver.getTitle());



        //separate windows
        windowOptions.get(1).click();
        WebElement clickElementSeparateWindow = driver.findElement(By.cssSelector("#Seperate>button"));
        clickElementSeparateWindow.click();

        System.out.println("Titlul paginii: "+ driver.getTitle());

        List<String> window = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(window.get(1));

        System.out.println("Titlul paginii: "+ driver.getTitle());

        driver.close();
        driver.switchTo().window(window.get(0));
        System.out.println("Titlul paginii: "+ driver.getTitle());

        //multiple windows
        windowOptions.get(2).click();
        WebElement clickElementMultipleWindow = driver.findElement(By.cssSelector("#Multiple>button"));
        clickElementMultipleWindow.click();
        System.out.println("Titlul paginii: "+ driver.getTitle());

        List<String> multiplewindow = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(multiplewindow.get(1));

        System.out.println("Titlul paginii: "+ driver.getTitle());

        driver.close();
        driver.switchTo().window(multiplewindow.get(0));
        System.out.println("Titlul paginii: "+ driver.getTitle());



    }
}
