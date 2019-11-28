package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver = null;
    //Page URL
    private static final String PAGE_URL = "https://www.therecordscorner.com/ragistracia";

    @FindBy(id = "profile_email")
    private WebElement email;
    @FindBy(id = "profile_billing_type_individual")
    private WebElement individualPerson;
    @FindBy(id = "profile_billing_type_company")
    private WebElement legalPerson;
    @FindBy(xpath = "//*[@id=\"user_account_fields\"]/div[10]/button")
    private WebElement registerButton;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);

    }

    public void fillIndividualRegistrationForm() {
        email.sendKeys("abv@abv.bg");
        registerButton.click();

    }

    public void fillLegalRegistrationForm() throws InterruptedException {


        legalPerson.click();
        email.sendKeys("abv@abv.bg");
        registerButton.click();
    }

}
