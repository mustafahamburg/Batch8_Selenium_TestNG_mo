package com.eurotech.tests.day_13_MultipleWindowsFrame;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _01_MultipleWindows {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.close();  //close to tab
        driver.quit(); //close to browser
    }

    @Test
    public void testMultipleNewWindow() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(5000);
        String parentWindow=driver.getWindowHandle();// burada hash kod aldik acilan pancerenin

        WebElement newWindow=driver.findElement(By.id("windowButton"));
        newWindow.click();

        Set<String>handles=driver.getWindowHandles(); // selenium ile gelen bir kuraldir ayni zamanda
        Thread.sleep(2000);

        for (String handle:handles){
            System.out.println("handle = " + handle);
            if (!handle.equals(parentWindow)){
                driver.switchTo().window(handle); // burada yeni windows sayfasina gectik
            }

        }
    }

    @Test
    public void testMultipleTextOrWindowsWhichChoose() throws InterruptedException {
        // ikiden fazla yani coklu tab veya windows acildiginda hangisine nasil gidecegiz;

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        Thread.sleep(4000);
        driver.getWindowHandle();
        driver.findElement(By.id("newTabBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("newWindowsBtn")).click();
        Thread.sleep(2000);

        Set<String>handles=driver.getWindowHandles();

        String expectedTitle="Basic Controls - H Y R Tutorials";

        for (String handle: handles){
            driver.switchTo().window(handle);
            System.out.println("Current Windows Title : " + driver.getTitle());
            if (driver.getTitle().equals(expectedTitle)){
                break;
            }
        }
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle); // QA icin must




    }
}
