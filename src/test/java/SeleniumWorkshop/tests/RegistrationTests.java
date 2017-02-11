package SeleniumWorkshop.tests;

import SeleniumWorkshop.pages.PageObjectManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTests {

    private static final String PAGE_URL = "http://newtours.demoaut.com";
    private WebDriver driver;
    private PageObjectManager manager;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        manager = new PageObjectManager(driver);
        driver.get(PAGE_URL);
    }

    @Test
    public void registerTest() throws InterruptedException {

        //Test case properties
        String userName = "Ben";
        String password = "xxx";
        String firstName = "Zenek";
        String lastName = "Killer";
        String phoneNumber = "Killer";
        String emailAddress = "xxx@wp.pl";
        String country = "POLAND";
        String addressFirstLine = "krolewska 202";
        String addressSecondLine = "krol 202";
        String city = "Gdansk";
        String state = "Pomorskie";
        String postalCode = "88-222";

        manager.getHomePage().clickOnRegisterLink();

        manager.getRegisterPage().fillContactInformation(firstName, lastName, phoneNumber, emailAddress);
        manager.getRegisterPage().fillMailingInformation(addressFirstLine, addressSecondLine, city, state, postalCode, country);
        manager.getRegisterPage().fillUserInformation(userName, password);
        manager.getRegisterPage().clickOnRegisterButton();

        manager.getRegistrationConfirmPage().signOffAvailable();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}