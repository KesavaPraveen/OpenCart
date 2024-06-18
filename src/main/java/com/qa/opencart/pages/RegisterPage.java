package com.qa.opencart.pages;

import com.qa.opencart.utils.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {

    private GeneralUtil generalUtil;
    private WebDriver driver;

    public RegisterPage(WebDriver driver)
    {
        this.driver=driver;
        generalUtil=new GeneralUtil(driver);
    }

    private By registerLink=By.linkText("Register");
    private String registerAccountHeaderText="Register Account";
    private By registerAccountHeader=By.tagName("h1");
    private By loginPageHyperLink=By.linkText("login page");
    private By fieldsetHeaders= By.xpath("//fieldset/legend");
    private By firstName=By.name("firstname");
    private By lastName=By.id("input-lastname");
    private By emailID=By.id("input-email");
    private By telePhone=By.name("telephone");
    private By password=By.name("password");
    private By confirmPassword=By.id("input-confirm");
    private By yesRadioBtn=By.xpath("//input[@name='newsletter' and @value='1']");
    private By noRadioBtn=By.xpath("//input[@name='newsletter' and @value='0']");
    private By agreeCheckBox=By.name("agree");
    private By continueBtn=By.xpath("//input[@value='Continue']");
    private By regiterPageLabels=By.xpath("//label[@class='col-sm-2 control-label' and @for]");
    private By successMsg=By.cssSelector("div#content h1");
    private String successText="Created";
    private By logoutLink= By.linkText("Logout");

    public String getRegisterPageTitle()
    {
        String pageTitle=generalUtil.getPageTitle();
        return pageTitle;
    }

    public String getRegisterAccountHeaderText()
    {
        registerAccountHeaderText=generalUtil.doGetText(registerAccountHeader);
        return registerAccountHeaderText;
    }

    public List<String> getFieldSetHeaderTextList()
    {
        List<String> fieldsetHeaderTextList=generalUtil.getElementsTextList(fieldsetHeaders);
        return fieldsetHeaderTextList;
    }

    public boolean loginPageHyperLinkExist()
    {
        return generalUtil.getElement(loginPageHyperLink).
                isDisplayed();
    }

    public List<String> getLabelElementsText()
    {
        return generalUtil.getElementsTextList(regiterPageLabels);
    }

    public boolean yesRadioButtonExist()
    {
        return generalUtil.getElement(yesRadioBtn).isDisplayed();
    }

    public boolean noRadioButtonExist()
    {
        return generalUtil.getElement(noRadioBtn).isDisplayed();
    }

    public boolean agreeCheckBoxExist()
    {
        return generalUtil.getElement(agreeCheckBox).isDisplayed();
    }

    public boolean newUserRegister(String fname, String lname,
                                   String email, String phone,
                                   String pass, String sub)
    {
        generalUtil.doSendKeys(firstName,fname);
        generalUtil.doSendKeys(lastName,lname);
        generalUtil.doSendKeys(emailID,email);
        generalUtil.doSendKeys(telePhone,phone);
        generalUtil.doSendKeys(password,pass);
        generalUtil.doSendKeys(confirmPassword,pass);
        if(sub.equalsIgnoreCase("yes"))
        {
            generalUtil.doClick(yesRadioBtn);
        }
        else{
            generalUtil.doClick(noRadioBtn);
        }
        generalUtil.doClick(agreeCheckBox);
        if(generalUtil.getElement(agreeCheckBox).isSelected())
        {
            generalUtil.doClick(continueBtn);
        }
        else {
            System.out.println("Kindly Please click on the Agree Check Box button");
        }
        String successMesg = generalUtil.doGetText(successMsg);
        System.out.println(successMesg);

        if(successMesg.contains(successText)) {
            generalUtil.doClick(logoutLink);
            generalUtil.doClick(registerLink);
            return true;
        }
        else return false;
    }

}
