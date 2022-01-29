package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertTest extends SharedData {


    @Test

    public void testAlert(){

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement switchToButton = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions action = new Actions(driver);
        action.moveToElement(switchToButton).perform();

        WebElement alertsElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        alertsElement.click();
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

        List<WebElement> alertOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        //first alert
        alertOptions.get(0).click();
        WebElement alertOkElement = driver.findElement(By.cssSelector("#OKTab>button"));
        alertOkElement.click();

        Alert ok = driver.switchTo().alert();
        ok.accept();

        //second alert
        alertOptions.get(1).click();
        WebElement alertOkAndCancelElement = driver.findElement(By.cssSelector("#CancelTab>button"));
        alertOkAndCancelElement.click();

        Alert okAndCancel = driver.switchTo().alert();
        okAndCancel.dismiss();

        //third alert
        alertOptions.get(2).click();
        WebElement alertWithTextBoxElement = driver.findElement(By.cssSelector("#Textbox>button"));
        alertWithTextBoxElement.click();

        Alert okTextBox = driver.switchTo().alert();
        okTextBox.sendKeys("Hello Mada!");
        okTextBox.accept();









    }






}
