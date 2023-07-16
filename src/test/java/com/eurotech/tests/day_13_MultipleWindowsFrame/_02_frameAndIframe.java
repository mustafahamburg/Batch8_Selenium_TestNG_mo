package com.eurotech.tests.day_13_MultipleWindowsFrame;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_frameAndIframe {
    // Frame yapisi ic ice konumlandirilmis web sayfalarinin tanimlanmasi icin kull.
    // Burada Frame : bir web sayfdasinda icice olmayacask seilde kunumlandirilmis durumu,
    // Iframe ise ic ice kunulmus web sayfalarinin tanimlanmasinda kull.
    // Frame yapiosi inspect yapildiktan sonra iframe ile tekrardan html kod baslangicindan  da anlasilir
    // Frame yapisina 3 farkli sekilde erisilebilir
          //1.Attributedegeri ile --> driver.switchto.frame(frm1)
          //2.Index degerine gore --> driver.switchto.frame(0) INDEX --> 0 dan baslar!!!
         // 3.Frame methoduna gore ,yani bir web element tanimlamasi ile gecis yapilabilir
         //-->Method=driver.switchto.frame(driver.findElement(By Id("")))

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit(); //close to browser
    }

    @Test
    public void testframe1() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(3000);
        driver.switchTo().frame("frame1"); // Verify with atribute value
        String tex=driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(tex,"This is a sample page");
    }
    @Test
    public void testframe2() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(3000);
        driver.switchTo().frame(1); // Verify with atribute value
        String tex=driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(tex,"This is a sample page");

         // FRAME YAPISI:
         // driver.switchTo().frame() ;//-->int degeri ,attribute degeri ve finBy degeri ile giriilir
          driver.switchTo().parentFrame();//--> Frame lerden yukari dogru  cikis icin kull.
                                          // her bir parent bir adim yukari dogru cikar
        driver.switchTo().frame(2);
        driver.switchTo().parentFrame();//driver.switchTo().parentFrame(1);
        driver.switchTo().parentFrame();//driver.switchTo().parentFrame(0);

          driver.switchTo().defaultContent(); // direkt default olan sayfaya gelir
        //  boyut olarak neredeyseniz ,direkt ana sayfaya gelir

    }


}

