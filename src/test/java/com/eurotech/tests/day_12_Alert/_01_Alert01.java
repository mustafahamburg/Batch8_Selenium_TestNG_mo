package com.eurotech.tests.day_12_Alert;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_Alert01 {

    WebDriver driver; // Global veriable

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();  //close to tab
        //driver.quit(); //close to browser
    }

    @Test
    public void testAlert() throws InterruptedException {

        WebElement alert1 = driver.findElement(By.id("alertButton"));
        alert1.click();
      //  WebDriverWait wait=new WebDriverWait(driver,2);
       // wait.until(ExpectedConditions.alertIsPresent()); // Alert windows hazir mi?
   /*
       Gerek Alert olsun gerek baska bir sayfa olsun ,mevcut sayfanin disinda bir popHup veya
       windows uzerinde islem yapabilmek icin switch ile yer degistirilmeli
    */
        Thread.sleep(4000);
        driver.switchTo().alert().accept();
        /*
        driver dan switch ile yer degistirdik
        alert uzerinde islem yapma yetkisi aldik
        accept ile alert ile ilgili OK islemi yapmis oluyoruz Alert uzerinde
         */
        Thread.sleep(2000);
    }

    @Test
    public void testTimerAlert() throws InterruptedException {
        WebElement alertTime = driver.findElement(By.id("timerAlertButton"));
        alertTime.click();
        Thread.sleep(8000);
        String actualText=driver.switchTo().alert().getText(); //alert uzerindeki tex alma islemi
        String expectedText="This alert appeared after 5 seconds";

        //Senaryonuza gore sekil alan bir VERIFY etme yontemidir.QA in temel gorevidir
        Assert.assertEquals(expectedText,actualText,"Actual resultis not as expected!!!");
        driver.switchTo().alert().accept();

       // WebElement texBox= driver.findElement(By.xpath("//span[text()='Text Box']"));
        //Assert.assertTrue(texBox.isDisplayed());

    }

    @Test
    public void testAlertDismisAndAccept() throws InterruptedException {
        WebElement alert2= driver.findElement(By.id("confirmButton"));
        alert2.click();
        Thread.sleep(10000);
        driver.switchTo().alert().dismiss(); // Burada alert olarak gelen uyari penceresindeki texti red etme
        Thread.sleep(6000);
        WebElement alertResult= driver.findElement(By.id("confirmResult"));
        // Alert butonu dismis edildikten sonra gelen sonuc mesajinin icerisinde Cansel varmi verify ettik
       // Assert.assertTrue(alertResult.getText().contains("Cansel"));
        Assert.assertFalse(alertResult.getText().contains("Cansel"));

    }

    @Test
    public void testAlertSendKey() throws InterruptedException {
        WebElement alert3=driver.findElement(By.id("promtButton"));
        alert3.click();Thread.sleep(2000);
        /*
        Alert alert4=driver.switchTo().alert(); // Alert icin her seferinde switch to ve alert
                                           // uzantilarini kullanmadan islam yapmamizi saglar

        alert4.sendKeys("ismet");
        String text=alert4.getText();// Please enter your name
        Assert.assertEquals(alert4.getText(),"Please enter your name");
        alert4.accept(); // Kabul
        alert4.dismiss(); // red etme
         */
        driver.switchTo().alert().sendKeys("ismet");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement alertNameTex=driver.findElement(By.id("promptResult"));
        Assert.assertTrue(alertNameTex.getText().contains("ismet"));//pozitif senaryo
        Assert.assertFalse(alertNameTex.getText().contains("123")); // negatif senaryo


    }
}
