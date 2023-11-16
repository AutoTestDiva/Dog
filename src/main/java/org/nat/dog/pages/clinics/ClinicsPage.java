package org.nat.dog.pages.clinics;

import org.nat.dog.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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


    @FindBy(xpath = "//body/div[@id='root']/div[1]/section[1]/div[2]/div[2]/div[1]/form[1]/div[1]/select[1]")
    WebElement cityField;
    @FindBy(xpath = "//option[contains(text(),'Berlin')]")
    WebElement cityInput;
  /*  public ClinicsPage selectCity(String city1) {
        cityField.sendKeys(Keys.DOWN, city1);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }*/
  public ClinicsPage selectCity(String city1) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(cityField));
      Select select = new Select(cityField);
      select.selectByVisibleText(city1);
      return this;
  }
}
