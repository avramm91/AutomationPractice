package Tests;

import Base.SharedData;
import Help.TabWindowMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    public TabWindowMethods tabWindowMethods;

    @Test
    public void windowTest(){

        tabWindowMethods = new TabWindowMethods(driver);

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


        tabWindowMethods.switchToTab(1);
        tabWindowMethods.closeCurrentTab();
        tabWindowMethods.switchToTab(0);


        //separate windows
        windowOptions.get(1).click();
        WebElement clickElementSeparateWindow = driver.findElement(By.cssSelector("#Seperate>button"));
        clickElementSeparateWindow.click();


        tabWindowMethods.switchToTab(1);
        tabWindowMethods.closeCurrentTab();
        tabWindowMethods.switchToTab(0);

        //multiple windows
        windowOptions.get(2).click();
        WebElement clickElementMultipleWindow = driver.findElement(By.cssSelector("#Multiple>button"));
        clickElementMultipleWindow.click();
        System.out.println("Titlul paginii: "+ driver.getTitle());


        tabWindowMethods.switchToTab(2);
        tabWindowMethods.closeCurrentTab();
        tabWindowMethods.switchToTab(1);
        tabWindowMethods.closeCurrentTab();
        tabWindowMethods.switchToTab(0);



    }
}
