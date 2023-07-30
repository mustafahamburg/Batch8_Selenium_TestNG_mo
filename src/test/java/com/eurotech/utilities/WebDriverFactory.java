package com.eurotech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {
    /**
     *
         * set up a chrome driver with WebDriverFactory
         * navigate to https://tr-tr.facebook.com/
         * verify that the url is correct
         */
/**
 * write a static method
 * that is named getDriver
 * it takes a string parameter (browserType)
 * it will set up browser
 * it will return a driver based on parameter (chrome, firefox, safari, edge etc..)
 */
   public static WebDriver getDriver(String browserType){
       WebDriver driver=null;
       switch (browserType.toLowerCase()){
           case "chrome":
               WebDriverManager.chromedriver().setup();
               driver=new ChromeDriver();
               break;
           case "edge":
               WebDriverManager.edgedriver().setup();
               driver=new EdgeDriver();
               break;
       }
       return driver;
   }

}
 /*
    Burada yapilan gelistirmelerin duzenli olmasi ve dizayn olarak rahat anlasilmasinin
    yaninda, kolayca yonetilmesi icin boyle bir yapiya ihtiyac duyulmustur.

    POM(Page Object Model)-->Kesinlikle pom.xml ile KARISTIRILMAMALI
    POM--> Framework duzenini ifade eder. Utilities ve diger sayfalarin duzeni.


    pom.xml--> Project Object Model olarak ifade edilir.
    Dependency leri icerisine alan MVN Repository ile calisan model dir.

    POM duzeni olarak calisacaksiniz. Detaylandiracagiz.


    Default olarak Test ve Main branchlari ayrilmis sekilde proje create ediliyor.


    Bizler, TEST Package altinda calisiriz.


    Utilities Package ve ilerde bazi utility Class lar neden kullanilma ihtiyaci vardir??
     -Clean kod ahlaki icin (SOLID credantials, clean patttern).
     -Daha verimli ve kullanisli olmasi icin. Ram daha az yorar.




     */
