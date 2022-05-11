import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ReadyToGo {

    WebDriver driver;

    @Test
    public void testApp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(BrowserType.CHROME);
        //cap.setBrowserName(BrowserType.FIREFOX);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

        driver.get("http://www.google.com");
        Thread.sleep(1000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}