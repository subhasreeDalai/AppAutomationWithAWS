package app.automation.pages.android;

import app.automation.common.BrowserstackAbstractAndroid;
import app.automation.page.AndroidActivationTokenPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserStackAndroidTest extends BrowserstackAbstractAndroid {
  private AndroidActivationTokenPage androidActivationTokenPage;
  private static final String UNLOCK_YOUR_BENEFITS_WITH_MY_EVIVE = "Discover your benefits with MyEvive";
  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";

  @BeforeClass(alwaysRun = true)
  public void setup(){
    androidActivationTokenPage = new AndroidActivationTokenPage(androidDriver);
  }
  @AfterClass(alwaysRun = true)
  public void destroy() {
    androidDriver.quit();
  }
  @Test(priority = 1, description = "Verify myevive logo is  presence on employers drop down app.page.")
  public void verifyMyeviveLogoPresence() {
    Assert.assertTrue(androidActivationTokenPage.isMyEviveLogoPresence());
  }
  @Test(priority = 2, description = "Verify activation title text on employers drop down app.page.")
  public void verifyActivationTitleText() {
    Assert.assertFalse(androidActivationTokenPage.getActivationTitleText());
  }
  @Test(priority = 3, description = "Verify successfully activate the app.")
  public void androidActivation() {
    Assert.assertTrue(androidActivationTokenPage.androidActivation("DaVita"));
  }
  @Test(priority = 4, description = "Verify successfully click on login path")
  public void verifyLoginPath() {
    Assert.assertTrue(androidActivationTokenPage.clickOnLoginPath());
  }
  @Test(priority = 5, description = "Verify client logo", dependsOnMethods = "verifyLoginPath")
  public void verifyClientLogo() {
    Assert.assertTrue(androidActivationTokenPage.isClientLogoPresenceOnLoginPage());
  }
  @Test(priority = 6, description = "Verify evive logo", dependsOnMethods = "verifyLoginPath")
  public void verifyEviveLogo() {
    Assert.assertTrue(androidActivationTokenPage.isMyEviveLogoPresence());
  }
  @Test(priority = 7, description = "Verify background image", dependsOnMethods = "verifyLoginPath")
  public void verifyBackgroundImage() {
    Assert.assertTrue(androidActivationTokenPage.isBackgroundImagePresenceOnLoginPage());
  }
  @Test(priority = 8, description = "Verify forgot link")
  public void verifyForgotLink() {
    Assert.assertTrue(androidActivationTokenPage.isForgotLinkPresenceOnLoginPage());
  }
  @Test(priority = 9, description = "Verify loginSuccess")
  public void verifySuccessLogin() {
    Assert.assertTrue(androidActivationTokenPage.isLoginSuccess(USERNAME,PASSWORD));
  }
  @Test(priority = 10, description = "Verify logout Success")
  public void verifySuccessLogout() {
    Assert.assertTrue(androidActivationTokenPage.isLogoutSuccess());
  }
}
