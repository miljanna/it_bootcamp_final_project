package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton (){
        return driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getNewItemInput (){
        return driver.findElement(By.id("name"));
    }

    public WebElement getNewItemSaveButton (){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }

    public WebElement getSearchInput (){
        return driver.findElement(By.id("search"));
    }

    public WebElement getEditButton (){
        return driver.findElement(By.id("edit"));
    }

    public WebElement getEditItemInput (){
        return driver.findElement(By.id("name"));
    }

    public WebElement getEditItemSaveButton (){
        return driver.findElement(By.xpath("//div[contains (@class, 'v-card__actions')]/button[2]"));
    }

    public void  waitForEditDialogToBeVisible (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dlgNewEditItem")));
    }

    public void  waitForDeleteDialogToBeVisible () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("warning")));
    }

    public void waitForNumberOfRowsToBe (int numRows){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody/tr"), numRows));
    }

    public WebElement getTheCellFromTheRow (int row, int cell) {
        return driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[" + cell + "]"));
    }

    public WebElement getEditButtonForTheRow (int row){
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]//div/button[1]"));
    }

    public WebElement getDeleteButtonForTheRow (int row){
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]//div/button[2]"));
    }

    public WebElement getDeleteButtonFromDialog (){
        return driver.findElement(By
                .xpath("//div[contains(@class, 'v-dialog__content--active')]/div/div/div[2]/button[2]"));
    }

}
