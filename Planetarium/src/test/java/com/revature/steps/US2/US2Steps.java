package com.revature.steps.US2;

import com.revature.TestRunner;
import com.revature.pom.PlanetariumLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US2Steps {

    @Then("the user should login successfully")
    public void the_user_should_login_successfully() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.logIn();
        TestRunner.webDriverWait.until(ExpectedConditions.titleIs("Home"));
    }

    @Then("be brought to the home page")
    public void be_brought_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Home", TestRunner.planetariumHome.getTitle());
        TestRunner.planetariumHome.logout();
    }

    @And("attempts to login")
    public void attempts_to_login(){
        TestRunner.planetariumLogin.logIn();
        TestRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
    }
    @Then("the user should get an invalid credentials alert")
    public void the_user_should_get_an_invalid_credentials_alert() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Invalid credentials", TestRunner.planetariumHome.getAlert());
        TestRunner.planetariumLogin.clearAlert();

    }

    @Then("should remain on the login page")
    public void should_remain_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Planetarium Login", TestRunner.planetariumLogin.getTitle());

    }
}
