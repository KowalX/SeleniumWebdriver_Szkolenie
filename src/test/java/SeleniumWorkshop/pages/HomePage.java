package SeleniumWorkshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by JIT on 11-Feb-17.
 */
public class HomePage {

    @FindBy(linkText = "REGISTER")
    private WebElement registerLinkElement;

    public void clickOnRegisterLink() {
        registerLinkElement.click();
    }


}
