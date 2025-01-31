package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutosuggestiveDropdown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li[class='ui-menu-item'] a")));
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for ( WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
        driver.close();
    }
}
