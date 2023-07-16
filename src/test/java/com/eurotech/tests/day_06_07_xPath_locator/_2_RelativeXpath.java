package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any (use xPath formula with known attribute value)
         * locate search bar with xPath formula with known attribute value
         * send "Selenium" word to the serach bar
         * locate seacrh button with xPath formula with known attribute value
         * click search button
         * Get the search result by the formula of the text feature of Xpath (two ways)
         * get the text of web element and print it.
         * close driver.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(4000);

        WebElement cookies = driver.findElement(By.xpath("//input[@name='accept']"));
        cookies.click();
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Selenium");
        Thread.sleep(2000);

        WebElement searchBtn = driver.findElement(By.xpath("//input[@value=\"Git\"]"));
        searchBtn.click();
        Thread.sleep(4000);

        WebElement resultText1 = driver.findElement(By.xpath("//span[.='\"selenium\"']"));// buradaki nokta kisayol .=text()
        System.out.println("resultText1 = " + resultText1.getText());
        Thread.sleep(2000);

        driver.close();



    }
}
