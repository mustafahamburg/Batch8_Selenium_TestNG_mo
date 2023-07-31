package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_DashBoardTest extends TestBase {
    @Test
    public void tabMenuTest() {
        /**
         * go to kraft login page
         * login with valid credentials
         * verify that you are on the dashboard page by using 'Dashboard'
         * keyword at top-left
         * Verify that tabs menu contains "Dashboard", "Developers",
         * "Components", "Forms",  "JavaScript", "mustafa"
         */
        LoginPage loginPage=new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage=new DashboardPage();
        String actualTitle = dashboardPage.dashboardPageTitle.getText();
        String expectedTitle="Dashboard";
        
        Assert.assertEquals(actualTitle,expectedTitle);

//        List<String>tabMenuNames=new ArrayList<>();
//        for (WebElement menu : dashboardPage.tabMenu) {
//            tabMenuNames.add(menu.getText());
//        }
        List<String > tabMenuNames  =dashboardPage.getTabMenuNames();
        List<String>expectedTabNames=new ArrayList<>
                (Arrays.asList("Dashboard", "Developers","Components", "Forms",  "JavaScript", "mustafa"));

        Assert.assertEquals(tabMenuNames,expectedTabNames);
    }

    @Test
    public void navigateMenu_1() {
        /**
         * login with valid credentials
         * go to 'Developers' tab via navigateToTabs()
         * validate that you are on the right page through url
         * expectedUrl = https://www.krafttechexlab.com/developers
         */
        LoginPage loginPage=new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToTabsAndModules("Developers");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/developers";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Test
    public void navigateMenu_2() {
        /**
         * login with valid credentials
         * go to 'Components --> Modal' submodule via navigateToTabsAndModule( two parameters)
         * validate that you are on the right page through url
         * expected url :https://www.krafttechexlab.com/components/modal
         * then navigate to Developer tab and make verification with url
         */
        LoginPage loginPage=new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToTabsAndModules("Components","Modal");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/components/modal";
        Assert.assertEquals(actualUrl,expectedUrl);

        dashboardPage.navigateToTabsAndModules("Developers");

        String actualUrl_1=driver.getCurrentUrl();
        String expectedUrl_1="https://www.krafttechexlab.com/developers";
        Assert.assertEquals(actualUrl_1,expectedUrl_1);

    }

















}
