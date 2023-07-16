package com.eurotech.tests.day_12_Alert;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _02_MultipleWindows {
    WebDriver driver; // Global veriable

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();  //close to tab

    }

    @Test
    public void testMultipleWindows() throws InterruptedException {
        String mainHandle=driver.getWindowHandle(); // Hash KOD u verir her sayfanin uniq hash kodu vardir
                                               //mainHandle = 6CF44F51362CF9B83FCAF65D17533578
        System.out.println("mainHandle = " + mainHandle);

        WebElement newTabButton=driver.findElement(By.id("tabButton"));
        newTabButton.click();
        Thread.sleep(2000);

            // Set methoduna otomatik olarak tum tablarin hash kodunu atiyor
        Set<String> allWindowsHandle=driver.getWindowHandles();// tum sayfalarin hash kodlarini burada topla
           //bir hash kod kumsinin yeni bir sayfaya gecis icin kullanilacak algoritma
           //bir yeni tab acan link tiklanmasi durumunda yeni tab veya saayfaya gecis islemi
        for (String handle : allWindowsHandle) {
            if (!handle.equals(mainHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(3000);
                driver.close();
            }
            System.out.println("Listemizdeki hash kodlar = " + handle);
        }
            //Burada ilk ana sayfamiza hash kodu ile ve switch to ile geri donduk .Sonrasinda after methodu caalisip
           // bu ilk olan main tab kapataacak
        Thread.sleep(2000);
        driver.switchTo().window(mainHandle);
    }
}
