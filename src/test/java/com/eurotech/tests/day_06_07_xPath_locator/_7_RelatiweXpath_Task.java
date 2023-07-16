package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _7_RelatiweXpath_Task {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser
         * navigate to https://demowebshop.tricentis.com/
         * locate "Simple Computer Add to Cart Button" with the name of product
         * then click to the button
         * close driver
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(4000);
        WebElement AddToCartBtn = driver.findElement(By.xpath("//a[text()='Simple Computer']/ancestor::*[@class='details']//input"));
        AddToCartBtn.click();
        Thread.sleep(4000);
        driver.close();



    }
}
