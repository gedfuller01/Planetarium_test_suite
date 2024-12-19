package com.revature;

import com.revature.pom.PlanetariumLogin;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.steps",
        plugin = {"pretty","html:src/test/resources/reports/html-report.html"}
)
public class TestRunner {

    public static WebDriver driver = null;
    public static PlanetariumLogin planetariumLogin;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        planetariumLogin = new PlanetariumLogin(driver);
    }

    @AfterClass
    public static void tearDown(){

    }
}
