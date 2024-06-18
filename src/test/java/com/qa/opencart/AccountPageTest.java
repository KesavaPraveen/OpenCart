package com.qa.opencart;

import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AccountPageTest extends BaseTest{

    @BeforeClass
    public void accountPageSetUp()
    {
        accountsPage=loginPage.login(prop.getProperty("email"),prop.getProperty("pass"));
    }

    @Test
    public void accountPageTitleTest()
    {
        String actualTitle=accountsPage.getAccountsPageTitle();
        Assert.assertEquals(actualTitle, Constants.ACCOUNT_PAGE_TITLE);
    }

    @Test
    public void headerSectionsTextTest()
    {
        List<String> actualSectionList=accountsPage.getHeaderSectionTexts();
        Assert.assertEquals(actualSectionList,Constants.ACCOUNT_HEADER_SECTION_LIST);
    }

    @Test
    public void myAccountSectionLinksTest()
    {
        List<String> actualLinksList=accountsPage.getMyAccountLinks();
        Assert.assertEquals(actualLinksList,Constants.ACCOUNT_PAGE_MY_SECTION_LINKS_LIST);
    }

    @Test
    public void myOrdersSectionLinksTest()
    {
        List<String> actualLinksList=accountsPage.getMyOrdersLinks();
        Assert.assertEquals(actualLinksList,Constants.ACCOUNT_PAGE_MY_ORDERS_LINKS_LIST);
    }

    @Test
    public void myAffiliateAccountSectionLinkTest()
    {
        String actualText=accountsPage.getMyAffiliateLink();
        Assert.assertEquals(actualText,Constants.ACCOUNT_PAGE_MY_AFFILIATE_LINK_TEXT);
    }

    @Test
    public void newsLetterSectionLinkTest()
    {
        String actualText=accountsPage.getNewsLetterLink();
        Assert.assertEquals(actualText,Constants.ACCOUNT_PAGE_NEWS_LETTER_LINK_TEXT);
    }

    @Test
    public void logOutLinkExistTest()
    {
        Assert.assertTrue(accountsPage.logOutLinkExist());
    }

    @Test
    public void searchBoxExistTest()
    {
        Assert.assertTrue(accountsPage.searchBoxExist());
    }

    @Test
    public void searchButtonTest()
    {
        Assert.assertTrue(accountsPage.searchButtonExist());
    }

}
