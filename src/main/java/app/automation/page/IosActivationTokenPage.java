/*
package app.automation.page;

import com.evive.appAutomation.utill.AppTestUtil;
import com.evive.webAutomation.util.WaitUtil;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class IosActivationTokenPage {

  private IOSDriver<IOSElement> iosDriver;

  public IosActivationTokenPage(IOSDriver<IOSElement> iosDriver) {
    PageFactory.initElements(new AppiumFieldDecorator(iosDriver), this);
    this.iosDriver = iosDriver;
  }

  @iOSXCUITFindBy(id = "Allow")
  private IOSElement allowButton;

  @iOSXCUITFindBy(id = "Don't Allow")
  private IOSElement dontAllowButton;

  @iOSXCUITFindBy(accessibility = "Myevive_Logo")
  private IOSElement myEviveLogo;

  @iOSXCUITFindBy(accessibility = "Unlock your benefits with MyEvive")
  private IOSElement topTitleText;

  @iOSXCUITFindBy(accessibility = "Start by entering the first few letters of your employer’s name below. You’ll then be able to pick from a drop-down list.")
  private IOSElement employersToptext;

  @iOSXCUITFindBy(accessibility = "Start by entering your employer-sponsored token code below.")
  private IOSElement activationTopText;

  @iOSXCUITFindBy(accessibility = "Edit_ActivationToken_placeholder")
  private IOSElement placeholderText;

  @iOSXCUITFindBy(accessibility = "Edit_ActivationToken")
  private IOSElement editActivationToken;

  @iOSXCUITFindBy(accessibility = "Activation_Button")
  private IOSElement activationButton;

  @iOSXCUITFindBy(accessibility = "Use a token code instead")
  private IOSElement activationLink;

  @iOSXCUITFindBy(accessibility = "Use employer name instead")
  private IOSElement employerNameLink;

  @iOSXCUITFindBy(accessibility = "Please enter a valid token")
  private IOSElement invalidTokenErrorText;

  @iOSXCUITFindBy(accessibility = "Company name not found. Contact the Evive Member Service Center at memberservices@goevive.com for help.")
  private IOSElement invalidClentNameErrorText;

  @iOSXCUITFindBy(accessibility = "How will you use your benefits today?")
  private IOSElement onboardingTopText;

  @iOSXCUITFindBy(accessibility = "DropDown_List")
  private List<IOSElement> dropdownList;

  @iOSXCUITFindBy(accessibility = "Your employer doesn’t offer the MyEvive app yet.")
  private IOSElement titleOfNonEviveClientPage;

  @iOSXCUITFindBy(accessibility = "Email_Field")
  private IOSElement emailField;

  @iOSXCUITFindBy(accessibility = "Email_Field_placeholder")
  private IOSElement emailFieldPlaceHolder;

  @iOSXCUITFindBy(accessibility = "Check_Box")
  private IOSElement checkBox;

  @iOSXCUITFindBy(accessibility = "I give MyEvive permission to send me updates in accordance with the Privacy Policy.")
  private IOSElement policyText;

  @iOSXCUITFindBy(accessibility = "Continue_Button")
  private IOSElement continueButton;

  @iOSXCUITFindBy(accessibility = "Recaptcha requires verification. I'm not a robot")
  private IOSElement captchaCheckbox;

  @iOSXCUITFindBy(accessibility = "Please enter a valid email id.")
  private IOSElement invalidEmailErrorText;

  @iOSXCUITFindBy(accessibility = "recaptcha challenge")
  private IOSElement captchaChallenge;

  @iOSXCUITFindBy(accessibility = "header-back")
  private IOSElement backButton;

 */
/* @iOSXCUITFindBy(accessibility = "Choose your home screen icon")
  private IOSElement cobrandingTitle;
*//*


  //Actions
  public boolean isAllowButtonPresent() {
    return allowButton.isDisplayed();
  }

  public boolean isDontAllowButtonPresent() {
    return dontAllowButton.isDisplayed();
  }

  public void clickAllowOnActivationPopup() {
    allowButton.click();
  }

  */
