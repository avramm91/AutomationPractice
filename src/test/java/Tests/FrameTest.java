package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FrameTest extends SharedData {

    @Test
    public void frameTest(){

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement switchToButton = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions action = new Actions(driver);
        action.moveToElement(switchToButton).perform();

        //single IFrame
        WebElement framesElement = driver.findElement(By.xpath("//a[text()='Frames']"));
        framesElement.click();
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");

        driver.switchTo().frame("singleframe");
        WebElement inputText = driver.findElement(By.cssSelector("div>input[type = 'text']"));
        inputText.sendKeys("Hello Mada!");
        driver.switchTo().defaultContent();

        //IFrame in Iframe
        WebElement multipleIFrame = driver.findElement(By.cssSelector("a[href = '#Multiple']"));
        multipleIFrame.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement inputtext2 = driver.findElement(By.cssSelector("div>input[type='text']"));
        inputtext2.sendKeys("Salutare!");






    }
}
