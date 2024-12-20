package com.revature.steps.US1;

import com.revature.TestMain;
import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US1Steps {



    @Given("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.goToRegister();
        if(!TestRunner.planetariumLogin.getTitle().equals("Account Creation")){
            throw new RuntimeException("Not on account creation page on: " + TestRunner.planetariumLogin.getTitle());
        }

    }

    @When("the user provides username {string}")
    public void the_user_provides_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.setUsername(username);

    }

    @When("the user provides password {string}")
    public void the_user_provides_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.setPassword(password);
    }

    @When("the user submits the credentials")
    public void the_user_submits_the_credentials() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.register();
        TestRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("the user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String alert) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(TestRunner.planetariumLogin.getAlert(), alert);

    }

    @Then("the user should get a browser alert saying Account created successfully")
    public void the_user_should_get_browser_alert_saying_account_created_successfully(){
        Assert.assertEquals(TestRunner.planetariumLogin.getAlert(), "Account created successfully");
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

        TestRunner.planetariumLogin.clearAlert();

    }

    @Then("the user should stay on the registration page")
    public void the_user_should_stay_on_the_registration_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.clearAlert();

    }

}
