package com.browserstack.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import com.browserstack.cucumber.pages.SamplePage;
import java.util.List;
import org.openqa.selenium.WebElement;

public class SampleSteps {
    SamplePage samplePage;

    @Given("^I am on homepage")
    public void I_am_on_homepage() throws Throwable {
        samplePage.createDriver();
    }

    @When("^I click on Search Wikipedia")
    public void I_click_on_search_wikipedia() throws Throwable {
        samplePage.selectSearchElement("Search Wikipedia");
    }

    @Then("^I search with keyword BrowserStack")
    public void I_search_with_browserstack() throws Throwable {
        samplePage.insertText("BrowserStack");
        Thread.sleep(2000);
    }

    @Then("the search results should be listed")
    public void the_search_results_should_be_listed() {
        List<WebElement> searchResults = samplePage.getSearchResults();
        assertTrue(searchResults.size() > 0);
    }
}
