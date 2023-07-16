package com.eurotech.tests.day_02_webdriwer_basics;


import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class _4_CallWebDriverFactory {
    public static void main(String[] args) {
        /**
         * set up a chrome driver with WebDriverFactory
         * navigate to https://tr-tr.facebook.com/
         * verify that the url is correct
         */
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("https://tr-tr.facebook.com/");

        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://tr-tr.facebook.com/";

        if(actualURL.equals(expectedURL)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
        driver.quit();

        System.out.println("expectedURL = " + expectedURL);
        System.out.println("actualURL = " + actualURL);



    }
}
