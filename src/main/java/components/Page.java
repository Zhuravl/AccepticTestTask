package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Page extends BasePage{

    public void enterText(String text){
        navigateInsideFrames();

        typeInto(getElement(By.id("txtSearch")), text);

        returnToDefaultFrame();
    }

    public void getToURL(String url) {
        getUrl(url);
    }

    public void selectItemByText(String suggestion){
        navigateInsideFrames();

        getElement(By.xpath("//div[@id='searchSuggestions']/div[contains(.,'" + suggestion + "')]")).click();

        returnToDefaultFrame();
    }

    public String getLastLikeDislikeValue() {
        navigateInsideFrames();
        List<WebElement> list = getElements(By.xpath("//div[contains(@class, 'newlikes')]"));

        return list.get(list.size()-1).getText();
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("function f() {" +
                "window.scrollTo(0, document.body.scrollHeight);" +
                "setTimeout(function(){" +
                "if ((window).scrollTop() != (document).height()-(window).height()){" +
                "f();}}, 1000);} f()");
    }

    private void navigateInsideFrames(){
        returnToDefaultFrame();
        switchToFrame("supportFrame");
        switchToFrame(By.xpath("//div[@id='nR_WidgetContainer']/iframe[contains(@id, 'nanoRep_frame_embed_')]"));
    }
}
