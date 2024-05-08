package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProvidersPage {
    WebDriver driver;
    String providersURL = "https://stage.velocare.app/providers";
    WebElement element;

    @FindBy (css = "input[placeholder='Search Package']")
    private WebElement searchButton;

    @FindBy (xpath = "//tbody/tr[2]/td[1]")
    private WebElement expandButton;

    @FindBy (xpath = "//tbody/tr[1]/td[9]/button[1]/span[1]")
    private WebElement setupButton;

    @FindBy (xpath = "//a[normalize-space()='Edit']")
    private WebElement editButton;

    @FindBy (xpath = "//div[@class='ant-select-selector']")
    private WebElement productType;

    @FindBy (xpath = "//div[contains(text(),'Cameras')]")
    private WebElement cameras;

    @FindBy (xpath = "//input[@id='primaryTerms']")
    private WebElement primaryTerms;

    @FindBy (xpath = "//input[@id='extendedTerms']")
    private WebElement extendedTerms;

    @FindBy (xpath = "//a[normalize-space()='Save']")
    private WebElement save;

    @FindBy (css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;

    @FindBy (css = ".ant-select-item-option-content")
    private WebElement sunbeltRentals;

    public  ProvidersPage(WebDriver driver){
        this.driver = driver;
        driver.get(providersURL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    public void setSetupButton(){
        setupButton.click();
    }
    public void setEditButton(){
        editButton.click();
    }
    public void setProductType(){
        productType.click();
    }
    public void setSelectClient(){
        selectClient.click();
    }
    public void setSunbeltRentals(){
        sunbeltRentals.click();
    }
    public void setPrimaryTerms(){
        primaryTerms.click();
        String s = Keys.chord(Keys.CONTROL, "a");
        primaryTerms.sendKeys(s);
        primaryTerms.sendKeys(Keys.DELETE);
        primaryTerms.sendKeys("5");
    }
    public void setExtendedTerms(){
        extendedTerms.click();
        String s = Keys.chord(Keys.CONTROL, "a");
        extendedTerms.sendKeys(s);
        extendedTerms.sendKeys(Keys.DELETE);
        extendedTerms.sendKeys("5");
    }
    public void setSave(){
        save.click();
    }
    public void setSearchButton(String nameOfThePackage) {
        setSelectClient();
        setSunbeltRentals();
        driver.findElement(By.xpath("(//span[@role='presentation'])[1]")).click();
        searchButton.clear();
        searchButton.click();
        searchButton.sendKeys(nameOfThePackage);

    }
    public void editProductProcess() throws InterruptedException{
        setSelectClient();
        setSunbeltRentals();
        setSetupButton();
        setEditButton();
        setProductType();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Cameras')]")));
        element.click();
        Thread.sleep(500);
        setPrimaryTerms();
        Thread.sleep(500);
        setExtendedTerms();
        Thread.sleep(500);
        setSave();
    }
    public void checkAlertForPrimaryTerms() throws InterruptedException{
        setSelectClient();
        setSunbeltRentals();
        setSetupButton();
        setEditButton();
        setProductType();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Cameras')]")));
        element.click();
        Thread.sleep(500);
        primaryTerms.click();
        String s = Keys.chord(Keys.CONTROL, "a");
        primaryTerms.sendKeys(s);
        primaryTerms.sendKeys(Keys.DELETE);
    }
    public void checkAlertForExtendedTerms() throws InterruptedException{
        setSelectClient();
        setSunbeltRentals();
        setSetupButton();
        setEditButton();
        setProductType();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Cameras')]")));
        element.click();
        Thread.sleep(500);
        extendedTerms.click();
        String s = Keys.chord(Keys.CONTROL, "a");
        extendedTerms.sendKeys(s);
        extendedTerms.sendKeys(Keys.DELETE);
    }

}
