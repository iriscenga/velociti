package tests.application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.ProvidersPage;

import java.util.concurrent.TimeUnit;

public class providersTests {
    private WebDriver driver;

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
    public void editProductTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ProvidersPage providersPage = new ProvidersPage(driver);
        providersPage.editProductProcess();
    }
    @Test
    public void testAlert1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ProvidersPage providersPage = new ProvidersPage(driver);
        providersPage.checkAlertForPrimaryTerms();
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(),"Please Input Primary Terms (Days).");
    }
    @Test
    public void testAlert2() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ProvidersPage providersPage = new ProvidersPage(driver);
        providersPage.checkAlertForExtendedTerms();
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(),"Please Input Extended Terms (Days).");
    }
}
