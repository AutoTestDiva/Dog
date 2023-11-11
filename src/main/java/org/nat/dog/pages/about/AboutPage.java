package org.nat.dog.pages.about;

import org.nat.dog.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AboutPage extends BasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//h1[contains(text(),'About us')]")
    WebElement titleAboutUs;
    public AboutPage verifyAboutElement(String text) {
        Assert.assertTrue(isTextPresent(titleAboutUs, text));
        return this;
    }
}
