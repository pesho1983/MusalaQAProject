package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.BASE_URL;

public class LoginPage {

    private WebDriver driver = null;
    //Page URL
    private static final String LOGIN_URL = BASE_URL + "/login";
    //credentials
    @FindBy(id = "profile_email")
    private WebElement email;
    @FindBy(id = "profile_password")
    private WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(LOGIN_URL);
        PageFactory.initElements(driver, this);
    }

    public void successLogInFill() {
        email.sendKeys("abv@abv.bg");
        password.sendKeys("parola123");

    }

    public void failLogIn() {
        email.sendKeys(" ");
        password.sendKeys("parola123");

    }


    public void logIn() {
        logInButton.click();
    }
}
