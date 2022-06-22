package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink (){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[1]"));
    }

    public WebElement getAboutLink (){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[2]"));
    }

    public WebElement getSignupLink (){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[4]"));
    }

    public WebElement getMyProfileLink (){
        return driver.findElement(By.xpath("//a[contains(@class, 'btnProfile')]"));
    }

    public WebElement getAdminButton (){
        return driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesfromAdminDropdown (){
        return driver.findElement(By.className("btnAdminCities"));
    }

    public WebElement getUsersfromAdminDropdown (){
        return driver.findElement(By.className("btnAdminUsers"));
    }

    public WebElement getLoginLink (){
        return driver.findElement(By.xpath("//*[contains (@class, 'btnLogin')]"));
    }

    public WebElement getLogoutLink (){
        return driver.findElement(By.className("btnLogout"));
    }

    public WebElement getLanguageButton (){
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnglishLanguageButton (){
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement getSpanishLanguageButton (){
        return driver.findElement(By.className("btnES"));
    }

    public WebElement getFrenchLanguageButton (){
        return driver.findElement(By.className("btnFR"));
    }

    public WebElement getChineseLanguageButton (){
        return driver.findElement(By.className("btnCN"));
    }

    public WebElement getLanguageHeader (){
        return driver.findElement(By.xpath("//div[contains(@class, 'text-xs-center')]/h1"));
    }
}
