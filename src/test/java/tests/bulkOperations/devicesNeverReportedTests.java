package tests.bulkOperations;

import bulkPageObjects.FourthBubble;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class devicesNeverReportedTests {
    WebDriver driver;
    By locator = By.xpath("//span[@class='ant-table-column-title'][normalize-space()='Days Active']");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test(expected = org.openqa.selenium.TimeoutException.class)
    public void configButtonTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        FourthBubble fourthBubble = new FourthBubble(driver);
        fourthBubble.checkConfigButton();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    @Test
    public void followStepsToDeactivateDevice() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com", "Test1234!");
        Thread.sleep(2000);
        FourthBubble fourthBubble = new FourthBubble(driver);
        fourthBubble.checkDeactivateProcess();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Request Status')]"))).isDisplayed();
        assertTrue(isDisplayed);

    }
    @Test
    public void isExplicitPackageFound() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com", "Test1234!");
        Thread.sleep(2000);
        FourthBubble fourthBubble = new FourthBubble(driver);
        fourthBubble.searchAsset("7010100690");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ant-table-cell ant-table-column-sort']"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test
    public void followStepsToValidateDevice() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com", "Test1234!");
        Thread.sleep(2000);
        FourthBubble fourthBubble = new FourthBubble(driver);
        fourthBubble.checkValidationProcess();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Request Status')]"))).isDisplayed();
        assertTrue(isDisplayed);
    }
}
