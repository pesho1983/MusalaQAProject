import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.RegistrationPage;

public class Config {

    public final static String USERNAME = "tomsmith";
    public final static String PASSWORD = "SuperSecretPassword!";

    public enum Browsers {
        Chrome,
        FireFox
    }


    private WebDriver driver;
    //private String loginURL = "http://the-internet.herokuapp.com/login";


    public WebDriver initLoginAndDriver(Browsers browser) {

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

        driver.get("http://therecordscorner.com/ragistracia"); //launch browser and open the application url
        driver.manage().window().maximize();  //fullscreen
        return driver;
    }
}
