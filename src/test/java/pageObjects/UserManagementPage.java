package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagementPage {

    WebDriver driver;
    String UserManagementURL = "https://stage.velocare.app/users";
    WebElement element;

    @FindBy (xpath = "//span[normalize-space()='+']")
    private WebElement addUser;

    @FindBy (xpath = "//input[@id='create-user_fullname']")
    private WebElement fullName;

    @FindBy (xpath = "//input[@id='create-user_email']")
    private WebElement email;

    @FindBy (xpath = "//input[@id='create-user_mobile']")
    private WebElement phoneNumber;

    @FindBy (xpath = "//div[contains(text(),'United States')]")
    private WebElement US;

    @FindBy (css = "div[title='Sunbelt Rentals'] div[class='ant-select-item-option-content']")
    private WebElement SunbeltRentals;

    @FindBy (xpath = "//div[contains(text(),'Sunbelt US')]")
    private WebElement SunbeltUS;

    @FindBy (xpath = "//span[normalize-space()='Client Admin']")
    private WebElement clientAdmin;

    @FindBy (xpath = "//span[contains(text(),'+ Create User')]")
    private WebElement createUserButton;

    @FindBy (xpath = "//span[contains(text(),'All users')]")
    private WebElement filterUsers;

    @FindBy(xpath = "//input[@value='2']")
    private WebElement pendingActivation;

    @FindBy (xpath = "//input[@value='3']")
    private WebElement deactivated;

    @FindBy (xpath = "//input[@value='1']")
    private WebElement active;

    @FindBy (xpath = "//input[@class='ant-input ant-input-lg']")
    private WebElement searchField;

    public UserManagementPage(WebDriver driver){
        this.driver = driver;
        driver.get(UserManagementURL);
        PageFactory.initElements(driver,this);
    }
    public void clickAddUser(){
        addUser.click();
    }
    public void setFullName(String name){
        fullName.click();
        fullName.sendKeys(name);
    }
    public void setEmail(String Email){
        email.click();
        email.sendKeys(Email);

    }
    public void setPhoneNumber(String phone){
        phoneNumber.click();
        phoneNumber.sendKeys(phone);

    }
    public void setSelectCountry()throws InterruptedException{
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]//div[2]//div[1]//div[1]//div[1]//div[1]//span[2]"))).click();
        Thread.sleep(500);
        US.click();
    }
    public void setSelectCompany() throws InterruptedException{
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col']//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//span[2]"))).click();
        Thread.sleep(500);
        SunbeltRentals.click();
    }
    public void setSelectSubsidiary() throws InterruptedException{
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col']//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]//span[2]"))).click();
        Thread.sleep(500);
        SunbeltUS.click();
    }
    public void setUserRole(){
        clientAdmin.click();
    }
    public void setCreateUserButton(){
        createUserButton.click();
    }
    public void createUser(String name, String email, String phone) throws InterruptedException {
        clickAddUser();
        setFullName(name);
        setEmail(email);
        setPhoneNumber(phone);
        setSelectCountry();
        setSelectCompany();
        setSelectSubsidiary();
        setUserRole();
        setCreateUserButton();
    }
    public void createUserWithSameEmail(String name, String email, String phone) throws InterruptedException{
        clickAddUser();
        WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
        addFile.sendKeys("C:\\Users\\LENOVO\\Desktop\\Velociti\\download.png");
        setFullName(name);
        setEmail(email);
        setPhoneNumber(phone);
        setSelectCountry();
        setSelectCompany();
        setSelectSubsidiary();
        setUserRole();
        setCreateUserButton();
    }
    public void phoneNumberTest(String name, String email, String phone) throws InterruptedException{
        clickAddUser();
        Thread.sleep(500);
        setFullName(name);
        Thread.sleep(500);
        setEmail(email);
        setPhoneNumber(phone);
    }

    public void setFilterUsersPending() throws InterruptedException{
        filterUsers.click();
        Thread.sleep(1000);
        pendingActivation.click();
    }

    public void setFilterUsersActive() throws InterruptedException{
        filterUsers.click();
        Thread.sleep(1000);
        active.click();
    }

    public void searchProcess(){
        searchField.click();
        searchField.sendKeys("QA");
    }



}
