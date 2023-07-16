package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_VerifyUserNameIsCorrect {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that username is "test"
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/login");

        String userName="test"; // bu sekilde yazmak besser

        Thread.sleep(3000);

        WebElement userNameInputBox=driver.findElement(By.id("userName"));
        userNameInputBox.sendKeys(userName);

        Thread.sleep(3000);
        String actualUserName=userNameInputBox.getAttribute("value");

        if(actualUserName.equals(userName)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
        WebElement passwordInputBox=driver.findElement(By.id("password"));
        passwordInputBox.sendKeys("Test.!123");

        WebElement loginBtn=driver.findElement(By.id("login"));
        loginBtn.click();
        Thread.sleep(3000);

        WebElement actualLoggedInUserName=driver.findElement(By.id("userName-value"));
        actualLoggedInUserName.getText();

        if(actualUserName.equals(userName)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        driver.close();

    }
}
