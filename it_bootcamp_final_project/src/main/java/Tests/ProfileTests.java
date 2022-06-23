package Tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTests extends BasicTest{

    @Test (priority = 10)
    public void visitsTheProfilePage () throws InterruptedException {
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        driver.navigate().to(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"),
                "[ERROR] The current URL does not contain '/profile'.");
        wait.until(ExpectedConditions.attributeToBe(profilePage.getEmailInput(),
                "value", "admin@admin.com"));
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("value"), "admin@admin.com",
                "[ERROR] The email attribute does not have value 'admin@admin.com'.");
        navPage.getLogoutLink().click();
    }

    @Test (priority = 20)
    public void checksInputTypes () throws InterruptedException {
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        driver.navigate().to(baseUrl + "/profile");
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("type"), "email",
                "[ERROR] The attribute type does not have value 'email'.");
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("disabled"), "true",
                "[ERROR] The attribute disabled does not have value 'true'.");
        Assert.assertEquals(profilePage.getNameInput().getAttribute("type"), "text",
                "[ERROR] The attribute type does not have value 'text'.");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("type"), "text",
                "[ERROR] The attribute type does not have value 'text'.");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("type"), "text",
                "[ERROR] The attribute type does not have value 'text'.");
        Assert.assertEquals(profilePage.getUrlTwitterInput().getAttribute("type"), "url",
                "[ERROR] The attribute type does not have value 'url'.");
        Assert.assertEquals(profilePage.getUrlGitHubInput().getAttribute("type"), "url",
                "[ERROR] The attribute type does not have value 'url'.");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("type"), "tel",
                "[ERROR] The attribute type does not have value 'tel'.");
        navPage.getLogoutLink().click();
    }

    @Test (priority = 30)
    public void editProfile () throws InterruptedException {
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        driver.navigate().to(baseUrl + "/profile");
        profilePage.getNameInput().sendKeys(Keys.CONTROL, "a");
        profilePage.getNameInput().sendKeys(Keys.DELETE);
        profilePage.getNameInput().sendKeys("Andjelina");
        profilePage.getPhoneInput().sendKeys(Keys.CONTROL, "a");
        profilePage.getPhoneInput().sendKeys("+38161283223");
        profilePage.getCityInput().sendKeys(Keys.CONTROL, "a");
        profilePage.getCityInput().sendKeys("Bucaramanga");
        profilePage.getNameInput().click();
        profilePage.getCountryInput().sendKeys(Keys.CONTROL, "a");
        profilePage.getCountryInput().sendKeys("Spain");
        profilePage.getUrlTwitterInput().sendKeys(Keys.CONTROL, "a");
        profilePage.getUrlTwitterInput().sendKeys("https://twitter.com/profile/miljana1232");
        profilePage.getUrlGitHubInput().sendKeys(Keys.CONTROL, "a");
        profilePage.getUrlGitHubInput().sendKeys("https://github.com/miljanna");
        profilePage.getSaveButton().click();

        messagePopUpPage.waitForSavedOrDeletedSuccessfullyPopUp();
        Assert.assertTrue(messagePopUpPage.getTextSavedOrDeletedSuccessfullyPopUp().getText()
                        .contains("Profile saved successfuly"), "[ERROR] The changes are not saved.");

        Assert.assertTrue(profilePage.getNameInput().getAttribute("value").contains("Andjelina"),
                "[ERROR] The name attribute does not have value 'Andjelina'.");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("value"), "+38161283223",
                "[ERROR] The phone attribute does not have value '+38161283223'.");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("value"), "Bucaramanga",
                "[ERROR] The city attribute does not have value 'Bucaramanga'.");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("value"), "Spain",
                "[ERROR] The country attribute does not have value 'Spain'.");
        Assert.assertEquals(profilePage.getUrlTwitterInput().getAttribute("value"),
                "https://twitter.com/profile/miljana1232",
                "[ERROR] The urlTwitter attribute does not have value 'https://twitter.com/profile/miljana1232'.");
        Assert.assertEquals(profilePage.getUrlGitHubInput().getAttribute("value"),
                "https://github.com/miljanna",
                "[ERROR] The urlGitHub attribute does not have value 'https://github.com/miljanna'.");
        navPage.getLogoutLink().click();

    }
}
