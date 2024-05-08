package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportsPage {
    WebDriver driver;
    String reportsURL = "https://stage.velocare.app/reports";
    WebElement element;


    @FindBy (xpath = "//span[normalize-space()='Deactivation']")
    private WebElement deactivationRadioButton;

    @FindBy (className = "ant-picker-input")
    private WebElement calendar;

    @FindBy (css = "button[class='ant-btn ant-btn-primary ant-btn-round run-report-btn']")
    private WebElement runReport;

    @FindBy (css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement client;

    @FindBy (css = ".ant-select-item-option-content")
    private WebElement sunbeltRentals;

    @FindBy (xpath = "//span[@title='All']")
    private WebElement allSubsidiaries;

    @FindBy (xpath = "//div[contains(text(),'Sunbelt US')]")
    private WebElement sunbeltUS;

    @FindBy (xpath = "//div[@class='ant-select-selection-overflow']")
    private WebElement providers;

    @FindBy (xpath = "//div[contains(text(),'ZTR')]")
    private WebElement ztr;

    @FindBy (xpath = "//div[contains(text(),'Cornell Co-Pilot')]")
    private WebElement cornell;




    public ReportsPage(WebDriver driver){
        this.driver = driver;
        driver.get(reportsURL);
        PageFactory.initElements(driver, this);
    }

    public void setClient(){
        client.click();
    }
    public void setSunbeltRentals(){
        sunbeltRentals.click();
    }
    public void setAllSubsidiaries(){
        allSubsidiaries.click();
    }
    public void setSunbeltUS(){
        sunbeltUS.click();
    }
    public void setProviders(){
        providers.click();
    }
    public void setZtr(){
        ztr.click();
    }
    public void setCornell(){
        cornell.click();
    }
    public void deactivationRadioButtonClick(){
        deactivationRadioButton.click();
    }

    public void calendarClick(){
        calendar.click();
    }

    public void runReportClick(){
        runReport.click();
    }

    public void runReportProcess() throws InterruptedException{
        deactivationRadioButtonClick();
        setClient();
        Thread.sleep(500);
        setSunbeltRentals();
        Thread.sleep(500);
        setAllSubsidiaries();
        Thread.sleep(500);
        setSunbeltUS();
        calendarClick();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-picker-header-prev-btn']")));
        element.click();
        element.click();
        element.click();
        element.click();
        driver.findElement(By.xpath("//div[normalize-space()='16']")).click();
        runReportClick();
    }
    public void runReportProcessForActivation() throws InterruptedException{
        setClient();
        Thread.sleep(500);
        setSunbeltRentals();
        Thread.sleep(500);
        setAllSubsidiaries();
        Thread.sleep(500);
        setSunbeltUS();
        calendarClick();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-picker-header-prev-btn']")));
        element.click();
        element.click();
        element.click();
        element.click();
        driver.findElement(By.xpath("//div[normalize-space()='16']")).click();
        runReportClick();

    }

    public void TestFilterWithConfigure() throws InterruptedException{
        runReportProcess();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Configure')]")));
        Thread.sleep(500);
        element.click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@value='providerName']")).click();
    }
}
