package org.nat.dog.tests.contactPageTests;

import org.nat.dog.data.UserData;
import org.nat.dog.pages.HomePage;
import org.nat.dog.pages.about.AboutPage;
import org.nat.dog.pages.contact.ContactPage;
import org.nat.dog.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPageTests extends TestBase {
    @BeforeMethod
    public void precondition(){
     new HomePage(driver).getContact();
    }

    @Test
    public void isGoingToGoogleMapsTest() {
        new ContactPage(driver).returnListOfFrames();
    }
  /*  @Test
    public void fillInTouchFormTest() {
        new ContactPage(driver).enterUserData()
    }*/
}
