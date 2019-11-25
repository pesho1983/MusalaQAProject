import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class LoginFormTests {
    private WebDriver driver = null;
    private String loginURL = "http://the-internet.herokuapp.com/login";

    private enum Browsers {
        Chrome,
        FireFox
    }

    private void initLoginAndDriver(String username, String password, Browsers browser) {

        switch (browser) {
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver(); //chrome instance
                break;
            case FireFox:
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");

                driver = new FirefoxDriver(); //chrome instance
                break;
            default:
                System.out.println("Choose browser!!!");
                break;
        }

        driver.get(loginURL); //launch browser and open the application url
        driver.manage().window().maximize();  //fullscreen

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(username);
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys(password);
        WebElement login = driver.findElement(By.className("radius"));
        login.click();

    }

    @Test
    public void successLogin() throws InterruptedException {
        initLoginAndDriver("tomsmith", "SuperSecretPassword!", Browsers.Chrome);

        //verify login
        sleep(1000);
        //WebElement linkMyProfile = driver.findElement(By.xpath("//header[@id='header']/div[1]/div/nav[1]/a[@href='https://www.therecordscorner.com/nachalo']"));
        WebElement logout = driver.findElement(By.xpath("//a[@href='/logout']"));
        sleep(1000);
        Assert.assertTrue(logout.isDisplayed());

    }

    @Test
    public void invalidLoginPassword() throws InterruptedException {
        initLoginAndDriver("tomsmith", "SuperSecretPassword!123", Browsers.FireFox);
        sleep(1000);
        WebElement loginFailMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(
                loginFailMessage.getText().contains("Your password is invalid!"));

    }

    @Test
    public void invalidLoginUsername() throws InterruptedException {
        initLoginAndDriver("tomsmith123", "SuperSecretPassword!", Browsers.FireFox);
        sleep(1000);
        WebElement loginFailMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(
                loginFailMessage.getText().contains("Your username is invalid!"));

    }

    @Test
    public void validationMessageEmail() throws InterruptedException {
        initLoginAndDriver("", "", Browsers.FireFox);
        sleep(1000);
        WebElement loginFailMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(
                loginFailMessage.getText().contains("Your username is invalid!"));
    }

    @After
    public void cleanUp() {
        driver.quit(); //close browser
    }
}
