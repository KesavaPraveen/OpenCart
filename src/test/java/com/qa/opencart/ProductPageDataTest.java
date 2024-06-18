package com.qa.opencart;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductPageDataTest extends BaseTest{

    @BeforeClass()
    public void productPageDataSetup()
    {
        accountsPage=loginPage.login(prop.getProperty("email"),prop.getProperty("pass"));
    }

    @DataProvider
    public Object[][] getProductData()
    {
        return new Object[][]{
                {"mac", "MacBook","MacBook","Apple","Product 16","600","In Stock"
                ,"$602.00","Ex Tax: $500.00"},
                {"pro", "MacBook Pro","MacBook Pro","Apple","Product 18","800","In Stock"
                ,"$2,000.00","Ex Tax: $2,000.00"}
        };
    }

    @Test(dataProvider="getProductData")
    public void productDataTest(String searchProduct,String productName,String productTitle,String brand,
                                        String pCode,String rewardPoints,String availability,
                                        String price,String taxPrice)
    {
        resultsPage=accountsPage.searchProduct(searchProduct);
        productInfoPage=resultsPage.selectProduct(productName);
        Map<String,String> actualProductMap=productInfoPage.getProductInformation();
        actualProductMap.forEach((key,value)-> System.out.println("Key:"+key+" Value:"+value));
        Assert.assertEquals(actualProductMap.get("product title"),productTitle);
        Assert.assertEquals(actualProductMap.get("Brand"),brand);
        Assert.assertEquals(actualProductMap.get("Product Code"),pCode);
        Assert.assertEquals(actualProductMap.get("Reward Points"),rewardPoints);
        Assert.assertEquals(actualProductMap.get("Availability"),availability);
        Assert.assertEquals(actualProductMap.get("price"),price);
        Assert.assertEquals(actualProductMap.get("Taxation price"),taxPrice);
    }
}
