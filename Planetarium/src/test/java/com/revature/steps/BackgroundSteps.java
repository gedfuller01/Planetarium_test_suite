package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;

public class BackgroundSteps {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.planetariumLogin.goToPlanetarium();
        // Write code here that turns the phrase above into concrete actions
        if(!TestRunner.planetariumLogin.getTitle().equals("Planetarium Login")){
            throw new RuntimeException("Not on login page on: " + TestRunner.planetariumLogin.getTitle());
        }
    }
    @Given("the user is logged in on the home page")
    public void the_user_is_logged_in_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions

    }
}
