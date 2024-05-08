package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {
    WebDriver driver;
    String clientsURL = "https://stage.velocare.app/clients";

    @FindBy (xpath = "//div[normalize-space()='Sunbelt Canada']")
    private WebElement Canada;

    @FindBy (xpath = "//div[normalize-space()='Sunbelt US']")
    private WebElement SunbeltUS;

    @FindBy (xpath = "//span[normalize-space()='SUNBELT RENTALS']")
    private WebElement SunbeltRentals;

    public ClientsPage(WebDriver driver){
        this.driver = driver;
        driver.get(clientsURL);
        PageFactory.initElements(driver, this);
    }
    public void SunbeltRentalsClick(){
        SunbeltRentals.click();
    }
    public void getSunbeltUS(){
        SunbeltUS.click();
    }
    public void getCanada(){
        Canada.click();
    }
}
