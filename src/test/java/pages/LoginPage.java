package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.BASE_URL;

public class LoginPage {

    private WebDriver driver = null;
    //Page URL
    private static final String PAGE_URL = BASE_URL + "/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }



}
