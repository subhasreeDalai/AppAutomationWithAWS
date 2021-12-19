package app.automation.util;

import static java.time.Duration.of;
import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;

import com.google.common.base.Function;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

@Slf4j
public class WaitUtil {


    // This method can be used only with plain text
    public static void ExplicitWaitForPresenceOfText(WebDriver driver, int seconds, String expectedTextOnThePage) {
        String currentUrl = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'" + expectedTextOnThePage + "')]")));
        } catch (Exception e) {
            log.error("Expected text - " + expectedTextOnThePage + " is not present on the redirected url - " + currentUrl);
        }
    }


    // Fluent wait using locator mechanism
    public static void fluentWait(WebDriver driver, By locator, int seconds) {
        long startTime = System.currentTimeMillis();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(of(seconds, SECONDS))
                .pollingEvery(of(500, MILLIS))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(new Function<WebDriver, WebElement>() {
            @Nullable
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        long endTime = System.currentTimeMillis();
        String waitingTimeAsString = waitingTime(startTime, endTime);
        log.info("Fluent wait - element : " + locator + " found on Page in - " + waitingTimeAsString + " seconds.");
    }

    // Explicit wait using Visibility Of an element
    public static void explicitWaitForVisibilityOfElement(WebDriver driver, WebElement ele, long seconds) {
        long startTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(ele));
        long endTime = System.currentTimeMillis();
        String waitingTimeAsString = waitingTime(startTime, endTime);
        log.info("Explicit wait - element : " + ele + " found on Page after waiting - " + waitingTimeAsString + " seconds.");
    }

    public static void explicitWaitForVisibilityOfAppElement(MobileDriver driver, MobileElement ele, long seconds) {
        long startTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(ele));
        long endTime = System.currentTimeMillis();
        String waitingTimeAsString = waitingTime(startTime, endTime);
        log.info("Explicit wait - element : " + ele + " found on Page after waiting - " + waitingTimeAsString + " seconds.");
    }


    // Explicit wait using InVisibility Of an element
    public static void explicitWaitForInvisibilityOfElement(WebDriver driver, WebElement ele, long seconds) {
        long startTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOf(ele));
        long endTime = System.currentTimeMillis();
        String waitingTimeAsString = waitingTime(startTime, endTime);
        log.info("Explicit wait - element : " + ele + " not found on app.page after waiting - " + waitingTimeAsString + " seconds.");
    }

    // Explicit wait Generic method
    public static void explicitWaitGeneric(WebDriver driver, ExpectedCondition<WebElement> expectedCondition, long seconds) {
        long startTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(expectedCondition);
        long endTime = System.currentTimeMillis();
        String waitingTimeAsString = waitingTime(startTime, endTime);
        log.info("Explicit wait - element : " + expectedCondition + " not found on app.page after waiting - " + waitingTimeAsString + " seconds.");
    }

    // Calculate wait time
    public static String waitingTime(double startTime, double endTime) {
        double waitingTime;
        waitingTime = (endTime - startTime) / 1000.0;
        return String.format("%.3f", waitingTime);
    }


    // Thread.sleep()
    public static void waitForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
            log.info("Ended Implicitly Wait. Total time - " + seconds);
        } catch (Exception e) {
            log.info("Error in wait for seconds - " + e.getMessage());
        }
    }


    // Implicit Wait
    public static void implicitWaitTimeOut(WebDriver driver, int seconds) {
        long startTime = System.currentTimeMillis();
        try {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
            long endTime = System.currentTimeMillis();
            String waitingTimeAsString = waitingTime(startTime, endTime);
            log.info("Fluent wait applied for - " + waitingTimeAsString + " seconds.");
        } catch (Exception e) {
            log.error("Waited for - " + seconds + " seconds to search an element. Exception seen - " + e);
        }
    }

    // Wait till app.page get loaded completely
    public void waitForCompletePageLoad(WebDriver driver) {
        long pageLoadTimeout = 40;
        log.info("Started waiting for complete app.page load.");
        long startTime = System.currentTimeMillis();

        new WebDriverWait(driver, pageLoadTimeout).until(
                webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState")));
        long endTime = System.currentTimeMillis();
        long waitingTime = endTime - startTime;
        log.info("Ended waiting for complete app.page load. Total time : {}", waitingTime);
    }

}


// Fluent wait using Element
/*    public static void fluentWait(WebDriver driver, WebElement element, int seconds) {
        long startTime = System.currentTimeMillis();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(of(seconds, SECONDS))
                .pollingEvery(of(500, MILLIS))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class);

            wait.until(new Function<WebDriver, WebElement>() {
                @Nullable
                @Override
                public WebElement apply(WebDriver driver) {
                    return element;
                }
            });
            long endTime = System.currentTimeMillis();
            String waitingTimeAsString = waitingTime(startTime, endTime);
            log.info("Fluent wait - element : " + element + " found on Page in - " + waitingTimeAsString + " seconds.");

    }*/

