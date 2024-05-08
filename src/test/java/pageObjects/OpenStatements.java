package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenStatements {
    WebDriver driver;
    WebElement element;
    String openStatementsURL = "https://stage.velocare.app/open-statements";

    @FindBy(css = "div[title='CLIENT'] div[class='ant-select-selector']")
    private WebElement selectClient;

    @FindBy (css = ".ant-select-item-option-content")
    private WebElement sunbeltRentals;

    @FindBy (xpath = "//td[contains(text(),'ZTR')]")
    private WebElement ZTR;

    @FindBy (xpath = "//td[contains(text(),'Genie Lift Connect')]")
    private WebElement Genie;

    @FindBy (xpath = "//td[contains(text(),'Cornell Co-Pilot')]")
    private WebElement Cornell;

    public OpenStatements(WebDriver driver){
        this.driver = driver;
        driver.get(openStatementsURL);
        PageFactory.initElements(driver,this);
    }

    public void setSelectClient(){
        selectClient.click();
    }
    public void setSunbeltRentals(){
        sunbeltRentals.click();
    }
    public void checkOpenStatements() throws InterruptedException{
        setSelectClient();
        Thread.sleep(500);
        setSunbeltRentals();
        driver.findElement(By.xpath("//span[normalize-space()='Approve']")).isDisplayed();
    }
}
