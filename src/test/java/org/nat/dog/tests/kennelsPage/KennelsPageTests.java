package org.nat.dog.tests.kennelsPage;

import org.nat.dog.pages.HomePage;
import org.nat.dog.pages.clinics.ClinicsPage;
import org.nat.dog.pages.kennels.KennelsPage;
import org.nat.dog.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KennelsPageTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getKennels()
                .pause(1000);
    }

    @Test
    public void isKennelsComponentPresentTest() {
        new KennelsPage(driver).verifyKennelsElement("Kennels");
    }

}

