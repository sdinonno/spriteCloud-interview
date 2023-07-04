package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    protected WebDriver driver;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void clickElement(WebElement element) {
        waitElementToBeClickeable(element);
        element.click();
    }

    protected void addText(WebElement element, String word) {
        waitVisibilityOfElement(element);
        element.sendKeys(word);
    }

    protected void clearField(WebElement element) {
        waitVisibilityOfElement(element);
        element.clear();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    protected void waitElementToBeClickeable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitVisibilityOfElement(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitVisibilityOfAllElements(List<WebElement> elements) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected WebElement getElementFromList(List<WebElement> elements, String text){
        for(WebElement e : elements){
            if(e.getText().equals(text)){
                return e;
            }
        }
        throw new NoSuchElementException("Cannot find element.");
    }

}
