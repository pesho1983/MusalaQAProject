import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;


public class LoginToRCPage {

    private WebDriver driver = null;
    private String URL = "https://www.therecordscorner.com/login";

    private void LoginToRCPageDriver(String username, String password, Config.Browsers browser) {
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

        driver.get(URL); //launch browser and open the application url
        driver.manage().window().maximize();  //fullscreen

        WebElement userName = driver.findElement(By.id("profile_email"));//  definirame promenliva i namirame element po id za tazi promenliva
        userName.sendKeys("savanikolov1900@yahoo.com"); //podava st-st za username
        WebElement passWord = driver.findElement(By.id("profile_password"));
        passWord.sendKeys("123456");
        WebElement btnLogin = driver.findElement(By.xpath("//form[@id='page_login_form']//button[@type='submit']"));
        btnLogin.click();
    }

    @Test
    public void successLogin() throws InterruptedException {
        LoginToRCPageDriver(Config.USERNAME, Config.PASSWORD, Config.Browsers.Chrome);

        //verify login
        sleep(1000);
        //WebElement linkMyProfile = driver.findElement(By.xpath("//header[@id='header']/div[1]/div/nav[1]/a[@href='https://www.therecordscorner.com/nachalo']"));
        WebElement  logout1 = driver.findElement(By.xpath("//a[@href='/logout']"));
        sleep(1000);


        WebElement linkMyProfile = driver.findElement(By.xpath("//header[@id='header']/div[1]/div/nav[1]/a[@href='https://www.therecordscorner.com/nachalo']"));
        logout1 = driver.findElement(By.xpath("//header[@id='header']/div[1]/div/nav[1]/a[@href='https://www.therecordscorner.com/logout']"));
        if (linkMyProfile.isDisplayed() || logout1.isDisplayed()){
            Assert.assertTrue(logout1.isDisplayed());
        }

    }

    @After
    public void cleanUp() {
        driver.quit(); //close browser
    }


}
