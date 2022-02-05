package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.FrameMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FrameTest extends SharedData {

    public FrameMethods frameMethods;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;

    @Test
    public void frameTest(){

        frameMethods = new FrameMethods(driver);
        elementMethods = new ElementMethods(driver);
        pageMethods =new PageMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        WebElement switchToButton = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        elementMethods.moveToElement(switchToButton);

        //single IFrame
        WebElement framesElement = driver.findElement(By.xpath("//a[text()='Frames']"));
        elementMethods.clickElement(framesElement);
        pageMethods.navigateToUrl("http://demo.automationtesting.in/Frames.html");

       frameMethods.switchtoFrameById("singleframe");
        WebElement inputText = driver.findElement(By.cssSelector("div>input[type = 'text']"));
        inputText.sendKeys("Hello Mada!");
        frameMethods.switchtoDefault();

        //IFrame in Iframe
        WebElement multipleIFrame = driver.findElement(By.cssSelector("a[href = '#Multiple']"));
        elementMethods.clickElement(multipleIFrame);

        frameMethods.switchtoFrameByElement(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethods.switchtoFrameByElement(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement inputtext2 = driver.findElement(By.cssSelector("div>input[type='text']"));
        elementMethods.fillElement(inputtext2,"Salutare");






    }
}
