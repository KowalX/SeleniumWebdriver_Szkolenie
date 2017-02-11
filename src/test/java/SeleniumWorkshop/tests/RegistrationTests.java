package SeleniumWorkshop.tests;


import SeleniumWorkshop.pages.RegistrationConfirmPage;
import SeleniumWorkshop.pages.HomePage;
import SeleniumWorkshop.pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationTests {

    private static final String PAGE_URL = "http://newtours.demoaut.com";
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private RegistrationConfirmPage registrationConfirmPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registrationConfirmPage = PageFactory.initElements(driver, RegistrationConfirmPage.class);

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


        homePage.clickOnRegisterLink();

        registerPage.fillContactInformation(firstName, lastName, phoneNumber, emailAddress);
        registerPage.fillMailingInformation(addressFirstLine, addressSecondLine, city, state, postalCode, country);
        registerPage.fillUserInformation(userName, password);
        registerPage.clickOnRegisterButton();

        registrationConfirmPage.signOffAvailable();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}