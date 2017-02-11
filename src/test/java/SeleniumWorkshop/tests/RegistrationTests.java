package SeleniumWorkshop.tests;

import static org.junit.Assert.*;

import SeleniumWorkshop.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTests {

    private static final String PAGE_URL = "http://newtours.demoaut.com";
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.get(PAGE_URL);
    }

    @Test
    public void registerTest() throws InterruptedException {
        String country = "POLAND";
        String userName = "Ben";
        String password = "xxx";
        String firstName = "Zenek";
        String lastName = "Killer";
        String phoneNumber = "Killer";
        String emailAddress = "xxx@wp.pl";
        String addressFirstLine = "krolewska 202";
        String city = "Gdansk";
        String state = "Pomorskie";
        String postalCode = "88-222";


        driver.findElement(By.linkText("REGISTER")).click();

        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phoneNumber);
        driver.findElement(By.id("userName")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(addressFirstLine);
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys(addressFirstLine);
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(postalCode);

        new Select(driver.findElement(By.name("country"))).selectByVisibleText(country);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='register']")).click();

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