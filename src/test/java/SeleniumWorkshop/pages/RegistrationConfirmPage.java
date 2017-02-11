package SeleniumWorkshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JIT on 11-Feb-17.
 */
public class RegistrationConfirmPage {

    private WebDriver driver;

    public RegistrationConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signOffAvailable() {
        assertTrue(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
        assertEquals("User was not logged in", "SIGN-OFF", driver.findElement(By.linkText("SIGN-OFF")).getText());
    }
}
