package app.automation.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
@Slf4j
public abstract class AbstractAndroidAppTest {
  protected AndroidDriver<AndroidElement> androidDriver;

  protected void androidSetup() {
    try {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
      capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.evivernappv0");
      capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                                 "com.evivernappv0.MainActivity");
      URL url = new URL("http://127.0.0.1:4723/wd/hub");
      androidDriver = new AndroidDriver<>(url, capabilities);
      androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      log.info("Successfully completed capabilities setup");
    } catch (Exception e) {
      log.error("error", e);
    }
  }
}
