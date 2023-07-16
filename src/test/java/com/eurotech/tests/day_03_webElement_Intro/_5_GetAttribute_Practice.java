package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_GetAttribute_Practice {
    public static void main(String[] args) throws InterruptedException {
/**
 * Task
 * 1-open chrome browser
 * 2-go to http://www.eurotech.study/
 * 3-click I understand button and accept cookies
 * 4-take the value of the attributes (class and href) of the
   login button and print the values.
 * 5-click login button
 * 6-send "sdfsdsd" into email address input box
 * 7-click Login button
 * get the message which appears on the email input box
 * VERIFY that the message contains "Please include an '@' in
   the email address."
 */

        WebDriver driver= WebDriverFactory.getDriver("chrome"); // 1
        driver.manage().window().maximize();

        driver.navigate().to("http://www.eurotech.study/");// 2
        Thread.sleep(2000);
        driver.findElement(By.id("rcc-confirm-button")); // 3

        WebElement firstLoginBtn = driver.findElement(By.xpath("//a[@class='btn btn-light']")); // 4
        System.out.println("firstLoginBtn.getAttribute(\"class\") = " + firstLoginBtn.getAttribute("class"));
        System.out.println("firstLoginBtn.getAttribute(\"href\") = " + firstLoginBtn.getAttribute("href"));
        firstLoginBtn.click(); // 5
        Thread.sleep(2000);
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));

        emailInputBox.sendKeys("sdfsdsd"); // 6
        WebElement secondLoginBtn = driver.findElement(By.id("loginpage-form-btn"));

        secondLoginBtn.click(); // 7
        Thread.sleep(2000);
        // uygun email girmediniz mesaji alma
        String actualMesage = emailInputBox.getAttribute("validationMessage");
        String expectedMessage="Please include an '@' the email address. ";
        if(actualMesage.equals(expectedMessage)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
        Thread.sleep(2000);
       driver.close();


    }
}

