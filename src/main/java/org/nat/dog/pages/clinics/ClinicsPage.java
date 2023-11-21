package org.nat.dog.pages.clinics;

import org.nat.dog.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ClinicsPage extends BasePage {
    public ClinicsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//a[contains(text(),'Clinics')]")
    WebElement titleClinics;
    public ClinicsPage verifyClinicsElement(String text) {
        Assert.assertTrue(isTextPresent(titleClinics, text));
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Clinics')]")
    WebElement clinicsLink;
    @FindBy(css = "div._searchSitters_1prhi_37 div:nth-child(2) div._selectDate_1prhi_83 form:nth-child(1) div._selectplz_1prhi_94 > select:nth-child(2)")
    WebElement cityField;
    public ClinicsPage selectCity(String city1) {
      click(clinicsLink);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(cityField));
      Select select = new Select(cityField);
      select.selectByVisibleText(city1);
      return this;
  }

    @FindBy(xpath="//button[contains(text(),'Show clinic list')]")
    WebElement clinicsListButton;
    public ClinicsPage clickClinicsList() {
        click(clinicsLink);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", clinicsListButton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
      click(clinicsListButton);
      return this;
    }
}
