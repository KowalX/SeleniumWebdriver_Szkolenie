package SeleniumWorkshop.tests;

import static org.junit.Assert.*;

import SeleniumWorkshop.pages.HomePage;
import SeleniumWorkshop.pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTests {

    private static final String PAGE_URL = "http://newtours.demoaut.com";
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        driver.get(PAGE_URL);
    }

    @Test
    public void registerTest() throws InterruptedException {

        String userName = "Ben";
        String password = "xxx";
        String firstName = "Zenek";
        String lastName = "Killer";
        String phoneNumber = "Killer";
        String emailAddress = "xxx@wp.pl";
        String country = "POLAND";
        String addressFirstLine = "krolewska 202";
        String addressSecondLine = "krolewska 202";
        String city = "Gdansk";
        String state = "Pomorskie";
        String postalCode = "88-222";


        homePage.clickOnRegisterLink();

        registerPage.fillContactInformation(firstName, lastName, phoneNumber, emailAddress);
        registerPage.fillMailingInformation(addressFirstLine, addressSecondLine, city, state, postalCode, country);
        registerPage.fillUserInformation(userName, password);
        registerPage.clickOnRegisterButton();

        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[contains(.,' sign-in ')]")).click();
//        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(userName);
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
//        driver.findElement(By.xpath("//input[@alt='Login']")).click();

        assertTrue(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
        assertEquals("User was not logged in", "SIGN-OFF", driver.findElement(By.linkText("SIGN-OFF")).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}