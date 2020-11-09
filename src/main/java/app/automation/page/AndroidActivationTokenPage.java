package app.automation.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;


public class AndroidActivationTokenPage  {
  private AndroidDriver<AndroidElement> androidDriver;

  public AndroidActivationTokenPage(AndroidDriver<AndroidElement> androidDriver) {
    this.androidDriver = androidDriver;
    PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
  }

 // @AndroidFindBy(accessibility = "Myevive_Logo")
  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
  private AndroidElement myEviveLogo;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Discover your benefits with MyEvive']")
  private AndroidElement topTitleText;

 // @AndroidFindBy(className = "android.widget.EditText")
  @AndroidFindBy(accessibility = "Edit_ActivationToken")
  private AndroidElement editActivationToken;

  @AndroidFindBy(accessibility = "Activation_Button")
  private AndroidElement activationButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
  private AndroidElement onboardingTopText;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView")
  private AndroidElement clickOnFirstOption;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
  private AndroidElement loginPath;

  @AndroidFindBy(accessibility = "Client_Logo")
 // @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Client_Logo\"])[2]")
  private AndroidElement clientLogo;

  @AndroidFindBy(accessibility = "Myevive_Logo")
  //@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Myevive_Logo\"])[2]")
  private AndroidElement eviveLogo;

  @AndroidFindBy(accessibility = "Background_Image")
  //@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Background_Image\"])[2]")
  private AndroidElement backgroundImage;

  @AndroidFindBy(accessibility = "LoginPage_EmailField")
  private AndroidElement usernameField;

  @AndroidFindBy(accessibility = "LoginPage_PasswordField")
  private AndroidElement passwordField;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.TextView")
  private AndroidElement forgotLink;

  @AndroidFindBy(accessibility = "Login_Button")
  private AndroidElement loginButton;

 @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup")
 private AndroidElement accountSection;

 @AndroidFindBy(accessibility = "Logout_Button")
 private AndroidElement logoutButton;

  public boolean isMyEviveLogoPresence() {
    return myEviveLogo.isDisplayed();
  }
  public boolean getActivationTitleText() {
    return topTitleText.isDisplayed();
  }
  public boolean androidActivation(String fullCompanyName){
  editActivationToken.sendKeys(fullCompanyName);
  clickOnFirstOption.click();
  activationButton.click();
    androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    return onboardingTopText.isDisplayed();
  }
  public boolean clickOnLoginPath(){
    androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    loginPath.click();
    androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    return usernameField.isDisplayed();
  }
  public boolean isClientLogoPresenceOnLoginPage(){
    return clientLogo.isDisplayed();
  }
  public boolean isEviveLogoPresenceOnLoginPage(){
    return eviveLogo.isDisplayed();
  }
  public boolean isBackgroundImagePresenceOnLoginPage(){
    return backgroundImage.isDisplayed();
  }
  public boolean isForgotLinkPresenceOnLoginPage(){
    return forgotLink.isDisplayed();
  }
  public boolean isLoginSuccess( String username, String password){
    usernameField.sendKeys(username);
    eviveLogo.click();
    passwordField.sendKeys(password);
    eviveLogo.click();
    loginButton.click();
    androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return accountSection.isDisplayed();
  }
  public boolean isLogoutSuccess() {
    accountSection.click();
   logoutButton.click();
    androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return eviveLogo.isDisplayed();
  }

}
