package com.browserstack.cucumber.pages;

import io.cucumber.java.After;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidFindBy;
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
    WebElement searchElement;
    WebElement textElement;
    List<WebElement> searchResults;
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

    public void selectSearchElement(String searchText) {
        searchElement = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(searchText)));
        searchElement.click();
    }

    public void insertText(String text) {
        textElement = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        textElement.sendKeys(text);
    }

    public List<WebElement> getSearchResults() {
        searchResults = driver.findElements(AppiumBy.className("android.widget.TextView"));
        return searchResults;
    }
}
