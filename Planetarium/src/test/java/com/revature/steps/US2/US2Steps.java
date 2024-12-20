package com.revature.steps.US2;

import com.revature.TestRunner;
import com.revature.pom.PlanetariumLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US2Steps {

    @Then("the user should login successfully")
    public void the_user_should_login_successfully() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.logIn();
    }

    @Then("be brought to the home page")
    public void be_brought_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        if (!TestRunner.planetariumLogin.getTitle().equals("Home")){
            throw new RuntimeException("Did not login page: " + TestRunner.planetariumLogin.getTitle());
        }
    }

    @Then("the user should get an invalid credentials alert")
    public void the_user_should_get_an_invalid_credentials_alert() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("should remain on the login page")
    public void should_remain_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

    }
}
