package Tests;


import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class RegisterTest {

    public WebDriver driver;

    @Test
    public void Register() {

        //initialize the webdriver
        System.setProperty("webdriver.chrome.driver","/Users/ravram/AutomationPractice/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();

        // find and click the 'Skip Sign In' button
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        // find the first name field and fill in value
        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder = 'First Name']"));
        String firstNameValue = "Madalina";
        firstName.sendKeys(firstNameValue);

        // find the last name field and fill in value
        WebElement lastName = driver.findElement(By.cssSelector("input[placeholder = 'Last Name']"));
        String lastNameValue = "Avram";
        lastName.sendKeys(lastNameValue);

        // find the text area and add the address
        WebElement adress = driver.findElement(By.cssSelector("textarea"));
        String adressValue = "str.Corneliu Coposu, nr.1";
        adress.sendKeys(adressValue);

        // find the email field and fill in the email
        WebElement emailAdress = driver.findElement(By.cssSelector("input[type = 'email']"));
        String emailAdressValue = "sesermanmadalina@yahoo.com";
        emailAdress.sendKeys(emailAdressValue);

        // find the input field and fill in the phone number
        WebElement phone = driver.findElement(By.cssSelector("input[type = 'tel']"));
        String phoneValue = "0746881208";
        phone.sendKeys(phoneValue);

        // find and click the Female radio button
        WebElement gender = driver.findElement(By.cssSelector("input[value = 'FeMale']"));
        gender.click();

        // find and click the Movies checkbox
        WebElement hobbies = driver.findElement(By.cssSelector("input[value = 'Movies']"));
        hobbies.click();

        // execute JS script to scroll the page so that the advertising won't overlap the selection
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbies);

        // find and click the Languages button so that the dropdown list is displayed
        WebElement languagesBox = driver.findElement(By.id("msdd"));
        languagesBox.click();

        // get the list of available dropdown options, iterate it and select the option containing "English"
        List<WebElement> languageOptions = driver.findElements(By.cssSelector("a[class ='ui-corner-all']"));
        for (WebElement myOption : languageOptions) {
            if (myOption.getText().contains("English")) {
                myOption.click();
                phone.click();
            }
        }

        // select Android from the "Select" dropdown
        Select skills = new Select(driver.findElement(By.id("Skills")));
        skills.selectByValue("Android");

        //find and fill the country
        WebElement country = driver.findElement(By.className("select2-selection__arrow"));
        country.click();
        WebElement searchCountry = driver.findElement(By.className("select2-search__field"));
        String myCountryValue = "Denmark";
        searchCountry.sendKeys(myCountryValue);
        searchCountry.sendKeys(Keys.ENTER);

        //find and select my birthday
        Select myBirthdayYear = new Select(driver.findElement(By.id("yearbox")));
        myBirthdayYear.selectByValue("1991");

        Select myBirthdayMonth = new Select(driver.findElement(By.cssSelector("[placeholder = 'Month']")));
        myBirthdayMonth.selectByValue("February");

        Select myBirthdayDay = new Select(driver.findElement(By.id("daybox")));
        myBirthdayDay.selectByValue("12");

        //find and fill the password
        WebElement password = driver.findElement(By.id("firstpassword"));
        String passwordValue = "MadalinaAvram91";
        password.sendKeys(passwordValue);

        //find and fill the password confirmation
        WebElement confirmPassword = driver.findElement(By.id("secondpassword"));
        confirmPassword.sendKeys(passwordValue);

        // find and click the Submit button
        WebElement submitButton = driver.findElement(By.id("submitbtn"));
        submitButton.click();

        // find and click the Refresh button
        WebElement refreshButton = driver.findElement(By.id("Button1"));
        refreshButton.click();

        driver.quit();

    }
}
