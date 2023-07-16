package com.eurotech.tests.day_02_webdriwer_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();// tam ekran yapar

        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        //close driwer with close() method
        driver.close(); // close current tab,sadece aktif olani

        WebDriverManager.chromedriver().setup();
        WebDriver driver1=new ChromeDriver();

        driver1.manage().window().maximize();
        driver1.navigate().to("https://www.amazon.com"); // navigate().to() ile get() ikiside bizi
                                                            // istenilen sayfaya goturur

        //kapanmis driver i acmak icin tekrar assing etmek grekir
        driver1.quit(); // close all tab
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.close();

    }
}
