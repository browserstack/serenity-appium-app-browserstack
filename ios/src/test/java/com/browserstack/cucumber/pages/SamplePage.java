package com.browserstack.cucumber.pages;

import net.thucydides.core.pages.PageObject;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SamplePage extends PageObject {
    WebElement textButton;
    WebElement textInput;
    WebElement textOutput;
    WebDriverWait webDriverWait = null;
    IOSDriver driver;

    public void createDriver() {
        XCUITestOptions options = new XCUITestOptions();
        driver = new IOSDriver(options);
    }

    public WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        return webDriverWait;
    }

    public void clickTextButton() {
        textButton = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Text Button")));
        textButton.click();
    }

    public void insertText(String text) {
        textInput = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Text Input")));
        textInput.sendKeys(text+"\n");
    }

    public String getTextOutput() {
        textOutput = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Text Output")));
        return textOutput.getText();
    }
}
