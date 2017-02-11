package SeleniumWorkshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by JIT on 11-Feb-17.
 */
public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private RegistrationConfirmPage registrationConfirmPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = PageFactory.initElements(driver, HomePage.class);
        }
        return homePage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null){
            registerPage = PageFactory.initElements(driver, RegisterPage.class);
        }
        return registerPage;
    }

    public RegistrationConfirmPage getRegistrationConfirmPage(){
        if(registrationConfirmPage == null){
            registrationConfirmPage = PageFactory.initElements(driver, RegistrationConfirmPage.class);
        }
        return registrationConfirmPage;
    }
}
