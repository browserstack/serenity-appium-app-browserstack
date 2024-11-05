package com.browserstack.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.browserstack.cucumber.pages.LocalPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalSteps {
    LocalPage localPage;

    @Given("^I am on the homepage")
    public void I_am_on_the_homepage() throws Throwable {
        localPage.createDriver();
    }
    @When("^I click on test button")
    public void I_click_on_test_button() throws Throwable {
        localPage.clickTestbutton();
    }
    @Then("^I should get a message about active connection")
    public void I_should_get_a_message_about_active_connection() throws Throwable {
        localPage.selectResultElement();
        String message = localPage.getResultMessage();

        System.out.println(message);
        if(message.contains("not working")) {
            throw new Error("Unexpected BrowserStackLocal test result");
        }

        String expectedString = "Up and running";
        assertTrue(message.contains(expectedString.toLowerCase()));
    }
}
