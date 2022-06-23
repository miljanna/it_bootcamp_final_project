package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailInput (){
        return driver.findElement(By.id("email"));
    }

    public WebElement getNameInput (){
        return driver.findElement(By.id("name"));
    }

    public WebElement getCityInput (){
        return driver.findElement(By.id("city"));
    }

    public WebElement getCountryInput (){
        return driver.findElement(By.id("country"));
    }

    public WebElement getUrlTwitterInput (){
        return driver.findElement(By.id("urlTwitter"));
    }

    public WebElement getUrlGitHubInput (){
        return driver.findElement(By.id("urlGitHub"));
    }

    public WebElement getPhoneInput (){
        return driver.findElement(By.id("phone"));
    }

    public WebElement getSaveButton (){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }

}
