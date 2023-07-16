package com.eurotech.tests.day_13_MultipleWindowsFrame;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _03_Wait {

    // Wait methodlarini gordukten sonra kesinlikle Thread.sleep KULLANILMAZ!!!
    // TODO:Thread incelemesi yapilabilir,selenium nasil yapiyor
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
    public void testWait() throws InterruptedException {
        driver.get("http://www.eurotech.study/login");

        // Handle etme yontemi
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        // Wait kutuphanesi ,software disinda Hardware yapisina da dikkate alan bir framework dur
        WebDriverWait wait=new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.alertIsPresent());
        // zaman kaybi hic olmayacak sekilde calisma yontemi sagliyor

    }
    // 1-Imlicity Wait
    // 2_Explecitly Wait

}
