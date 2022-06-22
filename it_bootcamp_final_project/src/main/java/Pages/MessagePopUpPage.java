package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPopUpToBeVisible (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public WebElement getTextFromPopUp (){
        return driver.findElement(By.xpath("//div[contains (@class, 'v-snack__content')]/ul/li"));
    }

    public WebElement getCloseButtonPopUp (){
        return driver.findElement(By.xpath("//div[contains (@class, 'v-snack__content')]/button"));
    }

    public void waitForVerifyAccountPopUp (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains (@class, 'v-dialog--active')]")));
    }

    public WebElement getTextFromVerifyPopUp (){
        return driver.findElement(By.xpath("//div[contains(text(), ' IMPORTANT: Verify your account ')]"));
    }

    public WebElement getCloseButtonFromVerifyAccountPopUp (){

        return driver.findElement(By.className("btnClose"));
    }

    public void waitForSavedOrDeletedSuccessfullyPopUp (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));
    }

    public WebElement getTextSavedOrDeletedSuccessfullyPopUp() {
        return driver.findElement(By
                .xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]"));
    }
}
