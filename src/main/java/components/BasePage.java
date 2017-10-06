package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrapper.WrapperDriver;

import java.util.List;

public abstract class BasePage {
    private WebDriver driver;

    public BasePage(){
        driver = WrapperDriver.driver.get();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void getUrl(String url){
        driver.get(url);
    }

    public WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public void typeInto(WebElement input, String text){
        input.clear();
        input.sendKeys(text);
    }

    public void returnToDefaultFrame(){
        driver.switchTo().defaultContent();
    }

    public void switchToFrame(String id){
        driver.switchTo().frame(id);
    }

    public void switchToFrame(By by){
        driver.switchTo().frame(driver.findElement(by));
    }
}
