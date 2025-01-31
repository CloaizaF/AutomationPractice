package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class E2E {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")));
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        if(Objects.requireNonNull(driver.findElement(By.id("Div1")).getDomAttribute("style")).contains("1")){
            Assert.fail();
        }

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        driver.findElement(By.id("divpaxinfo")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
        for ( int i = 1; i < 5; i++ ) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        driver.findElement(By.id("btnclosepaxoption")).click();

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        driver.close();
    }

}
