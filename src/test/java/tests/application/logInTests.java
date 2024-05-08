package tests.application;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class logInTests {
    private WebDriver driver;
    By locator = By.xpath("//div[@class='ant-modal-body']");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void logInWithValidCredentials() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.signIn("qa@velociti.com", "Test1234!");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Home')]")).getText(), "Home");
    }
    @Test
    public void logInWithInvalidEmail(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.signIn("wrong email", "Test1234!");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    @Test
    public void logInWithInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.signIn("qa@velociti.com", "wrong password");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    @Test
    public void logOutTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOut("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-label']")).getText(),"Log in");
    }
    @Test
    public void forgotPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotPasswordFunction("qa@velociti.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-body']"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test
    public void randomUnusedEmailTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotPasswordFunction("test@gmail.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-body']"))).isDisplayed();
        assertTrue(isDisplayed);
    }
}
