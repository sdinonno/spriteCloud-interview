package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(css = ".col-sm > h3 > a")
    private List<WebElement> optionLinks;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitVisibilityOfAllElements(optionLinks);
    }
    public void openPage(String option){
        clickElement(getElementFromList(optionLinks, option));
    }
}
