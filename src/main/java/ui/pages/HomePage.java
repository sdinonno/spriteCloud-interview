package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(css = ".col-sm > h3 > a")
    private List<WebElement> optionLinks;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openPage(String option){
        clickElement(getElementFromList(optionLinks, option));
    }
}
