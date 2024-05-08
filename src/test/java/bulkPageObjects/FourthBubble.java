package bulkPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FourthBubble {
    WebDriver driver;
    String pageUrl = "https://stage.velocare.app/";

    @FindBy (xpath = "//input[@class='ant-input ant-input-lg']")
    private WebElement searchField;

    @FindBy (xpath = "//span[@class='config-text']")
    private WebElement configureButton;

    @FindBy (css = "span[title='Select Reason']")
    private WebElement selectReason;

    @FindBy (xpath = "//span[normalize-space()='Apply']")
    private WebElement apply;

    @FindBy (xpath = "//span[normalize-space()='Deactivate devices']")
    private WebElement deactivateDevices;

    @FindBy (xpath = "//input[@value='daysActive']")
    private WebElement daysActive;

    @FindBy (css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;

    @FindBy (css = ".ant-select-item-option-content")
    private WebElement sunbeltRentals;

    @FindBy (xpath = "//div[normalize-space()='Devices That Have Never Reported']")
    private WebElement DevicesThatHaveNeverReported;

    public FourthBubble(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void setConfigureButton(){
        configureButton.click();
    }

    public void setApply(){
        apply.click();
    }
    public void setDeactivateDevices(){
        deactivateDevices.click();
    }
    public void setSelectReason(){
        selectReason.click();
    }

    public void setDaysActive(){
        daysActive.click();
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
    public void checkConfigButton() throws InterruptedException{
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
        Thread.sleep(500);
        setDevicesThatHaveNeverReported();
        Thread.sleep(500);
        setConfigureButton();
        Thread.sleep(500);
        setDaysActive();
    }
    public void checkDeactivateProcess() throws InterruptedException{
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
        Thread.sleep(500);
        setDevicesThatHaveNeverReported();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1) label:nth-child(1) span:nth-child(1) input:nth-child(1)")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div[class='ant-select drilldown-action-select ant-select-single ant-select-show-arrow'] div[class='ant-select-selector']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div[title='DEACTIVATION'] div[class='ant-select-item-option-content']")).click();
        setSelectReason();
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 400);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Asset Junked')]")));
        element.click();
        setApply();
        Thread.sleep(500);
        setDeactivateDevices();
        Thread.sleep(1000);
    }
    public void searchAsset(String assetNr){
        setSelectClient();
        setSunbeltRentals();
        setDevicesThatHaveNeverReported();
        searchField.clear();
        searchField.click();
        searchField.sendKeys(assetNr);
    }
    public void checkValidationProcess() throws InterruptedException{
        setSelectClient();
        Thread.sleep(1000);
        setSunbeltRentals();
        Thread.sleep(2000);
        setDevicesThatHaveNeverReported();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1) label:nth-child(1) span:nth-child(1) input:nth-child(1)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class='ant-select drilldown-action-select ant-select-single ant-select-show-arrow'] div[class='ant-select-selector']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div[title='VALIDATION'] div[class='ant-select-item-option-content']")).click();
        setSelectReason();
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 400);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Shipment or Installation In Progress')]")));
        element.click();
        setApply();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Validate devices']")).click();
        Thread.sleep(1000);
    }
}
