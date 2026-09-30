package ui_tests;

import data_provider.UserDataProvider;
import dto.User;
import manager.AppManager;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PopUpPage;
import pages.RegistrationPage;
import utils.TestNGListener;

import java.util.logging.Logger;

import static utils.UserFactory.*;
@Listeners(TestNGListener.class)

public class RegistrationTests extends AppManager {
    RegistrationPage registrationPage;



    @BeforeMethod
    public void goToRegistrationPage() {
        logger.info("Going to the registration page");

        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
    }

    @Test
    public void registrationPositiveTest() {
        User user = positiveUser();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxIAgree();
        registrationPage.clickbtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver()).isTextInPopUpMessagePresent("You are logged in success"));

    }

    @Test
    public void registrationPositiveWithActionsTest() {
        User user = positiveUser();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithAction();
        registrationPage.clickbtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("You are logged in success"));

    }

    @Test(dataProvider = "dataProviderForRegistrationWrongPasswordOrEmail",
            dataProviderClass = UserDataProvider.class)
    public void registrationNegativeWrongPasswordTest(User user) {
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithAction();
        registrationPage.clickbtnYalla();
    }

}

