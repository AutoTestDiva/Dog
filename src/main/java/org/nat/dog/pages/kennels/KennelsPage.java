package org.nat.dog.pages.kennels;

import org.nat.dog.pages.BasePage;
import org.nat.dog.pages.clinics.ClinicsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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



    @FindBy(css = "div._searchSitters_bvmua_26 div:nth-child(2) div._selectDate_bvmua_75 form:nth-child(1) div._selectplz_bvmua_87 > select:nth-child(2)")
    WebElement cityKennelsField;
   // @FindBy(xpath = "//option[contains(text(),'Berlin')]")
   // WebElement cityKennelsInput;
    public KennelsPage selectKennelsCity(String city1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cityKennelsField));
        Select select = new Select(cityKennelsField);
        select.selectByVisibleText(city1);
        return this;
    }


    @FindBy(xpath="//button[contains(text(),'Swow kennels list')]")
    WebElement kennelsListButton;
    public KennelsPage clickKennelsList() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", kennelsListButton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        click(kennelsListButton);
        return this;
    }
}

