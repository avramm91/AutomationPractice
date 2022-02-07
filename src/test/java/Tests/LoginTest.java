package Tests;

import Base.SharedData;
import Help.ElementMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends SharedData {

    public ElementMethods elementMethods;

    @Test

    public void Login(){

        elementMethods = new ElementMethods(driver);

        WebElement signInElement = driver.findElement(By.id("btn1"));
        elementMethods.clickElement(signInElement);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        elementMethods.fillElement(emailElement,"sesermanmadalina@yahoo.com");

        WebElement passwordElement = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        elementMethods.fillElement(passwordElement,"Madalina91");

        WebElement enterButton = driver.findElement(By.id("enterbtn"));
        elementMethods.clickElement(enterButton);

        WebElement errorMessage = driver.findElement(By.id("errormsg"));
        elementMethods.validateTextElement(errorMessage,"Invalid User Name or PassWord");


        //quit = inchide instanta cu toate taburi deschise;
        //close = inchide tabul curent
        driver.quit();

    }
}
