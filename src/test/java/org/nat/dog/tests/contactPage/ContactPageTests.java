package org.nat.dog.tests.contactPage;

import org.nat.dog.pages.HomePage;
import org.nat.dog.pages.contact.ContactPage;
import org.nat.dog.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.nat.dog.data.UserData.*;

public class ContactPageTests extends TestBase {
    @BeforeMethod
    public void precondition(){
     new HomePage(driver).getContact();
    }
    @Test
    public void isGoingToGoogleMapsTest() {
        new ContactPage(driver).returnListOfFrames();
    }
    @Test
    public void fillInTouchFormTest() {
        new ContactPage(driver).enterUserData(USER_NAME_FOR_CONTACT_FORM,
                USER_EMAIL_FOR_CONTACT_FORM, MESSAGE_FOR_CONTACT_FORM)
                .sendMessageButton();
    }
}
