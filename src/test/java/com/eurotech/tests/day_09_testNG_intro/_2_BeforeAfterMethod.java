package com.eurotech.tests.day_09_testNG_intro;

import org.testng.annotations.*;

public class _2_BeforeAfterMethod {
    @Test (priority = 2) // oncelik sirasi
    public void test1(){
        System.out.println("Test 1");
    }
    @Test(priority = 1)
    //@Ignore // yok sayar
    public void test2(){
        System.out.println("Test 2");
    }
    @Test (priority =4 )
    public void test3(){
        System.out.println("Test 3");
    }
    @Test (priority = 3)
    //(enabled = false) // yok sayar
    public void test4(){
        System.out.println("Test 4");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }
    @AfterMethod   // @Ignore yazilirs calismaz,atlanir
    public void tearDown(){
        System.out.println("After Method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeTest
    public void beforeTest(){System.out.println("Before test");}
    @AfterTest
    public void afterTest(){System.out.println("After Test");}
    @BeforeSuite
    public void beforSuite(){System.out.println("Befor suite");}
    @AfterSuite
    public void afterSuite(){System.out.println("After Suite");}


}
