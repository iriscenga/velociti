package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingPage {

    WebDriver driver;
    String billingURL = "https://stage.velocare.app/billing";
    WebElement element;

    @FindBy (xpath = "//span[normalize-space()='Sunbelt North America']")
    private WebElement NorthAmericaSubsidiary;

    @FindBy (xpath = "//span[normalize-space()='Approved']")
    private WebElement approvedTelematics;


    @FindBy (xpath = "//span[normalize-space()='Open']")
    private WebElement openTelematics;


    @FindBy(css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;


    @FindBy (css = ".ant-select-item-option-content")
    private WebElement sunbeltRentals;


    public BillingPage(WebDriver driver){
        this.driver = driver;
        driver.get(billingURL);
        PageFactory.initElements(driver, this);
    }
    public void NorthAmericaSubsidiaryClick(){
        NorthAmericaSubsidiary.click();
    }
    public void approvedTelematicsClick(){
        approvedTelematics.click();
    }
    public void openTelematicsClick(){
        openTelematics.click();
    }

    public void setSelectClient(){
        selectClient.click();
    }
    public void setSunbeltRentals(){
        sunbeltRentals.click();
    }
    public void getBillingHistoryApprovedTelematics()throws InterruptedException{
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
    }
    public void getBillingHistoryOpenTelematics() throws InterruptedException{
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
    }
    public void showDetails() throws  InterruptedException{
        NorthAmericaSubsidiaryClick();
        approvedTelematicsClick();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 400);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[role='presentation']")));
        element.click();
    }
}
