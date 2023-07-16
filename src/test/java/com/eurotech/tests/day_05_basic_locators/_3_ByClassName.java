package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate main paragraph web element by using class name locator
         * get the text of web element and print it
         * close driver.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(2000);
        // class name ile locate...
        WebElement mainParagrafElement = driver.findElement(By.className("lead"));
        String mainParagrafText = mainParagrafElement.getText();
        System.out.println("mainParagrafText = " + mainParagrafText);
        Thread.sleep(2000);
        driver.close();

    }
}
/*
    Class name ler:
    1-dinamik olmazlar
    2-cogunlukla birden fazla web elementin class name attribute degeri ayni olabilir
    3-unique  olup olmadigi dev tools da arama  (ctrl+f) bolumunde basina "."
    isareti konularak kontrol edilir.By.classname("classname") icineyazilirken "."
    isareti konulmadan kull.
    4-class name degeri genellikle space yani bosluk icerir,bu durumda By.classname("classname")
     iile kullanilmazlar.bu durumda cssSelector ile uygun islem yapildiktan sonra kullanilabilir
     (css konusu)

 */
