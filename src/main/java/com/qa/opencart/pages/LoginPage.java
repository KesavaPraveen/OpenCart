package com.qa.opencart.pages;

import com.qa.opencart.utils.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.print.Book;
import java.util.Properties;

public class LoginPage {

    private GeneralUtil generalUtil;
    private WebDriver driver;
    Properties prop;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        generalUtil=new GeneralUtil(driver);
    }
    private By emailId=By.name("email");
    private By password=By.id("input-password");
    private By forgotPasswordLink=By.linkText("Forgotten Password");
    private By loginButton=By.xpath("//input[@value='Login']");
    private By warningInvalidEmailandPasswordText=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    private By newCustomerContinueButton=By.xpath("//h2[text()='New Customer']/parent::div[@class='well']//a");

    public String getLoginPageTitle()
    {
        String pageTitle=generalUtil.getPageTitle();
        return pageTitle;
    }

    public String getLoginPageUrl()
    {
        String currentUrl=generalUtil.getCurrentURL();
        return currentUrl;
    }

    public Boolean forgotPasswordLinkExist()
    {
        return generalUtil.getElement(forgotPasswordLink).isDisplayed();
    }

    public ForgotPasswordPage navigateToForgotPassword()
    {
       generalUtil.doClick(forgotPasswordLink);
       return new ForgotPasswordPage(driver);
    }

    public AccountsPage login(String email,String pwd)
    {
        //adminadmin123@test.com,admin@123
        generalUtil.doActionSendKeys(emailId,email);
        generalUtil.doActionSendKeys(password,pwd);
        generalUtil.doClick(loginButton);
        return new AccountsPage(driver);
    }

    public String invalidLogin(String email, String pwd)
    {
        generalUtil.doActionSendKeys(emailId,email);
        generalUtil.doActionSendKeys(password,pwd);
        generalUtil.doClick(loginButton);
        String warningMsg=generalUtil.doGetText(warningInvalidEmailandPasswordText);
        return warningMsg;
    }

    public RegisterPage navigateToRegisterPage()
    {
        generalUtil.doClick(newCustomerContinueButton);
        return new RegisterPage(driver);
    }

}
