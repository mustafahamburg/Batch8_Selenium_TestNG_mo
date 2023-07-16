package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import com.google.gson.internal.bind.JsonTreeWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_ByName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to https://testpages.herokuapp.com/styled/basic-html-form-test.html
         * locate username input box by using name locator
         * send a random name to the box
         * clear the box
         * send another name to the box
         * get the second name which sent to the box and assign it to a string variable
         * print the second name
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        Thread.sleep(2000);
        Faker faker=new Faker();
        // locate by name
        WebElement userNameBox = driver.findElement(By.name("username"));
        //userNameBox.sendKeys("Mark Rufalo");
        //extra bilgi:java faker dan random isim girme
        userNameBox.sendKeys(faker.name().fullName());
        Thread.sleep(2000);
        //clear box
        userNameBox.clear();
        // send another name
        userNameBox.sendKeys("Tracy McGradyy");
        // ikinci gonderilen ismi alalim ve bir stringe atayalim
        String secondName = userNameBox.getAttribute("value");
        System.out.println("secondName = " + secondName);
        Thread.sleep(2000);
        driver.close();



    }
}
/*
   1-name ler id ler gibi dinamik olmazlar..
   2-ancak birden fazla webelementin name attribute degeri ayni olabilir .bu durumda locate islemnde kullanilmalari
   halinde selenium her zaman ilkine gider ve o web element ile islem yapar
 */
