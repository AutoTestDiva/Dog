package org.nat.dog.pages.kennels;

import org.nat.dog.pages.BasePage;
import org.nat.dog.pages.clinics.ClinicsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class KennelsPage extends BasePage {
    public KennelsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//a[contains(text(),'Kennels')]")
    WebElement titleKennels;
    public KennelsPage verifyKennelsElement(String text) {
        Assert.assertTrue(isTextPresent(titleKennels, text));
        return this;
    }
}

