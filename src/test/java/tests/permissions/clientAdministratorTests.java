//package tests.permissions;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pageObjects.LoginPage;
//import permissionsPageObjects.ClientAdminPage;
//
//import java.util.concurrent.TimeUnit;
//
//public class clientAdministratorTests {
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
//        loginPage.signIn("velociti.test3@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ClientAdminPage clientAdminPage = new ClientAdminPage(driver);
//        clientAdminPage.subscriptionsProcesses();
//    }
//    @Test
//    public void UserManagementPermission() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test3@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ClientAdminPage clientAdminPage = new ClientAdminPage(driver);
//        clientAdminPage.userManagementProcesses();
//    }
//
//    @Test
//    public void StatementsPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test3@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ClientAdminPage clientAdminPage = new ClientAdminPage(driver);
//        clientAdminPage.statementsProcesses();
//    }
//
//    @Test
//    public void ClientsPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test3@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ClientAdminPage clientAdminPage = new ClientAdminPage(driver);
//        clientAdminPage.clientsProcesses();
//    }
//
//    @Test
//    public void ProvidersPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test3@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ClientAdminPage clientAdminPage = new ClientAdminPage(driver);
//        clientAdminPage.providersProcesses();
//    }
//
//    @Test
//    public void ReportsPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test3@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ClientAdminPage clientAdminPage = new ClientAdminPage(driver);
//        clientAdminPage.reportsProcesses();
//    }
//    @Test
//    public void LandingPagesPermissions() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.signIn("velociti.test3@hotmail.com","qqqqqq");
//        Thread.sleep(2000);
//        ClientAdminPage clientAdminPage = new ClientAdminPage(driver);
//        clientAdminPage.landingPagesProcesses();
//    }
//}
