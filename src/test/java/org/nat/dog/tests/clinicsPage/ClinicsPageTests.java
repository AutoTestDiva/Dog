package org.nat.dog.tests.clinicsPage;

import org.nat.dog.pages.HomePage;
import org.nat.dog.pages.clinics.ClinicsPage;
import org.nat.dog.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClinicsPageTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getClinics();
    }

    @Test
    public void isClinicsComponentPresentTest() {
        new ClinicsPage(driver).verifyClinicsElement("Clinics");
    }

}
