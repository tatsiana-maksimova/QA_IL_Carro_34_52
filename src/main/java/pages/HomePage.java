package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utils.PropertiesReader.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        setDriver(driver);
        //driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        driver.get(getProperty("base.properties",  "baseUrl"));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//a[@href='/login']")
    WebElement btnLogIn;
    @FindBy(xpath = "//a[text()= 'Sign up']")
    WebElement btnSignUp;
    @FindBy(id = "city")
    WebElement inputCity;
    @FindBy(id = "dates")
    WebElement inputDates;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;


    public void clickLogInButton(){
        btnLogIn.click();
    }

    public void clickBtnSignUp(){
        btnSignUp.click();
    }

    public void typeSearchForm(String city, LocalDate startDate, LocalDate endDate) {
        inputCity.sendKeys(city);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateRange = startDate.format(formatter) + " - " + endDate.format(formatter);

        // Передаем значение напрямую в атрибут value элемента
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + dateRange + "';", inputDates);
        btnYalla.click();
    }

}