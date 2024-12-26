package com.revature;

import com.revature.pom.PlanetariumLogin;
import com.revature.pom.PlanetariumHome;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.steps",
        plugin = {"pretty","html:src/test/resources/reports/html-report.html"}
)
public class TestRunner {

    public static WebDriver driver = null;
    public static PlanetariumLogin planetariumLogin;
    public static PlanetariumHome planetariumHome;
    public static WebDriverWait webDriverWait;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1));
        planetariumLogin = new PlanetariumLogin(driver);
        planetariumHome = new PlanetariumHome(driver);
        Setup.resetTestDatabase();
    }

    @AfterClass
    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
