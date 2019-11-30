package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static utils.Utils.BASE_URL;
import static utils.Utils.getSaltString;


public class RegistrationPage {

    private WebDriver driver = null;
    //Page URL
    private static final String PAGE_URL = BASE_URL + "/ragistracia";
    //credentials
    @FindBy(id = "profile_email")
    private WebElement email;
    @FindBy(id = "profile_password")
    private WebElement password;
    //IndividualPerson
    @FindBy(id = "profile_billing_type_individual")
    private WebElement individualPerson;
    @FindBy(id = "profile_billing_person_name")
    private WebElement name;

    @FindBy(id = "profile_billing_country")
    private WebElement Select;
    Select dropdown = new Select(Select);

    @FindBy(id = "profile_billing_address")
    private WebElement address;
    @FindBy(id = "profile_billing_phone")
    private WebElement phone;

    //LegalPerson
    @FindBy(xpath = "//*[@id=\"user_account_fields\"]/div[2]/div[2]/div/label")
    private WebElement legalPerson;
    @FindBy(id = "profile_billing_org_name")
    private WebElement nameOrganization;
    @FindBy(id = "profile_billing_org_vat")
    private WebElement eik;
    @FindBy(id = "profile_billing_name")
    private WebElement nameORG;

    //*[@id=\"user_account_fields\"]/div[10]/div[2]/div/div/label/b
    @FindBy(xpath = "//input[@id='confirm_terms_desktop']/../label/b")
    private WebElement agreementsCheckButton;

    @FindBy(xpath = "  //*[@id=\"user_account_fields\"]/div[10]/div[1]/div/div/label")
    private WebElement receiveMessagesCheckButton;

    //Final
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
        String random = getSaltString() + "@abv.bg";
        email.sendKeys(random);
        password.sendKeys("parola123");
        if (!individualPerson.isSelected()) {
            individualPerson.click();
        }

        name.sendKeys("Test Ivanov1");
        dropdown.selectByValue("25");
        address.sendKeys("Banishora blok 100 et 1");
        phone.sendKeys("0889898989");
        if (receiveMessagesCheckButton.isSelected()) {
            receiveMessagesCheckButton.click();
        }
        agreementsCheckButton.click();


    }

    public void fillLegalRegistrationForm() {
        String random = getSaltString() + "@abv.bg";
        email.sendKeys(random);
        password.sendKeys("parola123");

        if (!legalPerson.isSelected()) {
            legalPerson.click();
        }
        nameOrganization.sendKeys("TEst ood");
        eik.sendKeys("12435552");
        nameORG.sendKeys("Test Ivanov1");
        address.sendKeys("Banishora blok 100 et 1");
        phone.sendKeys("0889898989");
        if (receiveMessagesCheckButton.isSelected()) {
            receiveMessagesCheckButton.click();
        }
        agreementsCheckButton.click();
    }

    public void isRegisterSuccess() {
        Assert.assertEquals("Добре дошли, Test Ivanov1!", registerSuccess.getText());
    }

    public void register() {
        registerButton.click();
    }

}
