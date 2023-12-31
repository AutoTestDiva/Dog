package org.nat.dog.tests.kennelsPage;

import org.nat.dog.data.UserData;
import org.nat.dog.pages.HomePage;
import org.nat.dog.pages.kennels.KennelsPage;
import org.nat.dog.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KennelsPageTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getLoginLink();
        new HomePage(driver)
                .enterLoginData(UserData.USER_NAME, UserData.USER_PASSWORD)
                .submit()
                .verifyLogout("Log Out");
    }
    @Test
    public void KennelsPageTests() {
        new KennelsPage(driver).verifyKennelsElement("Kennels");
    }

    @Test
    public void fillKennelsForm(){
        new KennelsPage(driver).selectKennelsCity("Berlin");
    }
    @Test
    public void showKennelsList(){
        new KennelsPage(driver).clickKennelsList();
    }
}

