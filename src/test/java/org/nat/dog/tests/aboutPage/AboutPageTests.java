package org.nat.dog.tests.aboutPage;

import org.nat.dog.pages.HomePage;
import org.nat.dog.pages.about.AboutPage;
import org.nat.dog.pages.clinics.ClinicsPage;
import org.nat.dog.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutPageTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAbout();
    }

    @Test
    public void isAboutComponentPresentTest() {
        new AboutPage(driver).verifyAboutElement("Um");
    }
}
