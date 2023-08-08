package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;


   protected ExtentReports report;
   protected ExtentHtmlReporter htmlReporter;
   protected ExtentTest extentLogger;

   @BeforeTest
    public void setUpTest(){

        report=new ExtentReports();

        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";
        // bir usttekini dinamik yaptik asagida.test ler silinmiyor ve kaydedilyor
       // String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
       // String reportPath=projectPath+"/test-output/report"+date+".html";

        htmlReporter=new ExtentHtmlReporter(reportPath);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Smoke Test");

        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Umut Ihsan");
        report.setSystemInfo("PO", "Bilal Saglam");

    }
    @AfterTest
    public void tearDownTest(){
        report.flush();

    }
    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);

   }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
       // ıf the test faıls ..test basarısıy olursa
        if (result.getStatus()==ITestResult.FAILURE){
            // basarisiz testin adini alalim/record the failed test name
            extentLogger.fail(result.getName());
            // take screen shot and return the location of screen shot/ekran göruntusu
            // alalim ve kaydedildigi yeri belirleyelim
            String screenShotPath=BrowserUtils.getScreenshot(result.getName());
            // addd the screen shot to the report/rapora ekran goruntusunu ekleyelim
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            // capture exeption logs and add to the report/hata logunu rapora ekleyelim
            extentLogger.fail(result.getThrowable());


        }

        Driver.closeDriver();
    }






















}
