package org.nat.dog.pages.clinics;

import org.nat.dog.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ClinicsPage extends BasePage {
    public ClinicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@id='root']/div/div/h1")
    WebElement titleClinics;
    public ClinicsPage verifyClinicsElement(String text) {
        Assert.assertTrue(isTextPresent(titleClinics, text));
        return this;
    }
}
