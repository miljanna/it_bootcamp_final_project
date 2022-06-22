package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 10)
    public void visitsTheLoginPage (){
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesfromAdminDropdown().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] The current URL does not contain '/admin/cities'.");
    }

    @Test(priority = 20)
    public void checksInputTypesForCreateOrEditNewCity (){
//        navPage.getLoginLink().click();
//        loginPage.getEmailInput().sendKeys("admin@admin.com");
//        loginPage.getPasswordInput().sendKeys("12345");
//        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesfromAdminDropdown().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialogToBeVisible();
        Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"), "text",
                "[ERROR] The NewItemInput attribute does not have type 'text'.");
    }

    @Test(priority = 30)
    public void createNewCity () throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesfromAdminDropdown().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialogToBeVisible();
        citiesPage.getNewItemInput().sendKeys("Vienna");
        citiesPage.getNewItemSaveButton().click();
        messagePopUpPage.waitForSavedOrDeletedSuccessfullyPopUp();
        Assert.assertTrue(
                messagePopUpPage.getTextSavedOrDeletedSuccessfullyPopUp().getText().contains("Saved successfully"),
                "[ERROR] The message does not contain 'Saved successfully'.");
    }

    @Test(priority = 40)
    public void editCity () throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesfromAdminDropdown().click();
        citiesPage.getSearchInput().sendKeys("Vienna");
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButtonForTheRow(1).click();
        citiesPage.getNewItemInput().sendKeys(Keys.CONTROL, "a");
        citiesPage.getNewItemInput().sendKeys("Berlin");
        citiesPage.getNewItemSaveButton().click();
        messagePopUpPage.waitForSavedOrDeletedSuccessfullyPopUp();
        Assert.assertTrue(
                messagePopUpPage.getTextSavedOrDeletedSuccessfullyPopUp().getText().contains("Saved successfully"),
                "[ERROR] The message does not contain 'Saved successfully'.");
    }

    @Test (priority = 50)
    public void searchCity (){
//        navPage.getLoginLink().click();
//        loginPage.getEmailInput().sendKeys("admin@admin.com");
//        loginPage.getPasswordInput().sendKeys("12345");
//        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesfromAdminDropdown().click();
        citiesPage.getSearchInput().sendKeys("Berlin");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText(), "Berlin",
                "[ERROR] The name of the city is not the same.");
    }

    @Test (priority = 60)
    public void deleteCity (){
//        navPage.getLoginLink().click();
//        loginPage.getEmailInput().sendKeys("admin@admin.com");
//        loginPage.getPasswordInput().sendKeys("12345");
//        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesfromAdminDropdown().click();
        citiesPage.getSearchInput().sendKeys("Berlin");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText(), "Berlin",
                "[ERROR] The name of the city is not the same.");
        citiesPage.getDeleteButtonForTheRow(1).click();
        citiesPage.waitForDeleteDialogToBeVisible();
        citiesPage.getDeleteButtonFromDialog().click();
        messagePopUpPage.waitForSavedOrDeletedSuccessfullyPopUp();
        Assert.assertTrue(
                messagePopUpPage.getTextSavedOrDeletedSuccessfullyPopUp().getText().contains("Deleted successfully"),
                "[ERROR] The message does not contain 'Deleted successfully'.");

    }
}
