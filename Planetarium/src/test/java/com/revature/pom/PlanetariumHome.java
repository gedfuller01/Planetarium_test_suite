package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class PlanetariumHome {
    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;






    public PlanetariumHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.getTitle();
    }

    public String getAlert(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void goToHomepageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public String getGreetings(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return tableRows.size()-1;
    }

    public void logout(){
        logoutButton.click();
    }

    public void addNewPlanet(String planet){
        WebElement dropDown = driver.findElement(By.id("locationSelect"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        driver.findElement(By.id("planetNameInput")).sendKeys(planet);
        driver.findElement(By.className("submit-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void addNewMoon(String moon, String planet){
        WebElement dropDown = driver.findElement(By.id("locationSelect"));
        Select select = new Select(dropDown);
        select.selectByIndex(0);
        driver.findElement(By.id("moonNameInput")).sendKeys(moon);
        driver.findElement(By.id("orbitedPlanetInput")).sendKeys(planet);
        driver.findElement(By.className("submit-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void deletePlanet(String planet){
        WebElement dropDown = driver.findElement(By.id("locationSelect"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        driver.findElement(By.id("deleteInput")).sendKeys(planet);
        driver.findElement((By.id("deleteButton"))).click();
    }

    public void deleteMoon(String moon){
        WebElement dropDown = driver.findElement(By.id("locationSelect"));
        Select select = new Select(dropDown);
        select.selectByIndex(0);
        driver.findElement(By.id("deleteInput")).sendKeys(moon);
        driver.findElement((By.id("deleteButton"))).click();
    }

    public void uploadImage(String path){
        WebElement dropDown = driver.findElement(By.id("locationSelect"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        WebElement fileInput = driver.findElement(By.id("planetImageInput"));
        fileInput.sendKeys(path);
    }

}
