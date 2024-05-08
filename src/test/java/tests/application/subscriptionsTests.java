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
import pageObjects.SubscriptionsPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class subscriptionsTests {
    private WebDriver driver;
    By locator = By.xpath("//span[@class='ant-table-column-title'][normalize-space()='Status']");

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
    public void findDeviceWithAssetNumber() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        subscriptionsPage.searchDeviceWithAN("741337");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='741337']"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test (expected = org.openqa.selenium.TimeoutException.class)
    public void testFilterStatus() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        subscriptionsPage.TestFilterWithConfigure();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    @Test
    public void checkDeactivationProcess() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        subscriptionsPage.deactivateProcess();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Request Status')]"))).isDisplayed();
        assertTrue(isDisplayed);

    }
}
