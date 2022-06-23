package Tests;

import Pages.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BasicTest {
    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignUpPage signUpPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        navPage = new NavPage(driver);
        signUpPage = new SignUpPage(driver);
        citiesPage = new CitiesPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String timestamp = new SimpleDateFormat(
                "hh_mm_ss_dd_MM_yyyy").format(new Date());

        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot screen = (TakesScreenshot) driver;
            File screenshot = screen.getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(screenshot, new File(
                        "src/main/java/Screenshots/TestFailure_" + timestamp + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
