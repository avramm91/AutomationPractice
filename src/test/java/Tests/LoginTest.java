package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    //declaram variabila WebDriver

    public WebDriver driver;

    @Test

    public void Login(){
        //setam driverul de Chrome
        System.setProperty("webdriver.chrome.driver","/Users/ravram/AutomationPractice/src/test/resources/chromedriver");

        //dechidem o instanta de Chrome
        driver = new ChromeDriver();

        //accesam un URL
        driver.get("http://demo.automationtesting.in/Index.html");

        //facem driverul maximized
        driver.manage().window().maximize();

        WebElement signInElement = driver.findElement(By.id("btn1"));
        signInElement.click();

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "sesermanmadalina@yahoo.com";
        emailElement.sendKeys(emailValue);

        WebElement passwordElement = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        String passwordValue = "Madalina91";
        passwordElement.sendKeys(passwordValue);

        WebElement enterButton = driver.findElement(By.id("enterbtn"));
        enterButton.click();

//        WebElement errorMessage = driver.findElement(By.id("errormsg"));
//        errorMessage.isDisplayed(); arata doar ca elementul este pe pagina

        WebElement errorMessage = driver.findElement(By.id("errormsg"));
        String expectedmessage = "Invalid User Name or PassWord";
        String actualErrorMessage = errorMessage.getText();
//        Assert.assertEquals("Textul cautat nu este corect",expectedmessage,actualErrorMessage); sau vezi mai jos
        Assert.assertTrue( actualErrorMessage.equals(expectedmessage));

        //quit = inchide instanta cu toate taburi deschise;
        //close = inchide tabul curent
        driver.quit();

    }
}
