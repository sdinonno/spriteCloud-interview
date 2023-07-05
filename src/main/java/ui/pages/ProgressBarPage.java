package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage extends BasePage {

    @FindBy(id = "startButton")
    private WebElement startButton;

    @FindBy(id = "stopButton")
    private WebElement stopButton;

    @FindBy(id = "progressBar")
    private WebElement progressBar;

    @FindBy(id = "result")
    private WebElement resultMessage;

    public ProgressBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void start(){
        clickElement(startButton);
    }

    public void waitForPercentage(String value){
        waitForAttribute(progressBar, "aria-valuenow", value);
    }

    public void stop(){
        clickElement(stopButton);
    }

    public String getResult(){
        return resultMessage.getText().substring(0,9);
    }
}
