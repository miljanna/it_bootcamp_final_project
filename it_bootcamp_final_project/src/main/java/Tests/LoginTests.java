package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BasicTest{

    @Test(priority = 10)
    public void visitsTheLoginPage (){
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] The current URL does not contain '/login'.");
    }

    @Test (priority = 20)
    public void checksInputTypes (){
        navPage.getLoginLink().click();
        Assert.assertEquals(loginPage.getEmailInput().getDomAttribute("type"), "email",
                "[ERROR] The attribute type does not have value 'email'.");
        Assert.assertEquals(loginPage.getPasswordInput().getDomAttribute("type"), "password",
                "[ERROR] The attribute type does not have value 'password'.");
    }

    @Test (priority = 30)
    public void displaysErrorsWhenUserDoesNotExist (){
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextFromPopUp().getText(),
                "User does not exists", "[ERROR] User exist.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] The current URL does not contain '/login'.");
    }

    @Test (priority = 40)
    public void displaysErrorsWhenPasswordIsWrong (){
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextFromPopUp().getText(),
                "Wrong password", "[ERROR] Password is correct.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] The current URL does not contain '/login'.");
    }

    @Test (priority = 50)
    public void login () throws InterruptedException {
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "[ERROR] The current URL does not contain '/home'.");
    }

    @Test (priority = 60)
    public void logout () throws InterruptedException {
        Assert.assertTrue(navPage.getLogoutLink().isDisplayed(),
                "[ERROR] The logout button is not displayed.");
        navPage.getLogoutLink().click();
    }
}
