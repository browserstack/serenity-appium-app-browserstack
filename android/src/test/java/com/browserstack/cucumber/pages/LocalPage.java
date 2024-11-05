package com.browserstack.cucumber.pages;

import static org.junit.Assert.assertTrue;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.time.Duration;

@DefaultUrl("http://bs-local.com:45454/")
public class LocalPage extends PageObject {
    WebElement testActionElement;
    WebElement textMessageElement = null;
    List<WebElement> textMessages;
    WebDriverWait webDriverWait = null;
    AndroidDriver driver;

    public void createDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        driver = new AndroidDriver(options);
    }

    public WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        return webDriverWait;
    }

    public void selectTestAction() {
        testActionElement = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("com.example.android.basicnetworking:id/test_action")));
        testActionElement.click();
    }

    public void getTextMessages() {
        textMessages = driver.findElements(AppiumBy.className("android.widget.TextView"));
    }

    public void filterMessage(String textMessage) {
        for(WebElement textElement : textMessages) {
            if(textElement.getText().contains(textMessage)) {
                textMessageElement = textElement;
                String textString = textMessageElement.getText();
                System.out.println(textString);
            }
        }
    }

    public void matchTextMessage(String message) {
        if(textMessageElement == null) {
            throw new Error("Cannot find the needed TextView element from app");
        }
        String textString = textMessageElement.getText();
        assertTrue(textString.contains(message));
    }
}
