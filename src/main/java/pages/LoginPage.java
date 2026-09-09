package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this );
    }

@FindBy(name = "username")
WebElement inputEmail;
    @FindBy(name = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//button[text()='Y’alla!']")
    WebElement btnYalla;
    @FindBy(xpath = "//h3[text()='You are logged in success']")
    WebElement popUpSuccessLogin;
    @FindBy(xpath = "//h3[text()='Login failed']")
    WebElement popUpFailedLogin;

    public void typeLoginForm(User user){

inputEmail.sendKeys(user.getUsername());
inputPassword.sendKeys(user.getPassword());

    }
    public void clickbtnYalla(){
        btnYalla.click();
    }
    public boolean isPopUpSuccessLoginDisplayed(){
        return isElementDisplayed(popUpSuccessLogin);
    }
    public boolean isPopUpFailedLoginDisplayed(){
        return isElementDisplayed(popUpFailedLogin);
    }

    public boolean isBtnYallaEnabled(){
       return btnYalla.isEnabled();
    }

}