/*public void clickDontAllowOnActivationPopup() {
    dontAllowButton.click();
  }*//*


  public boolean isMyEviveLogoPresence() {
    return myEviveLogo.isDisplayed();
  }

  public String getActivationTitleText() {
    return topTitleText.getText();
  }

  public String getEmployerTopText() {
    return employersToptext.getText();
  }

  public String getActivationTopText() {
    return activationTopText.getText();
  }

  public boolean isIosActivationFieldDisplayed() {
    return editActivationToken.isDisplayed();
  }

  public boolean verifyIosActivationFieldeditable() {
    return AppTestUtil.isIosElementEnabled(editActivationToken);
  }

  public String verifyInvalidClientNameErrorText(String invalidToken) {
    editActivationToken.sendKeys(invalidToken);
    iosDriver.hideKeyboard();
    return invalidClentNameErrorText.getText();
  }

  public boolean verifyIosActivationButtonPresence() {
    return activationButton.isDisplayed();
  }

  public boolean verifyIosActivationLinkPresence() {
    return activationLink.isDisplayed();
  }

  public String getIosActivationLinkText() {
    return activationLink.getText();
  }

  public String verifyEmployerPlaceHolderText() {
    return placeholderText.getText();
  }

  public boolean verifyIosActivationLInkClickable() {
    AppTestUtil.isIosElementClickable(activationLink);
    return employerNameLink.isDisplayed();
  }

  public String verifyPlaceHolderText() {
    return placeholderText.getText();
  }

  public String getIosEmployerLinkText() {
    return employerNameLink.getText();
  }

  public String verifyInvalidTokenErrorText(String invalidToken) {
    editActivationToken.sendKeys(invalidToken);
    iosDriver.hideKeyboard();
    activationButton.click();
    return invalidTokenErrorText.getText();
  }

  public boolean verifyIosEmployerLInkClickable() {
    AppTestUtil.isIosElementClickable(employerNameLink);
    return activationLink.isDisplayed();
  }

  public boolean verifySuggestionListCount(String companyName) {
    editActivationToken.sendKeys(companyName);
    iosDriver.hideKeyboard();
    return 3 >= dropdownList.size();
  }

  public String isDisplayedNonEviveClientPage(String nonEviveCompanyName) {
    editActivationToken.clear();
    editActivationToken.sendKeys(nonEviveCompanyName);
    for (IOSElement option : dropdownList) {
      if (option.getText().equalsIgnoreCase(nonEviveCompanyName)) {
        option.click();
      }
    }
    iosDriver.hideKeyboard();
    activationButton.click();
    return titleOfNonEviveClientPage.getText();
  }

  public boolean verifyEmailFieldOnNonEviveClientPage() {
    return emailField.isDisplayed();
  }

  public String verifyEmailFieldPlaceHolderOnNonEviveClientPage() {
    return emailFieldPlaceHolder.getText();
  }

  public boolean verifyCheckboxOnNonEviveClientPage() {
    return checkBox.isDisplayed();
  }

  public String verifypolicyTextOnNonEviveClientPage() {
    return policyText.getText();
  }

  public String verifyInvalidErrorTextOnNonEviveClientPage(String invalidId) {
    emailField.sendKeys(invalidId);
    iosDriver.hideKeyboard();
    return invalidEmailErrorText.getText();
  }

  public boolean verifyContinueButtonDisabledOnNonEviveClientPage() {
    return !AppTestUtil.isIosElementEnabled(continueButton);
  }

  public boolean verifyContinueButtonEnabledOnNonEviveClientPage(String validId) {
    emailField.clear();
    emailField.sendKeys(validId);
    iosDriver.hideKeyboard();
    checkBox.click();
    return AppTestUtil.isIosElementEnabled(continueButton);
  }

  public boolean verifyCaptchaPagePresence() {
    continueButton.click();
    WaitUtil.explicitWaitForVisibilityOfAppElement(iosDriver, captchaCheckbox, 5);
    return captchaCheckbox.isDisplayed();
  }

  public boolean verifyContinueButtonPresenceOnCaptchaPage() {
    return continueButton.isDisplayed();
  }

  public boolean verifyCaptchaChallengePresenceOnCaptchaPage() {
    captchaCheckbox.click();
    WaitUtil.explicitWaitForVisibilityOfAppElement(iosDriver, captchaChallenge, 2);
    return captchaChallenge.isDisplayed();
  }

  public boolean iosActivation(String activationToken, String companyName, String fullCompanyName) {
    backButton.click();
    backButton.click();
    editActivationToken.clear();
    if (!companyName.isEmpty() && !fullCompanyName.isEmpty()) {
      if (5 > companyName.length()) {
        editActivationToken.sendKeys(companyName);
        iosDriver.hideKeyboard();
        //iosDriver.findElementByAccessibilityId(fullCompanyName).click();
        for (IOSElement option : dropdownList) {
          if (option.getText().equalsIgnoreCase(fullCompanyName)) {
            option.click();
          }
        }
        activationButton.click();
      } else {
        editActivationToken.sendKeys(fullCompanyName);
        iosDriver.hideKeyboard();
        activationButton.click();
      }
    } else {
      activationLink.click();
      editActivationToken.sendKeys(activationToken);
      iosDriver.hideKeyboard();
      activationButton.click();
    }

    //To-Do - This case will handle if cobranding page will come for any client
   */
/* if (cobrandingTitle.isDisplayed()){
      continueButton.click();
    }*//*

    return onboardingTopText.isDisplayed();
  }

  public IOSDriver<IOSElement> goToIosOnboardingPage(String activationToken) {
    allowButton.click();
    log.info("Successfully click on allow button");
    activationLink.click();
    editActivationToken.sendKeys(activationToken);
    log.info("Successfully entered the activation token");
    iosDriver.hideKeyboard();
    log.info("Successfully landed on onboarding page.");
    activationButton.click();
    return iosDriver;
  }

}
*/
