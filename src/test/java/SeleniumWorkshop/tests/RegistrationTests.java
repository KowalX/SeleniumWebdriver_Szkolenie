package SeleniumWorkshop.tests;

import SeleniumWorkshop.annotationObjects.User;
import SeleniumWorkshop.converters.UserConverter;
import SeleniumWorkshop.pages.PageObjectManager;
import org.easetech.easytest.annotation.Converters;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(DataDrivenTestRunner.class)
@Converters({UserConverter.class})
@DataLoader(filePaths = "src/test/resources/DataDrivenTestFile.xml", loaderType = LoaderType.XML, writeData = false)
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
    public void registerTest(User user) throws InterruptedException {

        manager.getHomePage().clickOnRegisterLink();

        manager.getRegisterPage().fillContactInformation(user.getFirstName(), user.getLastName(), user.getPhoneNumber(),
                user.getEmailAddress());
        manager.getRegisterPage().fillMailingInformation(user.getAddressFirstLine(), user.getAddressSecondLine(),
                user.getCity(), user.getState(), user.getPostalCode(), user.getCountry());
        manager.getRegisterPage().fillUserInformation(user.getUserName(), user.getPassword());
        manager.getRegisterPage().clickOnRegisterButton();

        manager.getRegistrationConfirmPage().signOffAvailable();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}