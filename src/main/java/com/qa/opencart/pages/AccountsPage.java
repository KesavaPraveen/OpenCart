package com.qa.opencart.pages;

import com.qa.opencart.utils.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    private GeneralUtil generalUtil;

    public AccountsPage(WebDriver driver)
    {
        this.driver=driver;
        generalUtil=new GeneralUtil(driver);
    }

    private By sectionHeaders=By.cssSelector("div#content h2");
    private By myAccountSectionLinks=By.xpath("//h2[text()='My Account']/parent::div[@id='content']/child::ul[1]/li");
    private By myOrdersSectionLinks=By.xpath("//h2[text()='My Orders']/parent::div[@id='content']/child::ul[2]/li");
    private By myAffiliateSectionLink=By.xpath("//h2[text()='My Affiliate Account']/parent::div[@id='content']/child::ul[3]/li");
    private By newsLetterSectionLink=By.xpath("//h2[text()='Newsletter']/parent::div[@id='content']/child::ul[4]/li");
    private By logOutLink=By.linkText("Logout");
    private By searchTitleBox=By.name("search");
    private By searchButton=By.cssSelector("div#search button");

    public String getAccountsPageTitle()
    {
        return generalUtil.getPageTitle();
    }
    public List<String> getHeaderSectionTexts()
    {
        return generalUtil.getElementsTextList(sectionHeaders);
    }
    public List<String> getMyAccountLinks()
    {
        return generalUtil.getElementsTextList(myAccountSectionLinks);
    }
    public List<String> getMyOrdersLinks()
    {
        return generalUtil.getElementsTextList(myOrdersSectionLinks);
    }
    public String getMyAffiliateLink()
    {
        return generalUtil.doGetText(myAffiliateSectionLink);
    }
    public String getNewsLetterLink()
    {
        return generalUtil.doGetText(newsLetterSectionLink);
    }

    public Boolean logOutLinkExist()
    {
        return generalUtil.getElement(logOutLink).isDisplayed();
    }
    public Boolean searchBoxExist()
    {
        return generalUtil.getElement(searchTitleBox).isDisplayed();
    }
    public Boolean searchButtonExist()
    {
        return generalUtil.getElement(searchButton).isDisplayed();
    }

    public ResultsPage searchProduct(String productName)
    {
        if(searchBoxExist())
        {
            generalUtil.doSendKeys(searchTitleBox,productName);
            if (searchButtonExist())
            {
                generalUtil.doClick(searchButton);
            }
        }
        return new ResultsPage(driver,productName);
    }
}
