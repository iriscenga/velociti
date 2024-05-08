package tests.application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.UserManagementPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class userManagementTests {
    WebDriver driver;
    By locator = By.xpath("body > div:nth-child(2) > section:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > li:nth-child(3) > div:nth-child(1) > div:nth-child(2) > h4:nth-child(1) > div:nth-child(1) > p:nth-child(1)");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void missingMandatoryField()throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.createUser("Test","test@gmail.com","+355678954334");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please complete all the fields.')]"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test
    public void sameEmailTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.createUserWithSameEmail("Test","test@gmail.com","+355678954334");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='ant-modal'] div[class='ant-modal-body']"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test
    public void phoneNumberFormat() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.phoneNumberTest("Test","test@gmail.com","hag56vg56788");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test
    public void pendingActivationFilter() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.setFilterUsersPending();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(2) > section:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > li:nth-child(3) > div:nth-child(1) > div:nth-child(2) > h4:nth-child(1) > div:nth-child(1) > p:nth-child(1)"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test(expected = org.openqa.selenium.TimeoutException.class)
    public void activeFilter() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.setFilterUsersActive();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    @Test
    public void checkSearchProcess() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.searchProcess();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".username"))).isDisplayed();
        assertTrue(isDisplayed);
    }
}
