package common;


import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helper {
    private static final int ELEMENT_WAIT_TIMEOUT_IN_SECONDS = 10;
    private static final int PAGE_WAIT_TIMEOUT_IN_SECONDS = 60;


    protected WebDriver driver;

    public Helper(final WebDriver driver) {
        this.driver = driver;
    }


    public void waitForFrame(final WebElement element, final int timeoutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /**
     * Wait for {@link WebElement} is present. 5 seconds, tops.
     *
     * @param element - {@link WebElement}.
     */
    protected void waitForElement(final WebElement element) {
        this.waitForElement(element, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
    }

    /**
     * Wait for {@link WebElement} is present.
     *
     * @param element - {@link WebElement}.
     * @param timeoutInSeconds - How long the {@link WebDriver} wait for element.
     */
    public void waitForElement(final WebElement element, final int timeoutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageLoad() {
        waitForPageLoad();
    }

    public void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            // Nothing happens.
        }

    }
}
