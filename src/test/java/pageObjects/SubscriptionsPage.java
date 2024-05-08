package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubscriptionsPage {
    WebDriver driver;
    String subscriptionsURL = "https://stage.velocare.app/subscriptions";

    @FindBy (css = "input[class='ant-input ant-input-lg']")
    private WebElement searchButton;

    @FindBy (css = "div[role='presentation']")
    private WebElement filter;

    @FindBy (css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement client;

    @FindBy (css = ".ant-select-item-option-content")
    private WebElement sunbeltRentals;

    @FindBy (css = ".ant-drawer-mask")
    private WebElement mask;

    @FindBy (css = "tbody tr:nth-child(1) td:nth-child(1) label:nth-child(1) span:nth-child(1) input:nth-child(1)")
    private WebElement checkbox;

    @FindBy (xpath = "//span[@title='Select Reason']")
    private WebElement selectReason;

    @FindBy (xpath = "//div[contains(text(),'Asset Stolen')]")
    private WebElement assetStolen;

    @FindBy (xpath = "//span[normalize-space()='Apply']")
    private WebElement apply;

    @FindBy (xpath = "//span[normalize-space()='Deactivate devices']")
    private WebElement deactivateDevices;



    public SubscriptionsPage(WebDriver driver){
        this.driver = driver;
        driver.get(subscriptionsURL);
        PageFactory.initElements(driver, this);
    }
    public void setFilter(){
        filter.click();
    }
    public void setClient(){
        client.click();
    }
    public void setSunbeltRentals(){
        sunbeltRentals.click();
    }
    public void setMask(){
        mask.click();
    }

    public void setCheckbox()
    {
        checkbox.click();
    }
    public void setSelectReason(){
        selectReason.click();
    }

    public void setApply(){
        apply.click();
    }

    public void setDeactivateDevices(){
        deactivateDevices.click();
    }
    public void searchDeviceWithAN(String assetNumber) throws InterruptedException{
        setFilter();
        Thread.sleep(500);
        setClient();
        Thread.sleep(500);
        setSunbeltRentals();
        Thread.sleep(500);
        setMask();
        Thread.sleep(2000);
        searchButton.sendKeys(assetNumber);
    }
    public void deactivateProcess() throws InterruptedException{
        setFilter();
        Thread.sleep(500);
        setClient();
        Thread.sleep(500);
        setSunbeltRentals();
        Thread.sleep(500);
        setMask();
        Thread.sleep(2000);
        setCheckbox();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("span[title='Please Select']")).click();
        driver.findElement(By.cssSelector("div[title='DEACTIVATION'] div[class='ant-select-item-option-content']")).click();
        setSelectReason();
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 400);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Asset Stolen')]")));
        element.click();
        setApply();
        Thread.sleep(500);
        setDeactivateDevices();
    }

    public void TestFilterWithConfigure() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Configure')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@class='ant-checkbox-wrapper ant-checkbox-wrapper-checked ant-checkbox-group-item']//span[contains(text(),'Status')]")).click();
    }
}
