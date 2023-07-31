package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage{
    @FindBy(id = "about")
    public WebElement aboutBox;
    @FindBy(xpath = "(//input[@id='company'])[1]")
    public WebElement companyBox;
    @FindBy(xpath = "//select[@id='job'] ")
    public WebElement jobSelect;
    @FindBy(id = "website")
    public WebElement websiteBox;
    @FindBy(xpath = "(//input[@id='location'])[1]")
    public WebElement locationBox;
    @FindBy(id = "skills")
    public WebElement skillsBox;
    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveChangesBtn;





}
