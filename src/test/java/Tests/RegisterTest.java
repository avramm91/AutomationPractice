package Tests;


import Base.SharedData;
import Help.ElementMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class RegisterTest extends SharedData {

    public ElementMethods elementMethods;

    @Test
    public void Register() {

        elementMethods = new ElementMethods(driver);

        // find and click the 'Skip Sign In' button
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        // find the first name field and fill in value
        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder = 'First Name']"));
        elementMethods.fillElement(firstName,"Madalina");

        // find the last name field and fill in value
        WebElement lastName = driver.findElement(By.cssSelector("input[placeholder = 'Last Name']"));
        elementMethods.fillElement(lastName,"Avram");

        // find the text area and add the address
        WebElement adress = driver.findElement(By.cssSelector("textarea"));
        elementMethods.fillElement(adress,"str.Corneliu Coposu, nr.1");

        // find the email field and fill in the email
        WebElement emailAdress = driver.findElement(By.cssSelector("input[type = 'email']"));
        elementMethods.fillElement(emailAdress,"sesermanmadalina@yahoo.com");

        // find the input field and fill in the phone number
        WebElement phone = driver.findElement(By.cssSelector("input[type = 'tel']"));
        elementMethods.fillElement(phone,"0746881208");

        // find and click the Female radio button
        WebElement gender = driver.findElement(By.cssSelector("input[value = 'FeMale']"));
        elementMethods.clickElement(gender);

        // find and click the Movies checkbox
        WebElement hobbies = driver.findElement(By.cssSelector("input[value = 'Movies']"));
        elementMethods.clickElement(hobbies);

        // execute JS script to scroll the page so that the advertising won't overlap the selection
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbies);

        // find and click the Languages button so that the dropdown list is displayed
        WebElement languagesBox = driver.findElement(By.id("msdd"));
        elementMethods.clickElement(languagesBox);

        // get the list of available dropdown options, iterate it and select the option containing "English"
        List<WebElement> languageOptions = driver.findElements(By.cssSelector("a[class ='ui-corner-all']"));
        for (WebElement myOption : languageOptions) {
            if (myOption.getText().contains("English")) {
                myOption.click();
                phone.click();
            }
        }

        // select Android from the "Select" dropdown
        WebElement skills = driver.findElement(By.id("Skills"));
        elementMethods.selectElementByValue(skills,"Android");

        //find and fill the country
        WebElement country = driver.findElement(By.className("select2-selection__arrow"));
        country.click();
        WebElement searchCountry = driver.findElement(By.className("select2-search__field"));
        String myCountryValue = "Denmark";
        searchCountry.sendKeys(myCountryValue);
        searchCountry.sendKeys(Keys.ENTER);

        //find and select my birthday
        WebElement myBirthdayYear = driver.findElement(By.id("yearbox"));
        elementMethods.selectElementByValue(myBirthdayYear,"1991");

        WebElement myBirthdayMonth = driver.findElement(By.cssSelector("[placeholder = 'Month']"));
        elementMethods.selectElementByText(myBirthdayMonth,"February");

        WebElement myBirthdayDay = driver.findElement(By.id("daybox"));
        elementMethods.selectElementByValue(myBirthdayDay,"12");

        //find and fill the password
        WebElement password = driver.findElement(By.id("firstpassword"));
        elementMethods.fillElement(password,"MadalinaAvram91");

        //find and fill the password confirmation
        WebElement confirmPassword = driver.findElement(By.id("secondpassword"));
        elementMethods.fillElement(confirmPassword,"MadalinaAvram91");

        // find and click the Submit button
        WebElement submitButton = driver.findElement(By.id("submitbtn"));
        elementMethods.clickElement(submitButton);

        // find and click the Refresh button
        WebElement refreshButton = driver.findElement(By.id("Button1"));
        elementMethods.clickElement(refreshButton);

    }
}
