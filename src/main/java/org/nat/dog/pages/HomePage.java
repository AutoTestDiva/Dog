package org.nat.dog.pages;

import org.nat.dog.pages.about.AboutPage;
import org.nat.dog.pages.clinics.ClinicsPage;
import org.nat.dog.pages.contact.ContactPage;
import org.nat.dog.pages.kennels.KennelsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/img[1]")
    WebElement firstPicture;
    public boolean isHomeComponentPresent() {
        return firstPicture.isDisplayed();
    }

    public boolean isRegistrationLinkPresent() {
        return registrationLink.isDisplayed();
    }

    @FindBy(css = "#name-input[name='firstName']")
    WebElement firstNameField;
    @FindBy(css = "#name-input[name='lastName']")
    WebElement lastNameField;
    @FindBy(css = "#name-input[name='userName']")
    WebElement usernameField;
    @FindBy(css = "#name-input[name='city']")
    WebElement cityField;
    @FindBy(css = "#name-input[name='zip']")
    WebElement zipField;
    @FindBy(css = "#name-input[name='username']")
    WebElement emailField;
    @FindBy(css = "#password-input[name='password']")
    WebElement passwordField;
    @FindBy(css = "#password-repeat-input[name='passwordRepeat']")
    WebElement repeatPasswordField;
    public HomePage enterRegistrationData(String firstName, String lastName, String username,
                                          String city, String zip, String email, String password,
                                          String repeatPassword) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(usernameField, username);
        type(cityField, city);
        type(zipField, zip);
        type(emailField, email);
        type(passwordField, password);
        type(repeatPasswordField, repeatPassword);
        return this;
    }

    //залогинивание
    @FindBy(xpath = "//button[contains(text(),'Betreten')]")
    WebElement loginLink;
    public HomePage getLoginLink() {
        click(loginLink);
        return this;
    }

    @FindBy(css = "#name-input[name='username']")
    WebElement userLoginField;
    public HomePage enterLoginData(String username, String password) {
        type(userLoginField, username);
        type(passwordField, password);
        return this;
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
    WebElement submitFormButton;
    public HomePage submit() {
        click(submitFormButton);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement OkButton;
    public HomePage clickOk() {
        pause(1000);
        click(OkButton);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Log Out')]") //потом поменять локатор на Logout
    WebElement logoutLink;
    public HomePage verifyLogout(String logout) {
        Assert.assertTrue(shouldHaveText(logoutLink, logout, 10));
        pause(10);
        return this;
    }

    // регистрация
    @FindBy(xpath = "//button[contains(text(),'Anmeldung')]") //потом поменять локатор на Registered
            WebElement registrationLink;
    public HomePage getRegistrationLink() {
        click(registrationLink);
        return this;
    }

    @FindBy(css = ".form-check-input")
    WebElement clickOnCheckBoxInRegistrationForm;
    public HomePage clickOnCheckBox() {
        click(clickOnCheckBoxInRegistrationForm);
        return this;
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
    WebElement submitInRegistrationFormButton;
       public HomePage submitInRegistrationForm() {
        pause(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(submitInRegistrationFormButton).click().perform();
            return this;
          }

    @FindBy(css = ".invalid-feedback.mb-3")
    WebElement wrongUserName;
    public void warningWrongUserName(String textAboutMistake) {
        Assert.assertTrue(shouldHaveText(wrongUserName, textAboutMistake, 10));
    }

    @FindBy(css = ".invalid-feedback.mb-3")
    WebElement wrongEmail;
    public boolean warningWrongEmail() {
        return wrongEmail.isDisplayed();
    }

    @FindBy(xpath = "//a[contains(text(),'Clinics')]")
    WebElement clinicsLink;
    public ClinicsPage getClinics() {
        click(clinicsLink);
        return new ClinicsPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Kennels')]")
    WebElement kennelsLink;
    public KennelsPage getKennels() {
        click(kennelsLink);
        return new KennelsPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Um')]")
    WebElement aboutLink;
    public AboutPage getAbout() {
        click(aboutLink);
        return new AboutPage(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Ende der Registrierung')]")
    WebElement finishingRegistrationLink;
    public HomePage verifyFinishingRegistration(String text) {
        pause(2000);
        Assert.assertTrue(shouldHaveText(finishingRegistrationLink, text, 20));
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Kontakt')]")
    WebElement contactLink;
    public ContactPage getContact() {
        click(contactLink);
        return new ContactPage(driver);
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._footerLeft_megfo_20 div._ftSocial_megfo_53 a:nth-child(1) > img._ic_megfo_49")
    WebElement facebookLink;
    public HomePage isFacebookComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", facebookLink);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(facebookLink);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._footerLeft_megfo_20 div._ftSocial_megfo_53 a:nth-child(2) > img._ic_megfo_49")
    WebElement instagramLink;
    public HomePage isInstagramComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", instagramLink);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(instagramLink);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._footerLeft_megfo_20 div._ftSocial_megfo_53 a:nth-child(3) > img._ic_megfo_49")
    WebElement youtubeLink;
    public HomePage isYoutubeComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", youtubeLink);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(youtubeLink);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._footerLeft_megfo_20 div._ftInfo_megfo_34 div._ftInfoItem_megfo_38:nth-child(1) > span:nth-child(2)")
    WebElement linkMainAddress;
    public HomePage verifyMainAddress(String text) {
        Assert.assertTrue(isTextPresent(linkMainAddress, text));
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._footerLeft_megfo_20 div._ftInfo_megfo_34 div._ftInfoItem_megfo_38:nth-child(2) > span:nth-child(2)")
    WebElement linkPhone;
    public HomePage verifyPhone(String text) {
        Assert.assertTrue(isTextPresent(linkPhone, text));
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._footerLeft_megfo_20 div._ftInfo_megfo_34 div._ftInfoItem_megfo_38:nth-child(3) > span:nth-child(2)")
    WebElement linkEmail;
    public HomePage verifyEmail(String text) {
        Assert.assertTrue(isTextPresent(linkEmail, text));
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Verkauf von Hunde')]")
    WebElement linkVerkaufVonHunde;
    public HomePage verifyVerkaufVonHunde(String text) {
        Assert.assertTrue(isTextPresent(linkVerkaufVonHunde, text));
        return this;
    }

    public HomePage isVerkaufVonHundeLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkVerkaufVonHunde);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkVerkaufVonHunde);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._ftRight_megfo_64 div._ftMenu_megfo_83:nth-child(1) > a:nth-child(3)")
    WebElement linkHotelFürHunde;
    public HomePage verifyHotelFürHunde(String text) {
        Assert.assertTrue(isTextPresent(linkHotelFürHunde, text));
        return this;
    }

    public HomePage isHotelFürHundeLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkHotelFürHunde);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkHotelFürHunde);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._ftRight_megfo_64 div._ftMenu_megfo_83:nth-child(1) > a:nth-child(4)")
    WebElement linkHundeverpaarrung;
    public HomePage verifyHundeverpaarrung(String text) {
        Assert.assertTrue(isTextPresent(linkHundeverpaarrung, text));
        return this;
    }

    public HomePage isHundeverpaarrungLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkHundeverpaarrung);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkHundeverpaarrung);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._ftRight_megfo_64 div._ftMenu_megfo_83:nth-child(1) > a:nth-child(5)")
    WebElement linkHundesitter;
    public HomePage verifyHundesitter(String text) {
        Assert.assertTrue(isTextPresent(linkHundesitter, text));
        return this;
    }

    public HomePage isHundesitterLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkHundesitter);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkHundesitter);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._ftRight_megfo_64 div._ftMenu_megfo_83:nth-child(2) > a:nth-child(2)")
    WebElement linkDatenschutzbestimmungen;
    public HomePage verifyDatenschutzbestimmungen(String text) {
        Assert.assertTrue(isTextPresent(linkDatenschutzbestimmungen, text));
        return this;
    }

    public HomePage isDatenschutzbestimmungenLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkDatenschutzbestimmungen);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkDatenschutzbestimmungen);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._ftRight_megfo_64 div._ftMenu_megfo_83:nth-child(2) > a:nth-child(5)")
    WebElement linkNutzungsvertrag;
    public HomePage verifyNutzungsvertrag(String text) {
        Assert.assertTrue(isTextPresent(linkNutzungsvertrag, text));
        return this;
    }

    public HomePage isNutzungsvertragLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkNutzungsvertrag);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkNutzungsvertrag);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._ftRight_megfo_64 div._ftMenu_megfo_83:nth-child(2) > a:nth-child(6)")
    WebElement linkZahlung;
    public HomePage verifyZahlung(String text) {
        Assert.assertTrue(isTextPresent(linkZahlung, text));
        return this;
    }

    public HomePage isZahlungLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkZahlung);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkZahlung);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._ftRight_megfo_64 div._ftMenu_megfo_83:nth-child(3) > a:nth-child(3)")
    WebElement linkRegistriren;

    public HomePage verifyRegistriren(String text) {
        Assert.assertTrue(isTextPresent(linkRegistriren, text));
        return this;
    }

    public HomePage isRegistrirenLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkRegistriren);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkRegistriren);
        return this;
    }

    @FindBy(css = "footer._siteFooter_megfo_1:nth-child(3) div._container_megfo_10 div._ftRight_megfo_64 div._ftMenu_megfo_83:nth-child(3) > a:nth-child(4)")
    WebElement linkEineFragenStelen;
    public HomePage verifyEineFragenStelen(String text) {
        Assert.assertTrue(isTextPresent(linkEineFragenStelen, text));
        return this;
    }

    public HomePage isEineFragenStelenLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkEineFragenStelen);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkEineFragenStelen);
        return this;
    }


    @FindBy(tagName = "img")
    List<WebElement> images;
    public HomePage returnListOfImg() {
        System.out.println("The total numbers of iframes: " + images.size());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfImg = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total numbers of items: " + numberOfImg);
        return this;
    }

    @FindBy(css = "section:nth-child(1) form._searchSitters_y0pjj_17 div._descrSearch_y0pjj_29 div._descr1_y0pjj_36 > p._pHunde_y0pjj_47")
    WebElement dogsitterForm;
    public HomePage isDogsitterFormPresent() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", dogsitterForm);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(dogsitterForm);
        return this;
    }

    @FindBy(css = "section:nth-child(1) form._searchSitters_y0pjj_17 div._selectDate_y0pjj_62 div._selectplz_y0pjj_73 > input.form-control")
    WebElement cityFieldInDogsitterForm;
    public HomePage enterCityInCityField(String city) {
       // click(cityFieldInDogsitterForm);
        type(cityFieldInDogsitterForm, city);
         return this;
    }

    @FindBy(xpath = "//p[.='bis 5 kg']")
    WebElement weight;
    public HomePage clickDogWeightField() {
        click(weight);
        return this;
    }



    public HomePage verifyDogWeight(String weightOfTheDog) {
        Assert.assertTrue(shouldHaveText(weight, weightOfTheDog, 10));
        pause(10);
        return this;
    }

    @FindBy(xpath = "//button[.='Wählen Sie einen Hundesitter']")
    WebElement selectDogsitterButton;
    public HomePage clickSelectDogsitter() {
        click(selectDogsitterButton);
        return this;
    }
    @FindBy(xpath = "//h4[.='Wir sind bereit, uns um Ihren Hund zu kümmern']")
    WebElement title;
    public HomePage verifyAppearingList(String listTitle) {
        Assert.assertTrue(shouldHaveText(title, listTitle, 10));
        pause(10);
        return this;
    }

    @FindBy(xpath = "//div[.='sina14@gmail.com']")
    WebElement dogsitterEmailField;
    public HomePage isDogsitterEmailPresent(String dogsitterEmail) {
        Assert.assertTrue(shouldHaveText(dogsitterEmailField, dogsitterEmail, 10));
        pause(10);
        return this;
    }

    @FindBy(xpath = "//button[.='Next']")
    WebElement nextPageOfListButton;
    public HomePage isNextPageOfListClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", nextPageOfListButton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(nextPageOfListButton);
        return this;
    }
}

