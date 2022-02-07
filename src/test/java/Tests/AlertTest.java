package Tests;

import Base.SharedData;
import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlertTest extends SharedData {

    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;


    @Test

    public void testAlert(){

        elementMethods = new ElementMethods(driver) ;
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        WebElement switchToButton = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        elementMethods.moveToElement(switchToButton);

        WebElement alertsElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        elementMethods.clickElement(alertsElement);

        pageMethods.navigateToUrl("http://demo.automationtesting.in/Alerts.html");

        List<WebElement> alertOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        alertOptions.get(0).click();
        WebElement alertOkElement = driver.findElement(By.cssSelector("#OKTab>button"));
        elementMethods.clickElement(alertOkElement);

        alertMethods.acceptAlert();

        alertOptions.get(1).click();
        WebElement alertOkAndCancelElement = driver.findElement(By.cssSelector("#CancelTab>button"));
        elementMethods.clickElement(alertOkAndCancelElement);

       alertMethods.cancelAlert();

        //third alert
        alertOptions.get(2).click();
        WebElement alertWithTextBoxElement = driver.findElement(By.cssSelector("#Textbox>button"));
        elementMethods.clickElement(alertWithTextBoxElement);

        alertMethods.acceptFillAlert("Test");









    }






}
