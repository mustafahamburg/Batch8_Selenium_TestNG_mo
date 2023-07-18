package com.eurotech.tests.day_15_actions_fileUpload_isExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class _1_Actions {
    // mausla yaptigimiz islemleri yapmak icin kull
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testhoverOver() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * hover over "Hover Para" element
         * get the text which is seen after hover action
         * and verify that the text is "You can see this paragraph now that you hovered on the above 'button'."
         * also verify that the text is displayed (use explicit wait)
         * hover over the "Hover Div" and verify that the text is not displayed anymore. (use explicit wait)
         */
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        WebElement hoverPara = driver.findElement(By.id("hoverpara"));

        Actions actions=new Actions(driver);
        actions.moveToElement(hoverPara).perform(); // .perform()  yazmadikca caslismaz

        WebElement hoverEffect = driver.findElement(By.id("hoverparaeffect"));

        String actualText=hoverEffect.getText();
        String expectedText="You can see this paragraph now that you hovered on the above 'button'.";

        Assert.assertEquals(actualText,expectedText);
        Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(hoverEffect)).isDisplayed());

        WebElement hoverDiv = driver.findElement(By.id("hoverdivpara"));
        actions.moveToElement(hoverDiv).perform();

        Assert.assertTrue(new WebDriverWait(driver,12).until(ExpectedConditions.invisibilityOf(hoverEffect)));


    }

    @Test
    public void hover_Task() {

        /**
         * go to https://the-internet.herokuapp.com/hovers
         * locate all users (image on the page) with findElements()
         * hover over all of them and verify that "name:user1-2-3" is displayed
         * if any time issues solve them with implicitly or explicitly waits
         */

    }

    @Test
    public void dragAndDrop() {
        /**
         * go to https://webdriveruniversity.com/Actions/index.html
         * take the "DRAG ME TO MY TARGET!" box and drop it "DROP HERE!" place
         * verify that "Dropped!" text is displayed..(make text correction at the same time)
         */
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));

        //First Way:
        //actions.dragAndDrop(dragElement,dropElement).perform();
        // Second Way:
        actions.moveToElement(dragElement).clickAndHold().moveToElement(dropElement).pause(2000).release().build().perform();

        WebElement dropText = driver.findElement(By.cssSelector("#droppable>p>b"));
        Assert.assertEquals(dropText.getText(),"Dropped!");
        Assert.assertTrue(dropText.isDisplayed());
    }

    @Test
    public void dragAndDrop_Task() {
        /**
         * go to https://demoqa.com/droppable
         * take "Drag me" and drop it "Drop here" section
         * verify that the "Dropped!" message is displayed (make text verification)
         */
    }

    @Test
    public void clickWithaction() {
        /**
         * navigate to https://skill-test.net/mouse-double-click
         * make double click to the Click box
         * make a normal click to the Click Box (not the middle of element)
         * click on Right Click Test link from left menu (use actions)
         * make right click to the Start box and wait three seconds
         * make normal click on Reset box (use actions)
         */
        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.id("clicker"));

        //Actions actions=new Actions(driver); // globalde(ustte) oldugu icin burada bunu yazmadik

        actions.doubleClick(clicker).perform();
        // secont way
        actions.moveToElement(clicker).doubleClick().perform();

        actions.click(clicker).perform(); // normal click
        actions.moveToElement(clicker,5,6).click().perform(); // click in koordinatini(yerini)gostererek klik yapma
        WebElement rightClickLink = driver.findElement(By.xpath("//span[text()='Right Click Test']"));
        actions.click(rightClickLink).perform();

        WebElement startBtn = driver.findElement(By.id("clicker"));
        actions.contextClick(startBtn).perform();// contextClick-> sag click demek
        WebElement resetBtn= driver.findElement(By.id("reset"));
        actions.click(resetBtn).perform();



    }
}
