package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    String pageURL = "https://stage.velocare.app/";

    @FindBy (className = "login-label")
    private WebElement heading;

    @FindBy (id = "normal-login_email")
    private WebElement EmailField;

    @FindBy (id = "normal-login_password")
    private WebElement PasswordField;

    @FindBy (xpath= "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy (xpath = "//span[contains(text(),'Log Out')]")
    private WebElement logOutButton;

    @FindBy (id = "normal-login_forgot")
    private WebElement forgotPassword;

    @FindBy (className = "ant-input")
    private WebElement emailInput;

    @FindBy (xpath = "//span[contains(text(),'Send Link')]")
    private WebElement sendLinkButton;


    public  LoginPage(WebDriver driver){
        this.driver = driver;
        driver.get(pageURL);
        PageFactory.initElements(driver, this);
    }
    public void setUserEmail(String usersEmail) {
        EmailField.clear();
        EmailField.sendKeys(usersEmail);
    }
    public void setUserPassword(String usersPassword) {
        PasswordField.clear();
        PasswordField.sendKeys(usersPassword);
    }
    public void clickOnSubmit() {
        submitButton.click();
    }
    public void clickLogOutButton(){
        logOutButton.click();
    }
    public void clickForgotPassword(){
        forgotPassword.click();
    }
    public void setEmailInput(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void clickSendLinkButton(){
        sendLinkButton.click();
    }
    public void signIn(String usersEmail, String password) {
        if (isPageOpened()) {
            setUserEmail(usersEmail);
            setUserPassword(password);
            clickOnSubmit();
        }
    }
    public void logOut(String usersEmail, String password) throws InterruptedException{
        if(isPageOpened()){
            setUserEmail(usersEmail);
            setUserPassword(password);
            clickOnSubmit();
            Thread.sleep(1000);
            clickLogOutButton();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Log Out')]")).click();
        }
    }

    public boolean isPageOpened() {
        return heading.getText().contains("Log in");
    }
    public void forgotPasswordFunction(String email){
        clickForgotPassword();
        setEmailInput(email);
        clickSendLinkButton();
    }
}
