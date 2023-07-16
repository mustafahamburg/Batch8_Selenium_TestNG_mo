package com.eurotech.tests.day_11_listOfElements_dropDowns;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_DropDownWithoutSelectTag {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void dropDownWithoutSelectTag() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/select-menu
         * locate and click Select Value dropdown
         * select (click) "Group 1, option 2" from Select Value dropdown
         * locate the new "Group 1, option 2" web element (stale element daha sonra anlatılacak)
         * verify that the element text is "Group 1, option 2"
         */
        driver.get("https://demoqa.com/select-menu");
        WebElement dropDownMenu = driver.findElement(By.xpath("//div[text()='Select Option']"));
        dropDownMenu.click();
        Thread.sleep(2000);
        WebElement group1Option2 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        group1Option2.click();
        Thread.sleep(2000);
        WebElement group1Option2_1 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        String actualText = group1Option2_1.getText();
        String expectedText="Group 1, option 2";
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void dropDownWithoutSelectTag_Task(){

        /**
         * navigate to https://demoqa.com/select-menu
         * click Select One dropdown
         * click on 'Mrs.'
         * locate new 'Mrs.' webElement
         * get the selected option text verify that the text is "Mrs."
         *
         * NOT:right click/inspect/eventlisteners/blur  burada bulunan bütün seçenekler silinir.
         */




    }


    @Test
    public void dropDownWithoutSelectTag_Task2(){

        /**
         * navigate to https://demo.aspnetawesome.com/
         * locate and click DropdownList (Mango ile başlayan liste)
         * get all option names and print them
         * click potato by index (6)
         * relocate dropdown menu (çünkü listenin yapısı değişti)
         * click banana with its own locator (banana'yı locate edip tıklayalım.)
         */





    }

}
