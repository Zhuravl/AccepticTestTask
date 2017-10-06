package tests;

import features.Feature;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import wrapper.WrapperDriver;

import java.util.logging.Logger;

public class FirstTest {

    private static Logger log = Logger.getLogger(FirstTest.class.getName());
    private Feature feature;

    @BeforeTest
    public void setUp() {
        WrapperDriver.driver.set(new FirefoxDriver());
        feature = new Feature();
    }

     @AfterTest
     public void tearDown() {WrapperDriver.driver.get().close();
     }

    @Test(description = "Like/Dislike number test")
    public void likeDislikeNumberTest() throws InterruptedException{
        feature.navigateToSearchPage("http://www.nanorep.com/support/");
        feature.selectSuggestionByRequest("contextual ", "how does the contextual search filter work");
        log.info("The last Like/Dislike value is " + feature.getLastLikeDislikeValue() + "");
    }
}