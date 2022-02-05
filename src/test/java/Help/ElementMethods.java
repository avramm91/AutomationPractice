package Help;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementMethods {

    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element){
        waitElement(element);
        element.click();
    }

    public void waitElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillElement(WebElement element, String value){
        waitElement(element);
        element.sendKeys(value);
    }

    public void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void validateTextElement(WebElement element, String value){
        waitElement(element);
        String actualErrorMessage = element.getText();
        Assert.assertEquals("Textul cautat nu este corect",value,actualErrorMessage);
    }

    public void selectElementByText(WebElement element, String value){

        Select skills = new Select(element);
        skills.selectByValue(value);
    }

    public void selectElementByValue(WebElement element, String value){

        Select skills = new Select(element);
        skills.selectByValue(value);
    }
}
