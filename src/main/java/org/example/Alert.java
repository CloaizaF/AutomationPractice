package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Alert {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String nameText = "Daniel";
        driver.findElement(By.id("name")).sendKeys(nameText);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        String expectedText = String.format("Hello %s, share this practice page and share your knowledge", nameText);
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedText);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys(nameText);
        driver.findElement(By.id("confirmbtn")).click();
        String expectedText1 = String.format("Hello %s, Are you sure you want to confirm?", nameText);
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedText1);
        driver.switchTo().alert().dismiss();
        driver.close();
    }

}
