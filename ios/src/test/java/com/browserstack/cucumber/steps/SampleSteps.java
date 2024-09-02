package com.browserstack.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import com.browserstack.cucumber.pages.SamplePage;
import java.util.List;
import org.openqa.selenium.WebElement;

public class SampleSteps {
    SamplePage samplePage;

    @Given("^I am on homepage")
    public void I_am_on_homepage() throws Throwable {
        samplePage.createDriver();
    }

    @When("^I click on Text Button")
    public void I_click_on_text_button() throws Throwable {
        samplePage.clickTextButton();
    }

    @Then("^I enter text - Hello")
    public void I_enter_text_hello() throws Throwable {
        samplePage.insertText("Hello");
        Thread.sleep(5000);
    }

    @Then("I should get Hello in the output")
    public void I_should_get_hello_in_the_output() {
        String textOutput = samplePage.getTextOutput();
        assertEquals(textOutput, "Hello");
    }
}
