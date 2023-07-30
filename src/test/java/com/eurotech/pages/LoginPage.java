package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);

    }
    @FindBy(id="email")
    public WebElement emailBox;
   // WebElement emailBox = driver.findElement(By.id("email"));
    //yukaridaki bunu yapiyor,bu Selenium dan gelir
    // Pom:Page Object Model ile ilgili her sey Selenium kaynaklidir

   @FindBy(id="yourPassword")
   public WebElement passwordBox;

   @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginBtn;

   // AND logic ile calisir, yani iki findBy in da dogru olmasi gerekir
    @FindBys({
            @FindBy(css="#email"),
            @FindBy(xpath = "//input[@name='email']")
    })
    public WebElement emailBoxWithFindBys;

    // OR logic ile calisir, yani iki findBy dan birinin dogru olmasi gerekir
    @FindAll({
            @FindBy(css = "#yourPassword"),
            @FindBy(css = ".ihsan") // bilerek yanlis yazdik cunku birinin dogru olmasi yeterli
    })
    public WebElement PasswordBoxWithFindAll;
    @FindBy(xpath = "//div[contains(text(),'Password is incorrect.')]")
    public WebElement wrongPasswordWarningMassage;
    @FindBy(xpath = "//div[contains(text(),'Email address is incorrect.')]")
    public WebElement wrongUserEmailWarningMessage;
    @FindBy(css = ".form-control,button")
    public List<WebElement>loginInputs;

}
