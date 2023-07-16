package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_ByID {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate DevEx web element by using id locator
         * get the text of web element and print it
         * close driver.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        //accept cookies  // lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();
        //locate DevEx web element by using id locator
        WebElement devElement = driver.findElement(By.id("landingpage-innercontainer-h1"));
        String devElementText = devElement.getText();
        System.out.println("devElementText = " + devElementText);
        Thread.sleep(2000);
        driver.close();


    }

}
// 1- ID ler cogunlukla unique(essiz) olur,ancak yine de kontrol etmek gerekir
// 2- Id nin unik olup olmadigi dev tools da arama  (ctrl+f) bolumunde basina #
//    isareti konularak kontrol edilir
// 3- Bie elementin Id si varsa locate isleminde Id si kullanilir,oncelikle Id ye bakilir
// 4- Id ler nadiren de olsa dinamik (degisken) olabilir.. bunu sayfayi refresh yaparak
//    refresh yapildiginda Id degismiyorsa static(sabit) degeri vardir