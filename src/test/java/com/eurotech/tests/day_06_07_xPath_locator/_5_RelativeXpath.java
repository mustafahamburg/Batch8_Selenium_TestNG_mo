package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * class task
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (by xPath with contains (attribute))
         * locate sign up by xPath with contains (text)
         * click Sign Up
         * locate Name input box by xPath (starts with) and send to box "Ahmet"
         * locate email input box by xPath (more than one attribute) and send the box "aaa@aaa.com"
         * locate password input box by xPath (more than one attribute with "and") and type in "123456"
         * locate confirm password input box by xPath (more than one attribute with "or") and type in "123456"
         * locate Sign In link by xPath (with index) --- use only tag
         * click Sign In link
         * close browser.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(@aria-label,'cookies')]")).click();
        Thread.sleep(2000);
        WebElement singUpBtn = driver.findElement(By.xpath("//a[contains(text(),'n Up')]"));
        singUpBtn.click();
        Thread.sleep(2000);
        WebElement nameInputBox = driver.findElement(By.xpath("//input[starts-with(@name,'na')]"));
        nameInputBox.sendKeys("Ahmet");
        Thread.sleep(2000);
        WebElement emailAdresBtn = driver.findElement(By.xpath("//input[@type='email'][@placeholder='Email Address']"));
        emailAdresBtn.sendKeys("aaa@aaa.com");
        Thread.sleep(2000);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password' and @id='signuppage-form-pw1-input']"));
        passwordInput.sendKeys("123456");
        Thread.sleep(2000);
        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@placeholder='Confirm Password' or @id='signuppage-form-pw2-input']"));
        confirmPasswordInput.sendKeys("123456");
        Thread.sleep(2000);
        WebElement singInLink = driver.findElement(By.xpath("(//a)[5]"));
        singInLink.click();
        driver.close();


    }
}
