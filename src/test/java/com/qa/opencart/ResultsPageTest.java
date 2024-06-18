package com.qa.opencart;

import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResultsPageTest extends BaseTest{

    @BeforeClass
    public void resultPageSetUp()
    {
        accountsPage=loginPage.login(prop.getProperty("email"),prop.getProperty("pass"));
        resultsPage=accountsPage.searchProduct("mac");
    }

    @Test
    public void resultsPageTitleTest()
    {
        String actualTitle=resultsPage.getResultPageTitle();
        Assert.assertEquals(actualTitle, Constants.RESULTS_PAGE_TITLE + resultsPage.getProductName());
    }

    @Test
    public void searchHeaderTextTest()
    {
        String actualText=resultsPage.getSearchMainHeaderText();
        Assert.assertEquals(actualText,Constants.RESULTS_PAGE_SEARCH_HEADER_TEXT + resultsPage.getProductName());
    }

    @Test
    public void resultsPageBreadCrumbTest()
    {
       Assert.assertTrue(resultsPage.breadCrumbHomeIconExist());
       Assert.assertTrue(resultsPage.breadCrumbSearchLinkExist());
    }

    @Test
    public void searchTextBoxInnerTextProductNameTest()
    {
        String actualValueText=resultsPage.getInnerValueInSearchBox();
        Assert.assertEquals(actualValueText, resultsPage.getProductName());
    }

    @Test
    public void resultsPageDropDownsExistTest()
    {
        Assert.assertTrue(resultsPage.categoryDropDownExist());
        Assert.assertTrue(resultsPage.sortByDropDownExist());
        Assert.assertTrue(resultsPage.showDropDownExist());
    }

    @Test
    public void resultsPageCheckBoxIsDisplayedTest()
    {
        Assert.assertTrue(resultsPage.subCategoryCheckBoxExist());
        Assert.assertTrue(resultsPage.descriptionCheckBoxExist());
    }

    @Test
    public void subCategoryCheckBoxIsEnabledTest()
    {
        Assert.assertTrue(resultsPage.subCategoryCheckBoxIsEnabled("Desktops"));
    }

    @Test
    public void searchButtonTest()
    {
        Assert.assertTrue(resultsPage.searchButtonExist());
    }

    @Test
    public void productHeaderTextTest()
    {
        String actualText=resultsPage.getProductHeaderText();
        Assert.assertEquals(actualText,Constants.RESULTS_PAGE_PRODUCT_HEADER_TEXT);
    }
}
