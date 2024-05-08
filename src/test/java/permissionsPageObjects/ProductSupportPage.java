package permissionsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSupportPage {

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

    @FindBy (xpath = "//span[normalize-space()='Setup']")
    private WebElement Setup;

    @FindBy (xpath = "//span[normalize-space()='Clients']")
    private WebElement clients;

    @FindBy (xpath = "//div[normalize-space()='Devices That Have Never Reported']")
    private WebElement DevicesThatHaveNeverReported;

    @FindBy (xpath = "//span[normalize-space()='Deactivate']")
    private WebElement deactivateButton;

    @FindBy (css = "input[placeholder='Search...']")
    private WebElement searchField;

    @FindBy (css = ".config-text")
    private WebElement configButton;

    public ProductSupportPage(WebDriver driver){
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
        clients.isDisplayed();
        setClients();
        sunbeltNorthAmerica.isDisplayed();
        setSunbeltNorthAmerica();
        ztr.isDisplayed();
        cornell.isDisplayed();
        genie.isDisplayed();
        trackUnit.isDisplayed();
    }
    public void landingPagesProcesses() throws InterruptedException{
        element = driver.findElement(By.xpath("//div[normalize-space()='Devices That Have Never Reported']"));
        element.click();
        Thread.sleep(1000);
        searchField.isDisplayed();
        configButton.isDisplayed();
        deactivateButton.isDisplayed();
    }
}
