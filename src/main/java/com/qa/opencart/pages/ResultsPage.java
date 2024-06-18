package com.qa.opencart.pages;

import com.qa.opencart.utils.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage {

    private WebDriver driver;
    private GeneralUtil generalUtil;

    public ResultsPage(WebDriver driver,String productName)
    {
        this.driver=driver;
        this.productName=productName;
        generalUtil=new GeneralUtil(driver);
    }

    private By breadCrumbHomePageIcon=By.xpath("//i[@class='fa fa-home']");
    private By breadCrumbSearchLink=By.linkText("Search");
    private By resultPageMainHeaderText=By.tagName("h1");
    private By resultPageSearchTextBox=By.cssSelector("input#input-search");
    private By categoryDropDown= By.name("category_id");
    private By subCategoryCheckBox=By.name("sub_category");
    private By descriptionCheckBox=By.id("description");
    private By searchButton=By.id("button-search");
    private By resultPageProductHeaderText=By.tagName("h2");
    private By listViewButton=By.id("list-view");
    private By gridViewButton=By.id("grid-view");
    private By sortByDropDown=By.id("input-sort");
    private By showDropDown=By.id("input-limit");
    private By resultViewList=By.xpath("//div[@class='product-thumb']/parent::div");
    private By productList=By.xpath("//div[@class='caption']//a");
    public String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getResultPageTitle()
    {
        return generalUtil.getPageTitle();
    }
    public String getSearchMainHeaderText()
    {
        return generalUtil.doGetText(resultPageMainHeaderText);
    }
    public Boolean breadCrumbHomeIconExist()
    {
        return generalUtil.getElement(breadCrumbHomePageIcon).isDisplayed();
    }
    public Boolean breadCrumbSearchLinkExist()
    {
        return generalUtil.getElement(breadCrumbSearchLink).isDisplayed();
    }
    public Boolean searchBoxExist()
    {
        return generalUtil.getElement(resultPageSearchTextBox).isDisplayed();
    }
    public String getInnerValueInSearchBox()
    {
        if(searchBoxExist())
        {
            return generalUtil.getElement(resultPageSearchTextBox).getAttribute("value");
        }
        else {
            return "Unable to return Inner Text";
        }
    }
    public boolean categoryDropDownExist()
    {
        return generalUtil.getElement(categoryDropDown).isDisplayed();
    }
    public void selectValueInCategoryDropDown(String text)
    {
        if (categoryDropDownExist())
        {
            generalUtil.doSelectByVisibleText(categoryDropDown,text);
        }
        else {
            System.out.println("Please enter Valid Text");
        }
    }
    public Boolean subCategoryCheckBoxExist()
    {
        return generalUtil.getElement(subCategoryCheckBox).isDisplayed();
    }
    public Boolean descriptionCheckBoxExist()
    {
        return generalUtil.getElement(descriptionCheckBox).isDisplayed();
    }
    public Boolean subCategoryCheckBoxIsEnabled(String text)
    {
        selectValueInCategoryDropDown(text);
        return generalUtil.getElement(subCategoryCheckBox).isEnabled();
    }
    public Boolean searchButtonExist()
    {
        return generalUtil.getElement(searchButton).isDisplayed();
    }
    public String getProductHeaderText()
    {
        return generalUtil.doGetText(resultPageProductHeaderText);
    }
    public Boolean listViewButtonExist()
    {
        return generalUtil.getElement(listViewButton).isDisplayed();
    }
    public Boolean gridViewButtonExist()
    {
        return generalUtil.getElement(gridViewButton).isDisplayed();
    }
    public Boolean sortByDropDownExist()
    {
        return generalUtil.getElement(sortByDropDown).isDisplayed();
    }
    public Boolean showDropDownExist()
    {
        return generalUtil.getElement(showDropDown).isDisplayed();
    }
    public void selectSortByDropDown(String text)
    {
        generalUtil.doSelectByVisibleText(sortByDropDown,text);
    }

    public ProductInfoPage selectProduct(String productName)
    {
       setProductName(productName);
       List<WebElement> productElementList=generalUtil.waitForVisibilityOfElements(productList,10);
       for (WebElement e: productElementList)
       {
           String text=e.getText();
           if (text.equalsIgnoreCase(productName))
           {
               e.click();
               break;
           }
       }
        return new ProductInfoPage(driver);
    }
}
