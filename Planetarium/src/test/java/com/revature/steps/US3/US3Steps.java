package com.revature.steps.US3;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US3Steps {
    @Then("they should see their planets and moons")
    public void they_should_see_their_planets_and_moons() {
        // Write code here that turns the phrase above into concrete actions
        try {
            TestRunner.webDriverWait.until(ExpectedConditions.titleIs("Home"));
            Assert.assertEquals("Welcome to the Home Page Batman", TestRunner.planetariumHome.getGreetings());
            Assert.assertEquals(4, TestRunner.planetariumHome.getNumberOfCelestialRows());
            }
        finally {
            TestRunner.planetariumHome.logout();
        }
    }

    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.goToPlanetarium();

    }

    @When("the user tries to directly access the home page")
    public void the_user_tries_to_directly_access_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumHome.goToHomepageDirectly();

    }

    @Then("the user should be denied access")
    public void the_user_should_be_denied_access() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertNotEquals("Home", TestRunner.driver.getTitle());

    }
}
