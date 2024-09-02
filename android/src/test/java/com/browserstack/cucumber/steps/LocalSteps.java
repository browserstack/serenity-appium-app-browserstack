package com.browserstack.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.browserstack.cucumber.pages.LocalPage;

public class LocalSteps {
    LocalPage localPage;

    @Given("^I am on the homepage")
    public void I_am_on_the_homepage() throws Throwable {
        localPage.createDriver();
    }
    @When("^I click on test action")
    public void I_click_on_test_action() throws Throwable {
        localPage.selectTestAction();
    }
    @Then("^I should get list of text messages")
    public void I_should_get_list_of_text_messages() throws Throwable {
        localPage.getTextMessages();
        Thread.sleep(1000);
    }
    @Then("^there should be a message about active connection")
    public void there_should_be_a_message_about_active_connection() throws Throwable {
        localPage.filterMessage("The active connection is");
        localPage.matchTextMessage("The active connection is wifi");
        localPage.matchTextMessage("Up and running");
    }
}
