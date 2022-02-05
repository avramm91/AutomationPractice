package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SharedData {

    public WebDriver driver;

    @Before
    public void setUp(){

        //setam driverul de Chrome
        System.setProperty("webdriver.chrome.driver","/Users/ravram/AutomationPractice/src/test/resources/chromedriver");

        //dechidem o instanta de Chrome
        driver = new ChromeDriver();

        //accesam un URL
        driver.get("http://demo.automationtesting.in/Index.html");

        //facem driverul maximized
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @After
//    public void tearDown(){
//
//        driver.quit();
//    }

}
