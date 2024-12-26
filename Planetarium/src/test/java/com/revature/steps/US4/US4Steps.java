package com.revature.steps.US4;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US4Steps {
    @When("the user gives data for a {string}")
    public void the_user_gives_data_for_a(String planet) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumHome.addNewPlanet(planet);

    }

    @When("the user gives data for a {string} and a {string}")
    public void the_user_gives_data_for_a(String moon, String planet) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumHome.addNewMoon(moon, planet);


    }

    @Then("the table should refresh")
    public void the_table_should_refresh() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.navigate().refresh();
        TestRunner.webDriverWait.until(ExpectedConditions.visibilityOf(TestRunner.driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[5]/td[5]/img"))));

    }

    @Then("a new planet should be visible on their home page")
    public void a_new_planet_should_be_visible_on_their_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(5, TestRunner.planetariumHome.getNumberOfCelestialRows());
    }

    @Then("a new moon should be visible on their home page")
    public void a_new_moon_should_be_visible_on_their_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(6, TestRunner.planetariumHome.getNumberOfCelestialRows());

    }

    @Then("the user should get an alert saying {string}")
    public void the_user_should_get_an_alert_saying(String alert) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(alert, TestRunner.planetariumHome.getAlert());
        TestRunner.planetariumLogin.clearAlert();

    }

    @When("the user provides an {string}")
    public void the_user_provides_an(String image) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumHome.uploadImage(image);

    }

    @And("the data is invalid")
    public void the_data_is_invalid() {
        TestRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("a new planet with an image should be visible on their home page")
    public void a_new_planet_with_an_image_should_be_visible_on_their_home_page(){
        Assert.assertEquals(7, TestRunner.planetariumHome.getNumberOfCelestialRows());
    }
}
