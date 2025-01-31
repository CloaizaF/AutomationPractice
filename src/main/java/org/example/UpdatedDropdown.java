package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UpdatedDropdown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        driver.findElement(By.id("divpaxinfo")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
        for ( int i = 1; i < 5; i++ ) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.close();
    }

}
