package com.eurotech.tests.day_12_alertAndMultipleWindowRewiew;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_HTML_Popups {
    WebDriver driver; // Global veriable

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
        Thread.sleep(5000);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testhtmlPopup() throws InterruptedException {
        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html
         * click show alert box
         * verify that ok button can be seen on the popup
         * take the text on popup and print it (I am a fake alert box!)
         * then click on ok at the popup
         * verify that ok button cannot be seen
         */

        WebElement fakeAlert= driver.findElement(By.cssSelector("#fakealert"));
        fakeAlert.click();
        Thread.sleep(2000);

        WebElement okBtn= driver.findElement(By.id("dialog-ok"));
        Assert.assertTrue(okBtn.isDisplayed());

        System.out.println(driver.findElement(By.id("dialog-text")).getText());
        okBtn.click();
        Thread.sleep(2000);
        Assert.assertFalse(okBtn.isDisplayed());
    }

    @Test
    public void testhtmlPopup_Task() {
        /**
         * go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
         * click on confirm button
         * click on yes at the popup window
         * make verification with confirmed popup
         */

    }
}
