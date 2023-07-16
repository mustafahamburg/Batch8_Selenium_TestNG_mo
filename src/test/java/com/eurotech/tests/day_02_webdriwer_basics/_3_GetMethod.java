package com.eurotech.tests.day_02_webdriwer_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_GetMethod {
    public static void main(String[] args) {
        /**
         * set up a chrome driver
         * navigate to https://www.hepsiburada.com/
         * get title and get url get page source code
         * verify that title, url and Page source codes  contain "hepsiburada"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.hepsiburada.com/");

        String actualTitle = driver.getTitle(); // sayfanin basligini alir ve string olarak verir

        String actualCurrentUrl = driver.getCurrentUrl();// sayfanin o andaki url ini alir

        String actualPageSource=driver.getPageSource();// sayfanin kaynak kodunu  alir ve string olarak verir

        if (actualTitle.toLowerCase().contains("hepsiburada")&& actualCurrentUrl.toLowerCase().contains("hepsiburada")
        && actualPageSource.toLowerCase().contains("hepsiburada")){
            System.out.println("Pass");
        }else {
            System.out.println("Failled");
        }
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("actualCurrentUrl = " + actualCurrentUrl);
        System.out.println("actualPageSource = " + actualPageSource);
        driver.close();

    }
}
