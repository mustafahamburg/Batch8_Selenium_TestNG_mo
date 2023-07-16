package com.eurotech.tests.day_14_Wait;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class _06_FluentWait {
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
    public void testFluentWait() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.id("display-other-button")).click();

        //FluentWait Syntax
        Wait<WebDriver>wait=new FluentWait<>(driver)// ; yapmadan devam ediyoruz
                .withTimeout(12,TimeUnit.SECONDS) //max bekleme suresi
                .pollingEvery(500,TimeUnit.MICROSECONDS)//kosulu kontrol etme sikligi
                .ignoring(NoSuchElementException.class);//kosulu kontrol ettigi sureboyunca
                                                // bu hatayi gozardi et demektir
        WebElement hiddenBtn=driver.findElement(By.id("hidden"));
        wait.until(ExpectedConditions.visibilityOf(hiddenBtn));
        // Spesific locate etme de kullaanilan wait yontemidir.Burada Explicitly wait ile gelen methodun
        // icerisine mudahele ediliyor gibi dusunulebilir
        /*
          Burada Senkronizasyon adi altinda 3 temel wait ile cozum uretilmektedir
          implicitly wait -->Bir kere tanimlanir ve genellikle ilk asamadaki locate etme islemlerinde
          cozum uretir
          Explicitly wait --> implicitly wait in cozum uretemedigi yerde spesifik olarak cozumler uretip
          zaman kaybini minimize ediyor
          Fluent wait--> implicitly ve Explicitly wait saniyade bir refesh yapip kontrol ediyor,fluent
          ise dahada spesific hale getirip zaman siniri ile birlikte tekrar etme surelerini kisitlayip
          bu tekrarlar sirasinda hangi hatalari goz ardi edecegini belirliyor.
          Daha atik ama daha verimlimi bilmiyoruz.
         */



    }







}
