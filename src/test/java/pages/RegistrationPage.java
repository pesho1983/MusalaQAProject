package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.BASE_URL;


public class RegistrationPage {

    private WebDriver driver = null;
    //Page URL
    private static final String PAGE_URL = BASE_URL + "/ragistracia";

    @FindBy(id = "profile_email")
    private WebElement email;
    @FindBy(id = "profile_password")
    private WebElement password;

    @FindBy(id = "profile_billing_person_name")
    private WebElement name;
    @FindBy(id = "profile_billing_address")
    private WebElement address;
    @FindBy(id = "profile_billing_phone")
    private WebElement phone;

    @FindBy(xpath = "//*[@id=\"user_account_fields\"]/div[10]/div[2]/div/div/label/b")
    private WebElement agreementsCheckButton;

    @FindBy(xpath = "  //*[@id=\"user_account_fields\"]/div[10]/div[1]/div/div/label")
    private WebElement receiveMessagesCheckButton;

    @FindBy(id = "profile_billing_type_individual")
    private WebElement individualPerson;
    @FindBy(id = "profile_billing_type_company")
    private WebElement legalPerson;
    @FindBy(xpath = "//*[@id=\"user_account_fields\"]/div[10]/button")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"page_content\"]/h1")
    private WebElement registerSuccess;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);

    }

    public void fillIndividualRegistrationForm() {

        email.sendKeys("abv1@abv.bg");
        password.sendKeys("parola123");
        if (!individualPerson.isSelected()) {
            individualPerson.click();
        }

        name.sendKeys("Test Ivanov1");
        address.sendKeys("Banishora blok 100 et 1");
        phone.sendKeys("0889898989");
        if (receiveMessagesCheckButton.isSelected()) {
            receiveMessagesCheckButton.click();
        }
         agreementsCheckButton.click();


    }

    public void fillLegalRegistrationForm() {

        legalPerson.click();
        email.sendKeys("abv@abv.bg");

    }
    public void isRegisterSuccess(){
        Assert.assertEquals("Добре дошли, Test Ivanov1!",registerSuccess.getText());
    }

    public void register() {
        registerButton.click();
    }

}
