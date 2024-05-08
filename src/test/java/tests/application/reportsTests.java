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
import pageObjects.ReportsPage;

import java.util.concurrent.TimeUnit;

public class reportsTests {
    WebDriver driver;
    By locator = By.xpath("//span[@class='ant-table-column-title'][normalize-space()='Providers']");

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
    public void checkReportGenerator() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.runReportProcess();

    }
    @Test
    public void checkReportGeneratorForActivation() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.runReportProcessForActivation();

    }
    @Test (expected = org.openqa.selenium.TimeoutException.class)
    public void testFilterProvider() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.TestFilterWithConfigure();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
