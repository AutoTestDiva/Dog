package org.nat.dog.tests.homePage;

import org.nat.dog.data.UserData;
import org.nat.dog.pages.HomePage;
import org.nat.dog.tests.TestBase;
import org.nat.dog.utils.DataProviders;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    //проверка элемента на главной странице
    @Test
    public void isHomeComponentPresentTest() {
        new HomePage(driver).isHomeComponentPresent();
    }

    @Test
    public void isRegistrationLinkPresentTest() {
        new HomePage(driver).isRegistrationLinkPresent();
    }

    //проверка позитивной регистрации
    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationDataFormCSVFile")
    public void fillRegistrationFormUsingDataProviderPositiveTest(String firstName, String lastName,
                                                                  String username, String city, String zip,
                                                                  String email, String password,
                                                                  String repeatPassword) {
        new HomePage(driver).getRegistrationLink()
                .enterRegistrationData(firstName, lastName, username, city, zip, email, password, repeatPassword)
                .clickOnCheckBox()
                .submitInRegistrationForm()
                .verifyFinishingRegistration("Окончание регистрации") //потом "Log In" поменять на Logout
                .clickOk();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeRegistrationDataFormCSVFile")
    public void fillRegistrationFormUsingDataProviderNegativeTest(String firstName, String lastName,
                                                                  String username, String city, String zip,
                                                                  String email, String password,
                                                                  String repeatPassword) {
        new HomePage(driver).getRegistrationLink()
                .enterRegistrationData(firstName, lastName, username, city, zip, email, password, repeatPassword)
                .clickOnCheckBox()
                .submitInRegistrationForm()
                .warningWrongEmail();
    }

    @Test   //первый способ ввода юзернейма, password не из файла csv, а из class UserData
    public void loginPositiveTest1() {
        new HomePage(driver).getLoginLink();
        new HomePage(driver)
                .enterLoginData(UserData.USER_NAME, UserData.USER_PASSWORD)
                .submit()
                .verifyLogout("Log Out");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveLoginDataFormCSVFile")
    //с использованием файла
    public void fillLoginFormUsingDataProviderTest(String username, String password) {
        new HomePage(driver).getLoginLink()
                .enterLoginData(username, password)
                .submit()
                .verifyLogout("Log Out"); //потом "Log In" поменять на Logout

    }

    //с использованием файла
    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeLoginDataFormCSVFile")

    public void fillLoginFormUsingDataProviderNegativeTest(String username, String password) {
        new HomePage(driver).getLoginLink()
                .enterLoginData(username, password)
                .submit()
                .warningWrongUserName("Не все поля заполнены");
    }


    @Test
    void imgTest() {
        new HomePage(driver).returnListOfImg();
    }
}