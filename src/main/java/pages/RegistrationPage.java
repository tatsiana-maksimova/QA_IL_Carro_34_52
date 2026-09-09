package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement inputFirstName;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@name='username']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;
    @FindBy(xpath="//input[@name='termsOfUse']")
    WebElement checkBoxIAgree;
    @FindBy(css = "button.btn--primary")
    WebElement btnYalla;



    public void typeRegistrationForm(User user){
        inputFirstName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());

    }
    public void clickCheckBoxIAgree(){
        checkBoxIAgree.click();
    }

    public void clickbtnYalla(){
        btnYalla.click();
    }


}
