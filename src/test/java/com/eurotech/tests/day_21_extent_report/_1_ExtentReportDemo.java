package com.eurotech.tests.day_21_extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.*;

public class _1_ExtentReportDemo {
    // this class is used for starting and building reports.
    // bu klass rapor olusturmak ve rapor ile ilgili metadata yi
    // tanimlamak icin kull.(Rapora özel)
    ExtentReports report;

    ExtentHtmlReporter htmlReporter;// This class is used for to create a html report file.
                                    // bu class raporumuzun html formatinda olmasini saglar

    ExtentTest extentLogger;  // This class will define a test .enable longs and test steps.
                              // Her test ile ilgili logg kayitlarini ve test adimlarini
                               // tanimlamamizi saglar


    @BeforeMethod
    public void setUp() {
        // initilalize class
        report=new ExtentReports();
       // creat a report path--> raporun kayit adilecegi yeri belirleyelim
        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(reportPath); // initialize the html report with
                                                           // report path
                                                    // HTML raporumuzu Path ile olusturalim
       report.attachReporter(htmlReporter); // attach the report  to the report object
                                    // html raporumuzu report nesnesiyle iliskilendirelim
       htmlReporter.config().setReportName("Smoke Test");  // title in report
                                                          //  rapor basligini duzenleyelim
       // set environment information / raporun datasini duzenleyelim
       report.setSystemInfo("Environment","QA");
       report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
       report.setSystemInfo("OS", System.getProperty("os.name"));
       report.setSystemInfo("Test Engineer", "Umut Ihsan");
       report.setSystemInfo("PO", "Bilal Saglam");

    }

    @Test
    public void test1() {
        // specific test case name / mevcut testimizin ismini girelim
        extentLogger=report.createTest("TC002 Demo Test");

        // test steps / test adimlari
        extentLogger.info("chrome browseri ac");
        // cod here
        extentLogger.info("Web sitesine git");
        // cod here
        extentLogger.info(" emaili gir");
        // cod here
        extentLogger.info(" password gir");
        // cod here
        extentLogger.info(" login e click yap");
        // cod here
        extentLogger.info(" login oldugunu kullanici adi:"
                +ConfigurationReader.get("userName)")+"ile dogrula");
        // cod here

        extentLogger.pass("passed"); // if this code executes,the test will be admitted as "passed"
                        // eger kod buraya kadar gelmisse test gecmis sayilacaktir


    }

    @AfterMethod
    public void tearDown() {
        // raporun gercek anlamda olusturuldugu yer
        // where the report is actualliy generated
        report.flush();   // flush--> sifonu cekmek

    }
}
