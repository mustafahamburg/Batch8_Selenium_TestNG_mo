package com.eurotech.tests.day_01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_WindowMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        driver.get("http://www.eurotech.study/");
        //driver.get("www.eurotech.study/"); // calismaz
        //driver.get("http://.eurotech.study/"); // calisir

          // ekrani buyutmek icin
        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        // how to get position of the window
        Point position=driver.manage().window().getPosition();
        System.out.println("position = " + position);

        driver.manage().window().setPosition(new Point(150,250));

        // Window un ebatlarini verir
        Dimension size = driver.manage().window().getSize();// ekranin enini ve boyunu verir
        System.out.println("size = " + size);

        Thread.  sleep(2000);  //  java dan gelir ,kodun execution islemini belli bir sure durdurur,2 saniye

        // window un ebatlarini ayarlar
        driver.manage().window().setSize(new Dimension(120,800));

    }
}
