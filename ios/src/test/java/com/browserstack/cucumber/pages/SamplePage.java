package com.browserstack.cucumber.pages;

import io.cucumber.java.After;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.time.Duration;

@DefaultUrl("https://bstackdemo.com/")
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
