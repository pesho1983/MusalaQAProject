package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;


public class RegistrationTests {
    private WebDriver driver;


    @Before
    public void setup() {
        //use Chrome Driver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();  //fullscreen
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void registerIndividualPerson() {

        RegistrationPage registration = new RegistrationPage(driver);
        registration.fillIndividualRegistrationForm();
        registration.register();
        registration.isRegisterSuccess();

    }

    @Test
    public void registerLegalPerson() {
        RegistrationPage registration = new RegistrationPage(driver);
        registration.fillLegalRegistrationForm();
        registration.register();
        registration.isRegisterSuccess();
    }

    @After
    public void cleanUp() {
        driver.quit(); //close browser
    }


}
