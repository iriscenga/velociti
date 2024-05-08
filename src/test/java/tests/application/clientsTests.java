package tests.application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ClientsPage;
import pageObjects.LoginPage;
import java.util.concurrent.TimeUnit;

public class clientsTests {
    WebDriver driver;

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
    public void checkNorthAmericaSubsidiaryPage() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ClientsPage clientsPage = new ClientsPage(driver);
        clientsPage.SunbeltRentalsClick();
        clientsPage.getSunbeltUS();
        Assert.assertEquals("Sunbelt US", driver.findElement(By.cssSelector("div.name")).getText());
    }
    @Test
    public void checkUKSubsidiaryPage() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ClientsPage clientsPage = new ClientsPage(driver);
        clientsPage.getCanada();
        Assert.assertEquals("Sunbelt Canada", driver.findElement(By.cssSelector("div.name")).getText());
    }
}
