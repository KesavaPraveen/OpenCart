package com.qa.opencart.pages;

import com.qa.opencart.utils.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInfoPage {

    private WebDriver driver;
    private GeneralUtil generalUtil;

    public ProductInfoPage(WebDriver driver)
    {
        this.driver=driver;
        generalUtil=new GeneralUtil(driver);
    }

    private By addToWishListButton= By.xpath("//button[@data-original-title='Add to Wish List']");
    private By compareButton=By.xpath("//button[@data-original-title='Compare this Product']");
    private By productNameHeaderText=By.tagName("h1");
    private By quantityTextBox=By.id("input-quantity");
    private By quantityLabelText=By.xpath("//label[@class='control-label' and @for='input-quantity']");
    private By addToCartButton=By.id("button-cart");
    private By productNavTabsList=By.xpath("//ul[@class='nav nav-tabs']/li");
    private By descriptionLink=By.linkText("Description");
    private By specificationLink=By.linkText("Specification");
    private By productImagesList=By.xpath("//ul[@class='thumbnails']/li");
    private By productMetaDataList=By.cssSelector("div.col-sm-4 ul.list-unstyled:nth-of-type(1) li");
    private By productPriceDataList=By.cssSelector("div.col-sm-4 ul.list-unstyled:nth-of-type(2) li");
    private Map<String, String> productInfoMap;

    public Boolean addToWishListButtonExist()
    {
        return generalUtil.getElement(addToWishListButton).isDisplayed();
    }

    public Boolean compareProductButtonExist()
    {
        return generalUtil.getElement(compareButton).isDisplayed();
    }

    public String getQuantityLabelText()
    {
        return generalUtil.doGetText(quantityLabelText);
    }

    public Boolean quantityTextBoxExist()
    {
        return generalUtil.getElement(quantityTextBox).isDisplayed();
    }

    public Boolean addToCartButtonExist()
    {
        return generalUtil.getElement(addToCartButton).isDisplayed();
    }

    public int getProductNavTabsCount()
    {
        return generalUtil.getElements(productNavTabsList).size();
    }

    public Boolean navTabDescriptionLinkExist()
    {
        return generalUtil.getElement(descriptionLink).isDisplayed();
    }

    public Boolean navTabSpecificationLinkExist()
    {
        return generalUtil.getElement(specificationLink).isDisplayed();
    }

    public int getProductImageCount()
    {
        return generalUtil.getElements(productImagesList).size();
    }

    public Map<String, String> getProductInformation()
    {
        productInfoMap=new HashMap<String,String>();
        getProductTitleInfo();
        getProductMetaDataInfo();
        getProductPriceDataInfo();
        return productInfoMap;
    }
    private void getProductTitleInfo()
    {
        String productHeaderText=generalUtil.doGetText(productNameHeaderText);
        productInfoMap.put("product title",productHeaderText);
    }

    private void getProductMetaDataInfo()
    {
        List<WebElement> metaDataList=generalUtil.getElements(productMetaDataList);
        for(WebElement e: metaDataList)
        {
            String text=e.getText();
            String metaData[]=text.split(":");
            String key=metaData[0].trim();
            String value=metaData[1].trim();
            productInfoMap.put(key,value);
        }
    }

    private void getProductPriceDataInfo()
    {
        List<WebElement> priceDataList=generalUtil.getElements(productPriceDataList);
        String price=priceDataList.get(0).getText();
        String taxPrice=priceDataList.get(1).getText();
        productInfoMap.put("price",price);
        productInfoMap.put("Taxation price",taxPrice);
    }
}
