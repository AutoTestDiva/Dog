package org.nat.dog.tests.dogsitterPage;

import org.nat.dog.data.UserData;
import org.nat.dog.pages.HomePage;
import org.nat.dog.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DogsitterPageTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getLoginLink();
        new HomePage(driver)
                .enterLoginData(UserData.USER_NAME, UserData.USER_PASSWORD)
                .submit()
                .verifyLogout("Log Out");
    }

    @Test
    public void isDogsitterFormPresentTest() {
        new HomePage(driver).isDogsitterFormPresent();
    }

    @Test
    public void fillDogsitterFormTest() {
        new HomePage(driver).isDogsitterFormPresent()
                .enterCityInCityField("Berlin")
                .clickDogWeightField()
                .verifyDogWeight("bis 5 kg")
                .clickSelectDogsitter()
                .verifyAppearingList("Wir sind bereit, uns um Ihren Hund zu kümmern")
                .isDogsitterEmailPresent("BEREIT, ZEIT MIT IHREM HUND ZU VERBRINGEN")
                .isNextPageOfListClickable();
    }
}
