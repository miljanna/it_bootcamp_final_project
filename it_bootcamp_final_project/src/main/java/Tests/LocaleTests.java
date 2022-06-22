package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority = 10)
    public void setLocaleToEs (){
        navPage.getLanguageButton().click();
        navPage.getSpanishLanguageButton().click();
        Assert.assertEquals(navPage.getLanguageHeader().getText(), "Página de aterrizaje",
                "[ERROR] Header is not the same.");
    }

    @Test (priority = 20)
    public void setLocaleToEn (){
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertEquals(navPage.getLanguageHeader().getText(), "Landing",
                "[ERROR] Header is not the same.");
    }

    @Test (priority = 30)
    public void setLocaleToCn (){
        navPage.getLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertEquals(navPage.getLanguageHeader().getText(), "首页",
                "[ERROR] Header is not the same.");
    }

    @Test (priority = 40)
    public void setLocaleToFr (){
        navPage.getLanguageButton().click();
        navPage.getFrenchLanguageButton().click();
        Assert.assertEquals(navPage.getLanguageHeader().getText(), "Page d'atterrissage",
                "[ERROR] Header is not the same.");
    }
}
