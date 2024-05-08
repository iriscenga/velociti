package permissionsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientAdminPage {
    WebDriver driver;
    String pageURL="https://stage.velocare.app/";
    WebElement element;

    @FindBy (xpath = "//span[normalize-space()='Subscriptions']")
    private WebElement Subscriptions;

    @FindBy (xpath = "//input[@class='ant-input ant-input-lg']")
    private WebElement searchButton;

    @FindBy (xpath = "//span[@class='config-text']")
    private WebElement configureButton;

    @FindBy (css = ".export-button-text")
    private WebElement exportButton;

    @FindBy (xpath = "//input[@value='ACTIVE']")
    private WebElement activeRadioButton;

    @FindBy (xpath = "//input[@value='DEACTIVATION_PENDING']")
    private WebElement deactivationPendingRadioButton;

    @FindBy (xpath = "//input[@value='DEACTIVATED']")
    private WebElement deactivatedRadioButton;

    @FindBy (xpath = "//span[normalize-space()='User Management']")
    private WebElement UserManagement;

    @FindBy (xpath = "//span[normalize-space()='+']")
    private WebElement addUserButton;

    @FindBy (css = "li[class='ant-list-item userlist-item active'] ul[class='ant-list-item-action'] li div[role='menuitem']")
    private WebElement disableUser;

    @FindBy (xpath = "//span[normalize-space()='Statements']")
    private WebElement Statements;

    @FindBy (xpath = "//span[normalize-space()='All Statements']")
    private WebElement allStatements;

    @FindBy (css = "div[class='ant-card ant-card-bordered subscriptions-card'] div[class='ant-card-head-title']")
    private WebElement subsidiaries;

    @FindBy (xpath = "//div[contains(text(),'STATUSES')]")
    private WebElement statuses;

    @FindBy (xpath = "//div[contains(text(),'BILLING PERIOD')]")
    private WebElement billingPeriod;

    @FindBy (xpath = "//span[normalize-space()='Setup']")
    private WebElement Setup;

    @FindBy (xpath = "//span[normalize-space()='Clients']")
    private WebElement clients;

    @FindBy (xpath = "//span[normalize-space()='Providers']")
    private WebElement providers;

    @FindBy (xpath = "//div[contains(text(),'Sunbelt North America')]")
    private WebElement sunbeltNorthAmerica;

    @FindBy (xpath = "//td[normalize-space()='ZTR']")
    private WebElement ztr;

    @FindBy (xpath = "//td[normalize-space()='Cornell Co-Pilot']")
    private WebElement cornell;

    @FindBy (xpath = "//td[normalize-space()='Genie Lift Connect']")
    private WebElement genie;


    @FindBy (xpath = "//input[@placeholder='Search Package']")
    private WebElement searchPackage;

    @FindBy (xpath = "//span[normalize-space()='Reports']")
    private WebElement Reports;

    @FindBy (xpath = "//span[normalize-space()='Main Reports']")
    private WebElement mainReports;

    @FindBy (xpath = "//span[normalize-space()='Run Report']")
    private WebElement runReportButton;

    @FindBy (css = ".export-button-text")
    private WebElement exportButton1;

    @FindBy (xpath = "//td[normalize-space()='Trackunit']")
    private WebElement trackUnit;

    @FindBy (xpath = "//div[normalize-space()='Devices That Have Never Reported']")
    private WebElement DevicesThatHaveNeverReported;

    @FindBy (xpath = "//span[normalize-space()='Deactivate']")
    private WebElement deactivateButton;

    @FindBy (css = "input[placeholder='Search...']")
    private WebElement searchField;

    @FindBy (css = ".config-text")
    private WebElement configButton;

    @FindBy (css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;

    @FindBy (xpath = "//div[@class='ant-select-item-option-content']")
    private WebElement sunbeltRentals;

    public ClientAdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void setSubscriptions(){
        Subscriptions.click();
    }

    public void setActiveRadioButton(){
        activeRadioButton.click();
    }
    public void setDeactivationPendingRadioButton(){
        deactivationPendingRadioButton.click();
    }
    public void setDeactivatedRadioButton(){
        deactivatedRadioButton.click();
    }

    public void setUserManagement(){
        UserManagement.click();
    }

    public void setStatements(){
        Statements.click();
    }

    public void setAllStatements(){
        allStatements.click();
    }

    public void setSetup(){
        Setup.click();
    }

    public void setClients(){
        clients.click();
    }

    public void setProviders(){
        providers.click();
    }

    public void setSunbeltNorthAmerica(){
        sunbeltNorthAmerica.click();
    }

    public void setReports(){
        Reports.click();
    }
    public void setDevicesThatHaveNeverReported(){
        DevicesThatHaveNeverReported.click();
    }
    public void setSelectClient(){
        selectClient.click();
    }
    public void setSunbeltRentals(){
        sunbeltRentals.click();
    }

    public void subscriptionsProcesses() throws InterruptedException{
        Subscriptions.isDisplayed();
        setSubscriptions();
        Thread.sleep(500);
        exportButton.isDisplayed();
        searchButton.isDisplayed();
    }

    public void userManagementProcesses() throws InterruptedException{
        Setup.isDisplayed();
        setSetup();
        Thread.sleep(500);
        setUserManagement();
        addUserButton.isDisplayed();
        disableUser.isDisplayed();
    }

    public void statementsProcesses() throws InterruptedException{
        Statements.isDisplayed();
        setStatements();
        Thread.sleep(500);
        setAllStatements();
        subsidiaries.isDisplayed();
        statuses.isDisplayed();
        billingPeriod.isDisplayed();
    }

    public void clientsProcesses() throws InterruptedException{
        Setup.isDisplayed();
        setSetup();
        clients.isDisplayed();
        setClients();
        Thread.sleep(1000);
        sunbeltNorthAmerica.isDisplayed();
        setSunbeltNorthAmerica();
        ztr.isDisplayed();
        cornell.isDisplayed();
        genie.isDisplayed();
        trackUnit.isDisplayed();
    }

    public void providersProcesses() throws InterruptedException{
        Setup.isDisplayed();
        setSetup();
        Thread.sleep(500);
        setProviders();
        searchPackage.isDisplayed();
        ztr.isDisplayed();
        cornell.isDisplayed();
        genie.isDisplayed();
        trackUnit.isDisplayed();
        WebElement element = driver.findElement(By.xpath("//tbody/tr[1]/td[9]/button[1]/span[1]"));
        element.isDisplayed();
        element.click();
    }

    public void reportsProcesses() throws InterruptedException{
        Reports.isDisplayed();
        setReports();
        mainReports.isDisplayed();
        Thread.sleep(500);
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Main Reports']"))).click().perform();
        exportButton1.isDisplayed();
        Thread.sleep(500);
        runReportButton.isDisplayed();
        searchButton.isDisplayed();
        Thread.sleep(500);
        configureButton.isDisplayed();
    }
    public void landingPagesProcesses() {
        setDevicesThatHaveNeverReported();
        searchField.isDisplayed();
        configButton.isDisplayed();
        deactivateButton.isDisplayed();
    }

}
