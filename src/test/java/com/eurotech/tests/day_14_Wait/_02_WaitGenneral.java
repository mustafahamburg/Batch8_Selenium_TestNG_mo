package com.eurotech.tests.day_14_Wait;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_WaitGenneral {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testwait() {
        // Wait bir senkronizasyon olarak da ifade edilebilir
        //DOM--> html kodlarinin Document Object Model olarak ifade edileir
        // Wait de bu DOM un senkron bir sekilde calismasini saglar
        // Wait Slenium kutuphanesine aittir.Senkronizasyon saglamak icin kullanilir

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox=driver.findElement(By.id("checkbox"));
        checkBox.click();
        // Check box in etkin olmadigini dogrulayin
        Assert.assertTrue(checkBox.isEnabled()); // etkinse demek

        WebElement texBox=driver.findElement(By.id("message"));
        Assert.assertFalse(texBox.isEnabled());





    }
}
