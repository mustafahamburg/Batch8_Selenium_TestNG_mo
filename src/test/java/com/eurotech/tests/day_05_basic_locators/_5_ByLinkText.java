package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Developers link web element by using link text locator
         * get the text of web element and print it
         * click to the web element
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(2000);
        // web elementi link text kullanarak
        WebElement developersLink = driver.findElement(By.linkText("Developers"));
        String developersLinkText = developersLink.getText();
        System.out.println("developersLinkText = " + developersLinkText);
        Thread.sleep(2000);
        developersLink.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
