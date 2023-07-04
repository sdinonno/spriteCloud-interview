package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleAppPage extends BasePage{

    @FindBy(css = ".form-control[name = 'UserName']")
    private WebElement userNameInput;

    @FindBy(css = ".form-control[name = 'Password']")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement logInButton;

    @FindBy(id = "loginstatus")
    private WebElement loginStatusMessage;

    public SampleAppPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logIn(String userName, String password){
        addText(userNameInput, userName);
        addText(passwordInput, password);
        clickElement(logInButton);
    }

    public void logOut(){
        if(logInButton.getText().equals("Log Out"))
            clickElement(logInButton);
    }

    public String getLoginStatusMessage(){
        waitVisibilityOfElement(loginStatusMessage);
        return loginStatusMessage.getText();
    }

    public String getLogInButtonText(){
        waitElementToBeClickeable(logInButton);
        return logInButton.getText();
    }

}
