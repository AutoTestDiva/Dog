package org.nat.dog.tests.homePage;

import org.nat.dog.data.UserData;
import org.nat.dog.pages.HomePage;
import org.nat.dog.tests.TestBase;
import org.nat.dog.utils.DataProviders;
import org.testng.annotations.Test;
import static org.nat.dog.data.UserData.USER_EMAIL;
import static org.nat.dog.data.UserData.USER_PASSWORD;

public class HomePageTests extends TestBase {
    @Test
    public void isHomeComponentPresentTest() {
        new HomePage(driver).isHomeComponentPresent();
    }
    @Test(dataProviderClass= DataProviders.class, dataProvider = "loginDataFormCSVFile") //с использованием файла
    public void fillLoginFormUsingDataProviderTest(String email, String password){
              new HomePage(driver).getLoginLink()
                      .enterLoginData(email, password)
                      .submit()
                      .verifyLogout("Log In"); //потом "Log In" поменять на Logout
    }
      @Test   //второй способ ввода email, password не из файла csv, а из class UserData
    public void loginPositiveTest1(){
        new HomePage(driver).getLoginLink();
        new HomePage(driver)
                .enterLoginData(UserData.USER_EMAIL, UserData.USER_PASSWORD)
                .verifyLogout("Log In"); //потом поменять на Logout
    }

    @Test(dataProviderClass= DataProviders.class, dataProvider = "registrationDataFormCSVFile") //с использованием файла
    public void fillRegistrationFormUsingDataProviderTest(String firstName, String lastName,
                                                   String username, String city, String zip,
                                                   String email, String password){
        new HomePage(driver).getRegistrationLink()
                .enterRegistrationData(firstName, lastName, username, city, zip, email, password)
                .clickOnCheckBox()
                .submitInRegistrationForm()
                .verifyLogout("Log In"); //потом "Log In" поменять на Logout
    }
}