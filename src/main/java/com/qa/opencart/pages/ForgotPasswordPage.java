package com.qa.opencart.pages;

import com.qa.opencart.utils.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private GeneralUtil generalUtil;

    public ForgotPasswordPage(WebDriver driver)
    {
        this.driver=driver;
        generalUtil=new GeneralUtil(driver);
    }

    private By forgotPwdHeaderText=By.tagName("h1");
    private By emailId=By.id("input-email");

    public String getForgotPasswordPageTitle()
    {
        return generalUtil.getPageTitle();
    }
    public String getForgotPasswordPageHeaderText()
    {
        return generalUtil.doGetText(forgotPwdHeaderText);
    }
    public Boolean emailAddressBoxExist()
    {
        return generalUtil.getElement(emailId).isDisplayed();
    }
}
