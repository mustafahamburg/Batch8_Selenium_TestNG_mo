package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _6_LoginTest_2 extends TestBase {
    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with url
     * "https://www.krafttechexlab.com/index"
     */

    @Test
    public void loginTest_1() {
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/index";

        Assert.assertEquals(actualUrl,expectedUrl);

    }
    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with page title
     * "Dashboard - Kraft Techex Lab - aFm"
     */
    @Test
    public void loginTest_2() {
        WebElement emailBox=driver.findElement(By.cssSelector("[name='email']"));
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

        String actualTitle= driver.getTitle();
        String expectedTitle="Dashboard - Kraft Techex Lab - aFm";
        Assert.assertEquals(actualTitle,expectedTitle,"verify that titles are same");

    }
    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with user Name
     */

    @Test
    public void loginTest_3() {
        WebElement emailBox=driver.findElement(By.cssSelector("[name='email']"));
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

        WebElement userName = driver.findElement(By.tagName("h2"));
        String actualUserName=userName.getText();
        String expectedUserName="mustafa";
        Assert.assertEquals(actualUserName,expectedUserName);
    }
}
