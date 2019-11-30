package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class LogInTests {
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
    public void LogIn() {
        RegistrationPage check = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.successLogInFill();
        loginPage.logIn();
        check.isRegisterSuccess();

    }

    @After
    public void cleanUp() {
        driver.quit(); //close browser
    }
}
