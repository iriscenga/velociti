package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityLogReportsPage {

    WebDriver driver;
    String pageURL = "https://stage.velocare.app/activity-reports";

    @FindBy (css = "div[class='ant-card ant-card-bordered log-filter'] span[class='ant-select-selection-search']")
    private WebElement log;

    @FindBy (xpath = "//div[contains(text(),'Statement Approval Report')]")
    private WebElement statementApprovalReport;

    @FindBy(css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;

    @FindBy (css = ".ant-select-item-option-content")
    private WebElement sunbeltRentals;

    @FindBy (xpath = "//span[@title='All']")
    private WebElement subsidiary;

    @FindBy(xpath = "//div[contains(text(),'Sunbelt North America')]")
    private WebElement sunbeltNorthAmerica;

    @FindBy (xpath = "//div[@class='ant-select-selection-overflow']")
    private WebElement providers;

    @FindBy (xpath = "//div[contains(text(),'ZTR')]")
    private WebElement ztr;

    @FindBy (xpath = "//span[normalize-space()='Run Report']")
    private WebElement runReport;

    @FindBy (xpath = "//div[contains(text(),'User Creation Report')]")
    private WebElement userCreationReport;

    @FindBy (xpath = "//div[contains(text(),'Device Deactivation Report')]")
    private WebElement deviceDeactivationReport;

    public ActivityLogReportsPage(WebDriver driver){
        this.driver = driver;
        driver.get(pageURL);
        PageFactory.initElements(driver,this);
    }
    public void setLog(){
        log.click();
    }
    public void setStatementApprovalReport(){
        statementApprovalReport.click();
    }
    public void setSelectClient(){
        selectClient.click();
    }
    public void setSunbeltRentals(){
        sunbeltRentals.click();
    }
    public void setSubsidiary(){
        subsidiary.click();
    }
    public void setSunbeltNorthAmerica(){
        sunbeltNorthAmerica.click();
    }
    public void setProviders(){
        providers.click();
    }
    public void setZtr(){
        ztr.click();
    }
    public void setRunReport(){
        runReport.click();
    }
    public void setUserCreationReport(){
        userCreationReport.click();
    }
    public void setDeviceDeactivationReport(){
        deviceDeactivationReport.click();
    }
    public void runReportStatementApproval() throws InterruptedException{
        setLog();
        Thread.sleep(500);
        setStatementApprovalReport();
        Thread.sleep(500);
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
        setRunReport();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("tr[class='ant-table-row ant-table-row-level-0 table-row-light'] td:nth-child(3)")).isDisplayed();

    }
    public void runReportUserCreation() throws InterruptedException{
        setLog();
        Thread.sleep(500);
        setUserCreationReport();
        Thread.sleep(500);
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
        setRunReport();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(4)")).isDisplayed();
    }
    public void runReportDeviceDeactivation() throws InterruptedException{
        setLog();
        Thread.sleep(500);
        setDeviceDeactivationReport();
        Thread.sleep(500);
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
        setRunReport();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)")).isDisplayed();

    }


}
