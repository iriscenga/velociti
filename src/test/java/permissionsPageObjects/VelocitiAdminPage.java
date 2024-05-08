package permissionsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VelocitiAdminPage {
    WebDriver driver;
    String pageURL = "https://stage.velocare.app/";

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

    @FindBy (xpath = "//span[normalize-space()='Statements']")
    private WebElement Statements;

    @FindBy (xpath = "//span[normalize-space()='All Statements']")
    private WebElement allStatements;

    @FindBy (xpath = "//span[normalize-space()='Sunbelt North America']")
    private WebElement sunbeltNorthAmerica;

    @FindBy (xpath = "//span[normalize-space()='Approved']")
    private WebElement approved;

    @FindBy (xpath = "//span[@title='Select...']")
    private WebElement select;

    @FindBy (xpath = "//span[normalize-space()='User Management']")
    private WebElement UserManagement;

    @FindBy (xpath = "//span[normalize-space()='+']")
    private WebElement addUserButton;

    @FindBy (css = "li[class='ant-list-item userlist-item active'] ul[class='ant-list-item-action'] li div[role='menuitem']")
    private WebElement disableUser;

    @FindBy (xpath = "//span[normalize-space()='Clients']")
    private WebElement clients;

    @FindBy (xpath = "//span[normalize-space()='Providers']")
    private WebElement providers;

    @FindBy (xpath = "//td[normalize-space()='ZTR']")
    private WebElement ztr;

    @FindBy (xpath = "//td[normalize-space()='Cornell Co-Pilot']")
    private WebElement cornell;

    @FindBy (xpath = "//td[normalize-space()='Genie Lift Connect']")
    private WebElement genie;

    @FindBy (xpath = "//span[normalize-space()='Setup']")
    private WebElement Setup;

    @FindBy (css ="body > div:nth-child(2) > section:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > div:nth-child(2)")
    private WebElement SunbeltNA;

    @FindBy (xpath = "//td[normalize-space()='Trackunit']")
    private WebElement trackUnit;

    @FindBy (xpath = "//span[normalize-space()='Reports']")
    private WebElement Reports;

    @FindBy (xpath = "//span[normalize-space()='Main Reports']")
    private WebElement mainReports;

    @FindBy (xpath = "//span[normalize-space()='Run Report']")
    private WebElement runReportButton;

    @FindBy (css = ".export-button-text")
    private WebElement exportButton1;

    @FindBy (xpath = "//div[normalize-space()='Devices That Have Never Reported']")
    private WebElement DevicesThatHaveNeverReported;

    @FindBy (xpath = "//span[normalize-space()='Apply']")
    private WebElement apply;

    @FindBy (css = "input[placeholder='Search...']")
    private WebElement searchField;

    @FindBy (css = ".config-text")
    private WebElement configButton;

    @FindBy (xpath = "//input[@placeholder='Search Package']")
    private WebElement searchPackage;

    @FindBy (css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;

    @FindBy (xpath = "//div[@class='ant-select-item-option-content']")
    private WebElement sunbeltRentals;

    public VelocitiAdminPage(WebDriver driver){
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
    public void setStatements(){
        Statements.click();
    }
    public void setAllStatements(){
        allStatements.click();
    }
    public void setSunbeltNorthAmerica(){
        sunbeltNorthAmerica.click();
    }
    public void setApproved(){
        approved.click();
    }
    public void setSelect(){
        select.click();
    }
    public void setUserManagement(){
        UserManagement.click();
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
    public void setSunbeltNA(){
        SunbeltNA.click();
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
    public void setMainReports(){
        mainReports.click();
    }

    public void subscriptionsProcesses() throws InterruptedException{
        Subscriptions.isDisplayed();
        setSubscriptions();
        Thread.sleep(500);
        exportButton.isDisplayed();
        searchButton.isDisplayed();
        activeRadioButton.isDisplayed();
    }
    public void statementsProcesses() throws InterruptedException{
        Statements.isDisplayed();
        setStatements();
        Thread.sleep(500);
        allStatements.isDisplayed();
        setAllStatements();
        sunbeltNorthAmerica.isDisplayed();
        setSunbeltNorthAmerica();
        approved.isDisplayed();
        setApproved();
        select.isDisplayed();
        setSelect();
    }
    public void userManagementProcesses(){
        driver.findElement(By.xpath("//span[normalize-space()='Setup']")).click();
        UserManagement.isDisplayed();
        setUserManagement();
        addUserButton.isDisplayed();
        disableUser.isDisplayed();
    }
    public void clientsProcesses(){
        Setup.isDisplayed();
        setSetup();
        clients.isDisplayed();
        setClients();
        SunbeltNA.isDisplayed();
        setSunbeltNA();
        ztr.isDisplayed();
        cornell.isDisplayed();
        genie.isDisplayed();
        trackUnit.isDisplayed();
    }

    public void providersProcesses() throws InterruptedException{
        setSetup();
        Thread.sleep(500);
        setProviders();
        Thread.sleep(500);
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
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
        Thread.sleep(500);
        setMainReports();
        exportButton1.isDisplayed();
        Thread.sleep(1000);
        runReportButton.isDisplayed();
        searchButton.isDisplayed();
        Thread.sleep(1000);
        configureButton.isDisplayed();
    }
    public void landingPagesProcesses(){
        setSelectClient();
        setSunbeltRentals();
        setDevicesThatHaveNeverReported();
        searchField.isDisplayed();
        configButton.isDisplayed();
        apply.isDisplayed();
    }



}
