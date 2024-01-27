import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;



public class BaseTest {
    public static WebDriver driver = null;

   public static WebDriver driver = null;

    public static WebDriver driver = null;
    public static String url = null;

    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;

    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;

    public static Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod

    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) {

        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = baseURL;
        actions = new Actions(driver);


        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));

        emailField.clear();
        emailField.sendKeys(email);
    }


    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));

        passwordField.clear();
        passwordField.sendKeys(password);
    }


    public void clickSubmit() {
        WebElement clickSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='Submit']")));

        clickSubmit.click();
    }






}