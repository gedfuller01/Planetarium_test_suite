package com.revature.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PlanetariumLogin {

    private WebDriver driver;



    private String password;
    private String username;

    public PlanetariumLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToPlanetarium(){
        driver.get("http://localhost:8080/");
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void logIn(){
        driver.findElement(By.xpath("/html/body/div[1]/form/input[1]")).sendKeys(username);
        driver.findElement(By.xpath("/html/body/div[1]/form/input[2]")).sendKeys(password);
        submitLogin();
    }

    public String getTitle(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.getTitle();
    }

    public String getAlert(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    private void submitLogin(){
        driver.findElement(By.xpath("/html/body/div[1]/form/input[3]")).click();
    }

    public void goToRegister(){
        driver.findElement(By.xpath("/html/body/div[1]/form/a")).click();
    }

    public void register(){
        driver.findElement(By.xpath("/html/body/div[1]/form/input[1]")).sendKeys(username);
        driver.findElement(By.xpath("/html/body/div[1]/form/input[2]")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[1]/form/input[3]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clearAlert(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
