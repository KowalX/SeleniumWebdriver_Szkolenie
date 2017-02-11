package SeleniumWorkshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JIT on 11-Feb-17.
 */
public class RegistrationConfirmPage {

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffElement;

    public void signOffAvailable() {
        assertTrue(signOffElement.isDisplayed());
        assertEquals("User was not logged in", "SIGN-OFF", signOffElement.getText());
    }
}
