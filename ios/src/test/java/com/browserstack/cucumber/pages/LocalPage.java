package com.browserstack.cucumber.pages;

import static org.junit.Assert.assertTrue;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import io.cucumber.java.After;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.time.Duration;

public class LocalPage extends PageObject {
    WebElement testButton;
    WebElement resultElement = null;
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

    public void clickTestbutton() {
        testButton = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("TestBrowserStackLocal")));
        testButton.click();
    }

    public void selectResultElement() {
        getWebDriverWait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                String result = d.findElement(AppiumBy.accessibilityId("ResultBrowserStackLocal")).getAttribute("value");
                return result != null && result.length() > 0;
            }
        });
    }

    public String getResultMessage() {
        resultElement = (WebElement) driver.findElement(AppiumBy.accessibilityId("ResultBrowserStackLocal"));
        return resultElement.getText().toLowerCase();
    }
}
