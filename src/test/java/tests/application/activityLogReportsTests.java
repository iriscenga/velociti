package tests.application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ActivityLogReportsPage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class activityLogReportsTests {
    private WebDriver driver;

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
    public void checkStatementApprovalReport() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ActivityLogReportsPage activityLogReportsPage = new ActivityLogReportsPage(driver);
        activityLogReportsPage.runReportStatementApproval();
    }
    @Test
    public void checkUserCreationReport() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ActivityLogReportsPage activityLogReportsPage = new ActivityLogReportsPage(driver);
        activityLogReportsPage.runReportUserCreation();
    }
    @Test
    public void checkDeviceDeactivationReport() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("qa@velociti.com","Test1234!");
        Thread.sleep(2000);
        ActivityLogReportsPage activityLogReportsPage = new ActivityLogReportsPage(driver);
        activityLogReportsPage.runReportDeviceDeactivation();
    }
}
