package com.eurotech.tests.day_04;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _02_Rewiew {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * register and login (send mail and password)
         * Verify title ()
         * Verify page (Title,url ile test edersiniz)
         * Verify back and forward

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000); //Thread--> Yazilimda bir islem parcasi

        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(2000);
        // Bunu bir web element olarak tanimladik sonra clik ledik
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginButton.click();
        Thread.sleep(2000);

        driver.findElement(By.id("loginpage-input-email")).sendKeys("qwerty4825hh@gmail.com");
        Thread.sleep(2000);

        String password="2357asdf";
        Thread.sleep(2000);
        WebElement passwordLabel = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordLabel.sendKeys(password);
        Thread.sleep(3000);

        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(4000);

        String actualtUrl = driver.getCurrentUrl();
        String expectedUrl="http://www.eurotech.study/dashboard";
        Thread.sleep(3000);

        if(actualtUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
        System.out.println("expectedUrl = " + expectedUrl);
        System.out.println("actualtUrl = " + actualtUrl);
        driver.close();


    }
}
