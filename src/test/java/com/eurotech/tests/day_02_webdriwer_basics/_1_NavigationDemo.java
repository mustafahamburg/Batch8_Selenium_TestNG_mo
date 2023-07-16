package com.eurotech.tests.day_02_webdriwer_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _1_NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * set up a firefox(chrome) driver
         * navigate to https://www.facebook.com/
         * then navigate to https://testrelic.com/
         * then navigate back
         * then navigate forward
         * then refresh page
         * then close driver
         */

        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.navigate().to("https://testrelic.com/"); // navigate to another web page
        Thread.sleep(2000);
        driver.navigate().back(); // navigate back
        Thread.sleep(2000);
        driver.navigate().forward(); // navigate forward
        Thread.sleep(2000);
        driver.navigate().refresh(); // refresh page
       
    }
}
