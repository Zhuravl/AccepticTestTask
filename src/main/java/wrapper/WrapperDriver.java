package wrapper;

import org.openqa.selenium.WebDriver;

public class WrapperDriver {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
}
