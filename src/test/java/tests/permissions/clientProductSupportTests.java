//package tests.permissions;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pageObjects.LoginPage;
//import permissionsPageObjects.ProductSupportPage;
//
//import java.util.concurrent.TimeUnit;
//
//public class clientProductSupportTests {
//    WebDriver driver;
//
//    @Before
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
//    @Test
//    public void SubscriptionManagementPermission() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test4@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ProductSupportPage productSupportPage = new ProductSupportPage(driver);
//        productSupportPage.subscriptionsProcesses();
//    }
//    @Test
//    public void ClientsPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test4@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ProductSupportPage productSupportPage = new ProductSupportPage(driver);
//        productSupportPage.clientsProcesses();
//    }
//    @Test
//    public void LandingPagesPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test4@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ProductSupportPage productSupportPage = new ProductSupportPage(driver);
//        productSupportPage.landingPagesProcesses();
//    }
//
//}
