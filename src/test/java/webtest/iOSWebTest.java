package webtest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class iOSWebTest {

    IOSDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String testName = "Testing Website on iOS Safari with Java";
    String accessKey = System.getenv("SEETEST_IO_ACCESS_KEY");

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey",accessKey);
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
        driver = new IOSDriver(new URL("https://beta.seetest.io:443/wd/hub"),dc);
    }

    @Test
    public void testYourSiteiOS() throws InterruptedException {

        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
        if( driver.getCapabilities().getCapability("reportUrl").equals("TABLET")){

            driver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys("iPhone");
            driver.findElement(By.xpath("//*[@text='Go']")).click();
        }
        else{
            driver.findElement(By.xpath("//*[@name='k']")).sendKeys("iPhone");
            driver.findElement(By.xpath("//*[@value='Go']")).click();
        }
    }

    @After
    public void tearDown() {
        if (driver != null)
        {
            driver.quit();
            System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));

        }
    }

}