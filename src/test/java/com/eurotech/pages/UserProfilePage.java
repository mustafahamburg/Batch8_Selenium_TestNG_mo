package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{
    @FindBy(xpath = "//li[@class='breadcrumb-item'][2]")
    public WebElement editProfilePageTitle;
    @FindBy(css= "div#profile-overview>div:nth-of-type(1)")
    public WebElement profileUpdateMessage;
    public void navigateUserProfileTabs(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//button[text()='"+tabName+"']/parent::li"));
        tab.click();

    }


}
