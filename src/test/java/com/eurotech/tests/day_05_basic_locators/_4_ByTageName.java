package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_ByTageName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Copyright web element at the footer of the web page by using tag name locator
         * get the text of web element and print it
         * close driver.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(2000);
        // by tag name ile locate
        WebElement copyRightElement = driver.findElement(By.tagName("small"));
        // textini alip yazdiralim
        String copyRightElementText = copyRightElement.getText();
        System.out.println("copyRightElementText = " + copyRightElementText);
        Thread.sleep(2000);
        driver.close();

    }
}
/*
    Tag name ler:
    1-dinamik olmazlar
    2- birden fazla olma durumu cok siktir,eger bu durumda kullanilirsa selenium ilk web elementine gider
    3-unique  olup olmadigi dev tools da arama  (ctrl+f) bolumunde basina "//"
    isareti konularak kontrol edilir.By.classname("classname") icineyazilirken "//"
    isareti konulmadan kull.
    4-index ile kullanilmaz..
 */
