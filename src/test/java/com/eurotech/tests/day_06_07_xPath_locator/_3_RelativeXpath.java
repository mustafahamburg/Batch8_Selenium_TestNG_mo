package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath)
         * locate login button (use xPath)
         * click login button
         * locate email address input box (use xPath)
         * send "abc@abc.com" into email address input box
         * locate second login button (use xPath)
         * click Login button
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'understand')]")).click();
        Thread.sleep(2000);
        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginBtn.click();
        Thread.sleep(2000);
        WebElement emailInputBox = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-input-email')]"));
        emailInputBox.sendKeys("abc@abc.com");
        WebElement secondLoginBtn = driver.findElement(By.xpath("//*[@id='loginpage-form-btn']"));
        secondLoginBtn.click();
        Thread.sleep(2000);
        driver.close();

    }
}
