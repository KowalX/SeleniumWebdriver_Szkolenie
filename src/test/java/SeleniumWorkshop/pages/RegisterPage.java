package SeleniumWorkshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by JIT on 11-Feb-17.
 */
public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillContactInformation(String firstName, String lastName, String phoneNumber, String emailAddress){
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys(phoneNumber);
        driver.findElement(By.id("userName")).sendKeys(emailAddress);
    }

    public void fillMailingInformation(String addressFirstLine, String addressSecondLine, String city,
                                       String state, String postalCode, String country){
        driver.findElement(By.name("address1")).sendKeys(addressFirstLine);
        driver.findElement(By.name("address2")).sendKeys(addressSecondLine);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("state")).sendKeys(state);
        driver.findElement(By.name("postalCode")).sendKeys(postalCode);
        new Select(driver.findElement(By.name("country"))).selectByVisibleText(country);
    }

    public void fillUserInformation(String userName, String password) {
        driver.findElement(By.id("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmPassword")).sendKeys(password);
    }

    public void clickOnRegisterButton() {
        driver.findElement(By.name("register")).click();
    }
}
