package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BackgroundSteps {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.planetariumLogin.goToPlanetarium();
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Planetarium Login", TestRunner.planetariumLogin.getTitle());
    }
    @Given("the user is logged in on the home page")
    public void the_user_is_logged_in_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumLogin.clearAlert();
        TestRunner.planetariumLogin.goToPlanetarium();
        Assert.assertEquals("Planetarium Login", TestRunner.planetariumLogin.getTitle());
        TestRunner.planetariumLogin.setUsername("Batman");
        TestRunner.planetariumLogin.setPassword("Iamthenight1939");
        TestRunner.planetariumLogin.logIn();
        TestRunner.webDriverWait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Home", TestRunner.planetariumHome.getTitle());





    }
}
