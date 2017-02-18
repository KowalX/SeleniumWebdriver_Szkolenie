package SeleniumWorkshop.tests;

import SeleniumWorkshop.pages.PageObjectManager;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(DataDrivenTestRunner.class)
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
    public void registerTest(@Param(name = "userName") String userName, @Param(name = "password") String password,
                             @Param(name = "firstName") String firstName, @Param(name = "lastName") String lastName,
                             @Param(name = "phoneNumber") String phoneNumber, @Param(name = "emailAddress") String emailAddress,
                             @Param(name = "country") String country, @Param(name = "addressFirstLine") String addressFirstLine,
                             @Param(name = "addressSecondLine") String addressSecondLine, @Param(name = "city") String city,
                             @Param(name = "state") String state, @Param(name = "postalCode") String postalCode) throws InterruptedException {

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