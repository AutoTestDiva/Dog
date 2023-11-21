package org.nat.dog.tests.clinicsPage;

import org.nat.dog.data.UserData;
import org.nat.dog.pages.HomePage;
import org.nat.dog.pages.clinics.ClinicsPage;
import org.nat.dog.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClinicsPageTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getLoginLink();
        new HomePage(driver)
                .enterLoginData(UserData.USER_NAME, UserData.USER_PASSWORD)
                .submit()
                .verifyLogout("Log Out");
    }
    @Test
    public void isClinicsComponentPresentTest() {
        new ClinicsPage(driver).verifyClinicsElement("Clinics");
    }
    @Test
    public void fillClinicsForm(){
        new ClinicsPage(driver).selectCity("Berlin");
    }
    @Test
    public void showClinicsList(){
        new ClinicsPage(driver).clickClinicsList();
    }
}
