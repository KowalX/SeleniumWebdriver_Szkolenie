package SeleniumWorkshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by JIT on 11-Feb-17.
 */
public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRegisterLink() {
        driver.findElement(By.linkText("REGISTER")).click();
    }


}
