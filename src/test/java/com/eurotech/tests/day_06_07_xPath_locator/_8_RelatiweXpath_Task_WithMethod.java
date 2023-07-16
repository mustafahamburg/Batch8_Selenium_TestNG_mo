package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_RelatiweXpath_Task_WithMethod {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser
         * navigate to https://demowebshop.tricentis.com/
         * locate "Simple Computer Add to Cart Button" with the name of product
         * ürün adini parametre olarak alan bir method yazin ve
         * then click to the button
         * close driver
         */
         driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(4000);
        String[]productNames={"Simple Computer","$25 Virtual Gift Card","Build your own cheap computer"};
        for (int i = 0; i < productNames.length; i++) {
            addToCart(productNames[i]);
            
        }

        Thread.sleep(4000);
        driver.close();

    }
    public static void addToCart(String productName) throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='"+productName+"'+]/ancestor::*[@class='details']//input")).click();
        Thread.sleep(4000);
        driver.navigate().back();



    }

}
