import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ReadyToGo {

    @Test
    public void testApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setBrowserName(BrowserType.CHROME);
        cap.setBrowserName(BrowserType.FIREFOX);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);

        driver.get("http://www.google.com");

        Thread.sleep(5000);

        driver.quit();
    }

}