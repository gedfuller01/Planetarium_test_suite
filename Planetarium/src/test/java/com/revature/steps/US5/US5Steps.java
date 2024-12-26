package com.revature.steps.US5;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US5Steps {
    @When("the user gives data {string} for the planet they wish to delete")
    public void the_user_gives_data_for_the_planet_they_wish_to_delete(String planet) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumHome.deletePlanet(planet);

    }

    @When("the planet exists")
    public void the_planet_exists() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the table should refresh with the planet deleted")
    public void the_table_should_refresh_with_the_planet_deleted() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.navigate().refresh();
        TestRunner.webDriverWait.until(ExpectedConditions.visibilityOf(TestRunner.driver.findElement(By.xpath("//*[@id=\"celestialTable\"]/tbody/tr[5]/td[5]/img"))));
    }

    @Then("all moons related to the planet should be deleted as well")
    public void all_moons_related_to_the_planet_should_be_deleted_as_well() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(5, TestRunner.planetariumHome.getNumberOfCelestialRows());

    }

    @When("the planet doesn't exist")
    public void the_planet_doesn_t_exist() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the user should get an alert saying Invalid planet name")
    public void the_user_should_get_an_alert_saying_Invalid_planet_name() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Invalid planet name", TestRunner.planetariumHome.getAlert());
        TestRunner.planetariumLogin.clearAlert();

    }

    @When("the user gives data {string} for the moon they wish to delete")
    public void the_user_gives_data_for_the_moon_they_wish_to_delete(String moon) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.planetariumHome.deleteMoon(moon);

    }

    @When("the moon exists")
    public void the_moon_exists() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the table should refresh with the moon deleted")
    public void the_table_should_refresh_with_the_moon_deleted() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.navigate().refresh();
        TestRunner.webDriverWait.until(ExpectedConditions.visibilityOf(TestRunner.driver.findElement(By.xpath("//*[@id=\"celestialTable\"]/tbody/tr[5]/td[5]/img"))));
        Assert.assertEquals(4, TestRunner.planetariumHome.getNumberOfCelestialRows());
    }

    @When("the moon doesn't exist")
    public void the_moon_doesn_t_exist() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the user should get an alert saying Invalid moon name")
    public void the_user_should_get_an_alert_saying_Invalid_moon_name() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Invalid moon name", TestRunner.planetariumHome.getAlert());
        TestRunner.planetariumLogin.clearAlert();

    }
}
