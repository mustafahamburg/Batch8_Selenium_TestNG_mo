package com.eurotech.tests.day_15_actions_fileUpload_isExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import java.util.ArrayList;
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
        driver.get("https://the-internet.herokuapp.com/hovers");

        //(//img)[2]
        //(//img)[3]
        //(//img)[4]

        //h5[text()='name: user1']
        //h5[text()='name: user2']
        //h5[text()='name: user3']

        for (int i = 2; i <=4 ; i++) {
            String imgXpath="(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(imgXpath));
            actions.moveToElement(img).perform();

            String userText="//h5[text()='name: user"+(i-1)+"']";
            WebElement user=driver.findElement(By.xpath(userText));
            Assert.assertTrue(new WebDriverWait(driver,10)
                    .until(ExpectedConditions.visibilityOf(user)).isDisplayed());

        }

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
    public void clickWithaction() throws InterruptedException {
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
        Thread.sleep(2000);
        WebElement resetBtn= driver.findElement(By.id("reset"));
        actions.click(resetBtn).perform();

    }

    @Test
    public void testfillingFormWithAction_Task() {
        /**
         * go to http://www.eurotech.study/
         * accept cookies
         * click login
         * send your credentials to related boxes and then click login button
         * click on Add Education link
         * fill form with action class
         * verify the success message after submitted the form
         */

    }

    @Test
    public void rıgtClıckOpennewTab() throws InterruptedException {
        /**
         * go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * make right click and open in new tab  (sag ctrl+click)
         * switch to new opened tab
         * verify that the page title is "EvilTester.com"
         */
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        Thread.sleep(2000);
        WebElement link = driver.findElement(By.linkText("EvilTester.com"));
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(link)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        ArrayList<String>tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualTitle=driver.getTitle();
        String expectedtitle="EvilTester.com";

        Assert.assertEquals(actualTitle,expectedtitle);

    }
}
