package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest{

    @Test(priority = 10)
    public void visitsTheSignUpPage (){
        navPage.getSignupLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] The current URL does not contain '/signup'.");
    }

    @Test(priority = 20)
    public void checksInputType (){
        navPage.getSignupLink().click();
        Assert.assertEquals(signUpPage.getEmailInputInSignup().getDomAttribute("type"), "email",
                "[ERROR] The attribute type does not have value 'email'.");
        Assert.assertEquals(signUpPage.getPasswordInputInSignUp().getDomAttribute("type"), "password",
                "[ERROR] The attribute type does not have value 'password'.");
        Assert.assertEquals(signUpPage.getConfirmPasswordInput().getDomAttribute("type"), "password",
                "[ERROR] The attribute type does not have value 'password'.");

    }

    @Test (priority = 30)
    public void displaysErrorsWhenUserAlreadyExist (){
        navPage.getSignupLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] The current URL does not contain '/signup'.");
        signUpPage.getNameInput().sendKeys("Another User");
        signUpPage.getEmailInputInSignup().sendKeys("admin@admin.com");
        signUpPage.getPasswordInputInSignUp().sendKeys("12345");
        signUpPage.getConfirmPasswordInput().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextFromPopUp().getText(),
                "E-mail already exists", "[ERROR] Email does not exist.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] The current URL does not contain '/signup'.");
    }

    @Test (priority = 40)
    public void signUp () throws InterruptedException {
        navPage.getSignupLink().click();
        signUpPage.getNameInput().sendKeys("Miljanaa Cvetkovic");
        signUpPage.getEmailInputInSignup().sendKeys("miljana.cvetkovic994@itbootcamp.rs");
        signUpPage.getPasswordInputInSignUp().sendKeys("12345");
        signUpPage.getConfirmPasswordInput().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();

        messagePopUpPage.waitForVerifyAccountPopUp();
        Assert.assertEquals(messagePopUpPage.getTextFromVerifyPopUp().getText(),
                "IMPORTANT: Verify your account",
                "[ERROR] The message in VerifyPopUp is not the same.");
        messagePopUpPage.getCloseButtonFromVerifyAccountPopUp().click();
        navPage.getLogoutLink().click();
    }
}
