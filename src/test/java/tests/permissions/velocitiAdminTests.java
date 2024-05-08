//package tests.permissions;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pageObjects.LoginPage;
//import permissionsPageObjects.VelocitiAdminPage;
//
//import java.util.concurrent.TimeUnit;
//
//public class velocitiAdminTests {
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
//        loginPage.signIn("velociti.test1@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        VelocitiAdminPage velocitiAdminPage = new VelocitiAdminPage(driver);
//        velocitiAdminPage.subscriptionsProcesses();
//    }
////    @Test
////    public void StatementsPermission() throws InterruptedException{
////        LoginPage loginPage = new LoginPage(driver);
////        loginPage.signIn("velociti.test1@hotmail.com","qqqqqq");
////        Thread.sleep(2000);
////        VelocitiAdminPage velocitiAdminPage = new VelocitiAdminPage(driver);
////        velocitiAdminPage.statementsProcesses();
////    }
////    @Test
////    public void UserManagementPermission() throws InterruptedException{
////        LoginPage loginPage = new LoginPage(driver);
////        loginPage.signIn("velociti.test1@hotmail.com","qqqqqq");
////        Thread.sleep(2000);
////        VelocitiAdminPage velocitiAdminPage = new VelocitiAdminPage(driver);
////        velocitiAdminPage.userManagementProcesses();
////    }
////    @Test
////    public void ClientPermissions() throws InterruptedException{
////        LoginPage loginPage = new LoginPage(driver);
////        loginPage.signIn("velociti.test1@hotmail.com","qqqqqq");
////        Thread.sleep(2000);
////        VelocitiAdminPage velocitiAdminPage = new VelocitiAdminPage(driver);
////        velocitiAdminPage.clientsProcesses();
////    }
////    @Test
////    public void ProvidersPermissions() throws InterruptedException{
////        LoginPage loginPage = new LoginPage(driver);
////        loginPage.signIn("velociti.test1@hotmail.com","qqqqqq");
////        Thread.sleep(2000);
////        VelocitiAdminPage velocitiAdminPage = new VelocitiAdminPage(driver);
////        velocitiAdminPage.providersProcesses();
////    }
//
//
//@Test
//    public void ReportsPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test1@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        VelocitiAdminPage velocitiAdminPage = new VelocitiAdminPage(driver);
//        velocitiAdminPage.reportsProcesses();
//    }
//    @Test
//    public void LandingPagesPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test1@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        VelocitiAdminPage velocitiAdminPage = new VelocitiAdminPage(driver);
//        velocitiAdminPage.landingPagesProcesses();
//    }
//}
