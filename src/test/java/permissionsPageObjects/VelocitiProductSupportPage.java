package permissionsPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VelocitiProductSupportPage {
    WebDriver driver;
    WebElement element;
    String pageURL = "https://stage.velocare.app/";

    @FindBy(xpath = "//span[normalize-space()='Subscriptions']")
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

    @FindBy (xpath = "//td[normalize-space()='Trackunit']")
    private WebElement trackUnit;

    @FindBy (xpath = "//div[normalize-space()='Devices That Have Never Reported']")
    private WebElement DevicesThatHaveNeverReported;

    @FindBy (xpath = "//span[normalize-space()='Apply']")
    private WebElement apply;

    @FindBy (css = "input[placeholder='Search...']")
    private WebElement searchField;

    @FindBy (css = ".config-text")
    private WebElement configButton;

    @FindBy (css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;

    @FindBy (xpath = "//div[@class='ant-select-item-option-content']")
    private WebElement sunbeltRentals;


    public VelocitiProductSupportPage(WebDriver driver){
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
    public void setSetup(){
        Setup.click();
    }

    public void setClients(){
        clients.click();
    }
    public void setSunbeltNorthAmerica(){
        sunbeltNorthAmerica.click();
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
        configureButton.isDisplayed();
        exportButton.isDisplayed();
        searchButton.isDisplayed();
    }
    public void clientsProcesses(){
        Setup.isDisplayed();
        setSetup();
        setClients();
        sunbeltNorthAmerica.isDisplayed();
        setSunbeltNorthAmerica();
        ztr.isDisplayed();
        cornell.isDisplayed();
        genie.isDisplayed();
        trackUnit.isDisplayed();
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
