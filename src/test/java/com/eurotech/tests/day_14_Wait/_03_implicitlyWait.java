package com.eurotech.tests.day_14_Wait;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class _03_implicitlyWait {
    // bir kere yazilan ve genellikle befor method icerisinde yer alan wait methodudur.
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // burada 15 sn icerisinde halloldugunda geri kalan sureyi kullanmadan devam ettirir
        // Selenium 4 ile gelistirilmis hali:
         // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); dir.// parametreli method


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();
    }

    @Test
    public void testimplicitly() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove =driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]"));
        remove.click();
        WebElement texBox= driver.findElement(By.id("message"));
        Assert.assertTrue(texBox.isEnabled());
    }

    @Test
    public void testimplicitly2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove =driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]"));
        remove.click();
        WebElement enableInput=driver.findElement(By.xpath("//input[@type='text']"));
        enableInput.sendKeys("Hello");

        // burada tiklama islemi gerceklesiyor fakat asagida sendkeys olarak belirlenen locator hazir hale gelmemis
        // bu senkronizasyon problemini seleniun Explicity Wait ile cozzum uretmis
        // kisaca ,implicitly wait ile cozulemeyen yerde Explicitly wait gerekli oluyor



    }
}
