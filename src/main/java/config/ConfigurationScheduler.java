package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigurationScheduler {

    protected static AppiumDriver<MobileElement> driver;
    protected Logger logger = LoggerFactory.getLogger(ConfigurationScheduler.class);

    //@BeforeMethod
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nex");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");

        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app","C:\\Users\\Comp.ROMAN\\Downloads\\v.0.0.3.apk");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
      //  driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver,new AppiumListener());

    }

    //@AfterMethod
@AfterSuite
    public void tearDown(){
        driver.quit();
    }


}
