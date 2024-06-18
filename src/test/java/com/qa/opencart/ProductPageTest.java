package com.qa.opencart;

import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductPageTest extends BaseTest{

    @BeforeClass
    public void productPageSetup()
    {
        accountsPage=loginPage.login(prop.getProperty("email"),prop.getProperty("pass"));
        resultsPage=accountsPage.searchProduct("mac");
        productInfoPage=resultsPage.selectProduct("MacBook");
    }

    @Test
    public void wishListButtonTest()
    {
        Assert.assertTrue(productInfoPage.addToWishListButtonExist());
    }

    @Test
    public void compareButtonTest()
    {
        Assert.assertTrue(productInfoPage.compareProductButtonExist());
    }

    @Test
    public void quantityLabelTest()
    {
        String actualText=productInfoPage.getQuantityLabelText();
        Assert.assertEquals(actualText, Constants.PRODUCT_PAGE_QUANTITY_LABEL_TEXT);
    }

    @Test
    public void quantityTextBoxTest()
    {
        Assert.assertTrue(productInfoPage.quantityTextBoxExist());
    }

    @Test
    public void addToCartButtonTest()
    {
        Assert.assertTrue(productInfoPage.addToCartButtonExist());
    }

    @Test
    public void productNavTabCountTest()
    {
        Assert.assertEquals(productInfoPage.getProductNavTabsCount(),Constants.PRODUCT_PAGE_NAV_TAB_COUNT);
    }

    @Test
    public void descriptionLinkTest()
    {
        Assert.assertTrue(productInfoPage.navTabDescriptionLinkExist());
    }

    @Test
    public void specificationLinkTest()
    {
        Assert.assertTrue(productInfoPage.navTabSpecificationLinkExist());
    }

    @Test
    public void productImagesCountTest()
    {
        Assert.assertEquals(productInfoPage.getProductImageCount(),Constants.PRODUCT_MACBOOK_IMAGE_COUNT);
    }
}
