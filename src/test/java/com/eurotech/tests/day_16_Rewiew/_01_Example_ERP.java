package com.eurotech.tests.day_16_Rewiew;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_Example_ERP {

    WebDriver driver;
  //  1. Kullanıcı ilk önce haftalık ekrana gelir
   @BeforeMethod  // annotation in testNG
   public void loginTest(){
       driver= WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.get("https://qa.fidexio.com/web/login");
       driver.findElement(By.id("login")).sendKeys("posmanager75@info.com");
       driver.findElement(By.id("password")).sendKeys("posmanager");
       driver.findElement(By.cssSelector(".btn.btn-primary")).click();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.findElement(By.xpath("//a[@data-menu='120']")).click(); // Calander button,tum senaryolarda bir
                                                                                   // etkinlik takvimi belirlenecek


   }

    @Test
    public void firstScenario() {
        // user shold be display wekly calander page--Haftalik takvim gosterimi
        driver.findElement(By.xpath("//a[@data-menu='120']")).click();
        WebElement calanderWeek=driver.findElement(By.xpath("//div[@class='btn-group btn-group-sm']/button[2]"));
        Assert.assertTrue(calanderWeek.getAttribute("class").contains("active"));

    }
    // 2. Kullanıcı Gün-Hafta-Ay gösterimini değiştirebilir
    @Test
    public void secondScenario() {
        // user shold't be display day calander page--Haftalik takvim gosterimi
        driver.findElement(By.xpath("//a[@data-menu='120']")).click(); // Calander button

        WebElement calanderWeek=driver.findElement(By.xpath("//div[@class='btn-group btn-group-sm']/button[1]"));
        Assert.assertFalse(calanderWeek.getAttribute("class").contains("active"));

    }
    @Test
    public void thirdScenario() {
        // user shold't be display day calander page--aylik takvim gosterimi
        driver.findElement(By.xpath("//a[@data-menu='120']")).click(); // Calander button

        WebElement calanderWeek=driver.findElement(By.xpath("//div[@class='btn-group btn-group-sm']/button[3]"));
        Assert.assertFalse(calanderWeek.getAttribute("class").contains("active"));

    }
    // 3. Kullanıcı, zaman kutusuna tıklayarak etkinlik oluşturabilir

    @Test
    public void fourthScenario() {//scenario:user can create event by clicking timebox
                                  //kullanici ,zaman kutusuna tiklayarak etkinlik olusturabilir
        // 1-User click timeBox button
        driver.findElement(By.xpath("//tr[@class='fc-minor'][4]")).click();
        // 2-User create meeting box with "summary demo"
        driver.findElement(By.xpath("//input[@class='o_input']")).sendKeys("summary demo"+ Keys.ENTER);
        // 3-User click create button on create meeting box-->bir ustte gerceklesti,keys ile
        //driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();

   }
   // 4. Kullanıcı, takvimde etkinliğe tıkladığında etkinlik ayrıntılarını görebilir.
    @Test
    public void dısplayEvent() {
       // 1-user clıck created event
        driver.findElement(By.cssSelector(".fc-time-grid-event.fc-v-event.fc-event.fc-start.fc-end.fc-draggable.fc-resizable.o_calendar_color_6.fc-short")).click();
        //2-Verify Event Details
        WebElement title=driver.findElement(By.tagName("h4"));
        System.out.println("title.getText() = " + title.getText());
        Assert.assertTrue(title.isDisplayed());// daha ayrintili bir verify yontemi lazim
        Assert.assertEquals(title.getText(),"Open: summary demo");// daha tutarli bir verify yontemi yaptik

        WebElement editBtn=driver.findElement(By.xpath("//span[text()='Edit']"));
        WebElement deleteBtn=driver.findElement(By.xpath("//span[text()='Delete']"));
        WebElement closeBtn=driver.findElement(By.xpath("//span[text()='Close']"));

        Assert.assertTrue(editBtn.isDisplayed());
        Assert.assertTrue(deleteBtn.isDisplayed());
        Assert.assertTrue(closeBtn.isDisplayed());

   }
   // 5. Kullanıcı oluşturulan bir etkinliği düzenleyebilir
    @Test
    public void editCalander() {
       // 0-Created event
        driver.findElement(By.cssSelector(".fc-time-grid-event.fc-v-event.fc-event.fc-start.fc-end.fc-draggable." +
                "fc-resizable.o_calendar_color_6.fc-short")).click();

       // 1-User click edit button on Even detail
        WebElement editBtn=driver.findElement(By.xpath("//span[text()='Edit']"));
        editBtn.click();

       // 2- User can see the page that edit event detail
        WebElement titleEdit = driver.findElement(By.xpath("//label[text()='Meeting Subject']"));
        Assert.assertEquals("Meeting Subject",titleEdit.getText());
        driver.findElement(By.xpath("//input[@class='o_field_char o_field_widget o_input " +
                "o_required_modifier']")).sendKeys("Different Subject");

        // 3- User should edıt Duratıon
        driver.findElement(By.xpath("//input[@name='duration']")).clear();//sendkezs butonu temıylendı
        //driver.findElement(By.xpath("//input[@name='duration']")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@name='duration']")).sendKeys("00:35");//zenı tıme zayıldı

        // 4_click save button is displayed after that edit event title page
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Save']")).isDisplayed());

        // 5-Click save button
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);


        // 6-User click on calender Before created event
        WebElement eventBefore=driver.findElement(By.xpath("//a[@class='fc-time-grid-event " +
                "fc-v-event fc-event fc-start fc-end fc-draggable fc-resizable o_calendar_color_6']"));
        wait.until(ExpectedConditions.elementToBeClickable(eventBefore)).click();

        // 7-User click on delete Button after edit
        WebElement deleteBtn=driver.findElement(By.xpath("//span[text()='Delete']"));
        deleteBtn.click();

        // 8-Confirm delete button
        driver.findElement(By.xpath("//span[text()='Ok']")).click();



    }

    @AfterMethod
    public void tearDown(){
       driver.close();
   }



}
