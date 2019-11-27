package pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class RegistrationPage extends PageObject implements IPageValidation {

    @FindBy(id = "profile_email")
    WebElementFacade email;
    
    public boolean isValid() {
        return true;
    }
}
