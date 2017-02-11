package SeleniumWorkshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by JIT on 11-Feb-17.
 */
public class RegisterPage {

    @FindBy(name = "firstName")
    private WebElement firstNameElement;

    @FindBy(name = "lastName")
    private WebElement lastNameElement;

    @FindBy(name = "phone")
    private WebElement phoneElement;

    @FindBy(id = "userName")
    private WebElement userNameElement;

    @FindBy(name = "address1")
    private WebElement address1Element;

    @FindBy(name = "address2")
    private WebElement address2Element;

    @FindBy(name = "city")
    private WebElement cityElement;

    @FindBy(name = "state")
    private WebElement stateElement;

    @FindBy(name = "postalCode")
    private WebElement postalCodeElement;

    @FindBy(name = "country")
    private WebElement countryElement;

    @FindBy(id = "email")
    private WebElement emailElement;

    @FindBy(name = "password")
    private WebElement passwordElement;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordElement;

    @FindBy(name = "register")
    private WebElement registerElement;

    public void fillContactInformation(String firstName, String lastName, String phoneNumber, String emailAddress){
        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        phoneElement.sendKeys(phoneNumber);
        userNameElement.sendKeys(emailAddress);
    }

    public void fillMailingInformation(String addressFirstLine, String addressSecondLine, String city,
                                       String state, String postalCode, String country){
        address1Element.sendKeys(addressFirstLine);
        address2Element.sendKeys(addressSecondLine);
        cityElement.sendKeys(city);
        stateElement.sendKeys(state);
        postalCodeElement.sendKeys(postalCode);
        new Select(countryElement).selectByVisibleText(country);
    }

    public void fillUserInformation(String userName, String password) {
        emailElement.sendKeys(userName);
        passwordElement.sendKeys(password);
        confirmPasswordElement.sendKeys(password);
    }

    public void clickOnRegisterButton() {
        registerElement.click();
    }
}
