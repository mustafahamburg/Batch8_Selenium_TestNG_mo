package com.eurotech.tests.day_04;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_Rewiew {
    public static void main(String[] args) {
        // 1. yol:Daha efektif ve utillies kullanarak yazim.

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.navigate().to("http://www.eurotech.study/"); // bu
        driver.get("http://www.eurotech.study/");  // veya bu

        // 2. yol:daha uzun yazim,utillities kullanmadan daha cok memory yorarak yazim

        WebDriverManager.chromedriver().setup();
        WebDriver driver1=new ChromeDriver();
        driver1.get("http://www.eurotech.study/");


    }
}
