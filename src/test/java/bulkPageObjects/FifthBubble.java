package bulkPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FifthBubble {
    WebDriver driver;
    By locator = By.xpath("//div[normalize-space()='Assets with Multiptle Services']");

    @FindBy(css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;

    @FindBy (css = ".ant-select-item-option-content")
    private WebElement sunbeltRentals;

    @FindBy (xpath = "//div[normalize-space()='Assets with Multiptle Services']")
    private WebElement assetsWithMultipleServices;

    @FindBy (className = "filter-table-button")
    private WebElement filterButton;

    @FindBy (className = "config-table-button")
    private WebElement configButton;

    @FindBy (xpath = "//span[normalize-space()='Device Model']")
    private WebElement deviceModel;

    @FindBy (xpath = "//span[@title='Select Reason']")
    private WebElement selectReason;

    @FindBy (xpath = "//span[normalize-space()='Apply']")
    private WebElement apply;

    @FindBy (xpath = "//span[normalize-space()='Deactivate devices']")
    private WebElement deactivateDevices;

    public FifthBubble(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSelectClient(){
        selectClient.click();
    }
    public void setSunbeltRentals(){
        sunbeltRentals.click();
    }
    public void setAssetsWithMultipleServices(){
        assetsWithMultipleServices.click();
    }
    public void setConfigButton(){
        configButton.click();
    }
    public void setDeviceModel(){
        deviceModel.click();
    }
    public void setApply(){
        apply.click();
    }
    public void setSelectReason(){
        selectReason.click();
    }
    public void setDeactivateDevices(){
        deactivateDevices.click();
    }
    public void checkConfigButton() throws InterruptedException{
        setSelectClient();
        setSunbeltRentals();
        setAssetsWithMultipleServices();
        setConfigButton();
        Thread.sleep(500);
        setDeviceModel();
    }
    public void deactivateDeviceWithoutReason() throws InterruptedException{
        setSelectClient();
        Thread.sleep(1000);
        setSunbeltRentals();
        Thread.sleep(1000);
        setAssetsWithMultipleServices();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1) label:nth-child(1) span:nth-child(1) input:nth-child(1)")).click();
        Thread.sleep(1000);
        setApply();
    }
    public void checkDeactivateProcess() throws InterruptedException{
        setSelectClient();
        Thread.sleep(1000);
        setSunbeltRentals();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        setAssetsWithMultipleServices();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1) label:nth-child(1) span:nth-child(1) input:nth-child(1)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class='ant-select drilldown-action-select ant-select-single ant-select-show-arrow'] div[class='ant-select-selector']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div[title='DEACTIVATION'] div[class='ant-select-item-option-content']")).click();
        setSelectReason();
        WebElement element;
        WebDriverWait wait1 = new WebDriverWait(driver, 400);
        element= wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Asset Sold')]")));
        element.click();
        setApply();
        Thread.sleep(1000);
        setDeactivateDevices();
        Thread.sleep(1000);
    }
    public void checkValidationProcess() throws InterruptedException{
        setSelectClient();
        Thread.sleep(1000);
        setSunbeltRentals();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        setAssetsWithMultipleServices();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1) label:nth-child(1) span:nth-child(1) input:nth-child(1)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class='ant-select drilldown-action-select ant-select-single ant-select-show-arrow'] div[class='ant-select-selector']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div[title='VALIDATION'] div[class='ant-select-item-option-content']")).click();
        setSelectReason();
        WebElement element;
        WebDriverWait wait1 = new WebDriverWait(driver, 400);
        element= wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Shipment or Installation In Progress')]")));
        element.click();
        setApply();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Validate devices']")).click();
        Thread.sleep(1000);
    }
}
