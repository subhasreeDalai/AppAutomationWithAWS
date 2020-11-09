package app.automation.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

@Slf4j
public class BrowserstackAbstractAndroid {
  protected AndroidDriver<AndroidElement> androidDriver;
  @BeforeTest(alwaysRun=true)
  @Parameters({"androidDeviceName","androidPlatformVersion"})
  protected void setUp(String androidDeviceName,String androidPlatformVersion) {
    try {
    String username = "manojr2";
    String access_key = "AGV4QL7wVc8odHdKvARm";
    String server = "hub-cloud.browserstack.com";
    String workingDirectory = System.getProperty("user.dir");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                               androidDeviceName);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                               androidPlatformVersion);
    capabilities.setCapability(MobileCapabilityType.APP, workingDirectory + "/apk/app-release.apk");
    capabilities.setCapability("browserstack.debug",true);
    URL url = new URL("http://"+username+":"+access_key+"@"+server+"/wd/hub");
    androidDriver = new AndroidDriver<>(url, capabilities);
      androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      log.info("Successfully completed capabilities setup");
    } catch (Exception e) {
      log.error("error", e);
    }
  }
  @AfterTest(alwaysRun=true)
  public void tearDown() throws Exception {
    // Invoke driver.quit() to indicate that the test is completed.
    // Otherwise, it will appear as timed out on BrowserStack.
    androidDriver.quit();
  }
}
