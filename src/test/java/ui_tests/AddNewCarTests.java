package ui_tests;

import dto.Car;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import pages.PopUpPage;
import utils.CarFactory;
import utils.enums.HeaderMenu;

import java.time.LocalDate;

import static utils.CarFactory.*;
import static utils.PropertiesReader.getProperty;

public class AddNewCarTests extends AppManager {
    LoginPage loginPage;
    LetTheCarWorkPage letTheCarWorkPage;

    @BeforeMethod
    public void goToLetTheCarPage() {
        // new HomePage(getDriver()).clickLogInButton();
        //  loginPage = new LoginPage(getDriver());
        loginPage = new HomePage(getDriver())
                .clickHeaderButtons(HeaderMenu.LOGIN);
        User user = User.builder()
                .username(getProperty("base.properties",
                        "email"))
                .password(getProperty("base.properties",
                        "password"))
                .build();

        loginPage.typeLoginForm(user);
        loginPage.clickbtnYalla();
        new PopUpPage(getDriver()).clickBtnOk();
        letTheCarWorkPage = new HomePage(getDriver()).clickHeaderButtons(HeaderMenu.LET_CAR_WORK);

    }

    @Test
    public void addNewCarPositiveTest() {
        Car car = positiveCar();
        System.out.println(car);
        letTheCarWorkPage.typeAddNewCarForm(car);
        letTheCarWorkPage.downloadImage("car.jpeg");
        letTheCarWorkPage.clickBtnSignUpWithJS();

    }

    @Test
    public void addNewCarNegativeWrongYearTest() {
        Car car = positiveCar();
        car.setYear(String.valueOf(LocalDate.now().getYear() + 1));
        System.out.println(car);
        letTheCarWorkPage.typeAddNewCarForm(car);
        letTheCarWorkPage.downloadImage("car.jpeg");
        letTheCarWorkPage.clickBtnSignUpWithJS();
//        Assert.assertTrue(new PopUpPage(getDriver())
//                .isTextInPopUpMessagePresent("{\"city\":\"must not be blank\"}"));
    }

    @Test
    public void addNewCarNegativeWrongYearNotDugitTest() {
        Car car = positiveCar();
        car.setYear("a");
        System.out.println(car);
        letTheCarWorkPage.typeAddNewCarForm(car);
        letTheCarWorkPage.downloadImage("car.jpeg");
        letTheCarWorkPage.clickBtnSignUpWithJS();
//        Assert.assertTrue(new PopUpPage(getDriver())
//                .isTextInPopUpMessagePresent("{\"city\":\"must not be blank\"}"));
    }


}


