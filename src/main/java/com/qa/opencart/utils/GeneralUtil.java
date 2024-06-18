package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.qa.opencart.factory.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtil {

	
	private WebDriver driver;
	private JavaScriptUtil javaScriptUtil;

	public GeneralUtil(WebDriver driver) {
		
		this.driver=driver;
		javaScriptUtil=new JavaScriptUtil(driver);
	}

	/*
	 * This method return the title of the page
	 */
	
	public String getPageTitle()	{
		
		return driver.getTitle();
	}
	
	/*
	 * This method return current webpage URL
	 */
	
	public String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	/*
	 * This method get the web element using By locator as parameter
	 */
	
	public WebElement getElement(By locator)
	{

		WebElement element= driver.findElement(locator);
		if(Boolean.parseBoolean(DriverFactory.highlight))
		{
			javaScriptUtil.flash(element);
		}
		return element;

	}
	
	/*
	 * This method get the list of web elements using By locator as parameter
	 */
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	/*
	 * This method is used to enter the values
	 */
	
	public void doSendKeys(By locator,String elementText)
	{
		getElement(locator).clear();
		getElement(locator).sendKeys(elementText);
	}
	
	/*
	 * This method is used to click the web element
	 */
	
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	/*
	 * This method is used to get the text of the web element
	 */
	
	public String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
	
	/*
	 * This method is used to get the attribute value of the web element
	 */
	
	public String doGetAttribute(By locator, String attValue)
	{
		return getElement(locator).getAttribute(attValue);
	}
	
	/*
	 * This method is used to get the text of the web elements
	 */
	public List<String> getElementsTextList(By locator)
	{
		List<WebElement> elementList=getElements(locator);
		List<String> elementTextList=new ArrayList<String>();
		for(WebElement e: elementList)
		{
			String text=e.getText();
			elementTextList.add(text);
		}
		return elementTextList;		
	}
	
	/*
	 *  This method is used to get the attribute value of the web elements
	 */
	public List<String> getElementAttributeList(By locator, String attribute)
	{
		List<WebElement> elementList= getElements(locator);
		List<String> elementAttList= new ArrayList<String>();
		for(WebElement e: elementList)
		{
			String attval= e.getAttribute(attribute);
			elementAttList.add(attval);
		}
		return elementAttList;
	}
	
	/*
	 * This method is used to select the value by index from the drop downs 
	 */
	
	public void doSelectByIndex(By locator,int number)
	{
		Select select=new Select(getElement(locator));
		select.selectByIndex(number);	
	}
	
	/*
	 * This method is used to select the value by value from the drop downs 
	 */
	
	public void doSelectByValue(By locator, String value)
	{
		Select select=new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	/*
	 * This method is used to select the value by visible text from the drop downs 
	 */
	
	public void doSelectByVisibleText(By locator, String text)
	{
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	/*
	 *  This method is used to select the text from drop down without the use of Select Class
	 */
	
	public  void selectTextfromDropDown(By locator,String textValue)
	{
		for(WebElement e: getElements(locator))
		{
			String text=e.getText();
			if(text.equals(textValue))
			{
				e.click();
				break;
			}
		}
	}
	
	/*
	 * This method is used to click on the web element using Action Class 
	 */
		
	public void actionClick(By locator)
	{
		Actions act=new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	
	/*
	 * This method is used to enter the values in Upper Case
	 */
	public void doActionSendKeys(By locator,String value) 
	{
		Actions act=new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();;
	}
	/*
	 * This method is used to print the text when we hover the mouse to web element drop downs 	
	 */
	
	public void printTextActionDropDowns(By locator)
	{
		getElements(locator);
		for(WebElement e: getElements(locator))
		{
			System.out.println(e.getText());
		}
	}	

	/*
	 * This method is used to enter the values in Lower Case
	 */
	public void doActionKeyDown(By locator,String value)
	{
		Actions act=new Actions(driver);
		act.keyDown(Keys.SHIFT).sendKeys(getElement(locator), value).perform();
	}
	
	/*
	 * This method is used to enter the values in Upper Case
	 */
	public void doActionKeyUp(By locator,String value)
	{
		Actions act=new Actions(driver);
		act.keyUp(Keys.SHIFT).sendKeys(getElement(locator), value).perform();
	}
	
	/*
	 * These Methods are used to handle alerts in the web page
	 * 1. Get text from the alert box
	 * 2. Accept the alert
	 * 3. Reject the alert
	 * 4. Type the text in the alert box
	 */
	public String doAlertGetText()
	{
		return driver.switchTo().alert().getText();
	}
	
	public void doAlertAccept()
	{
		driver.switchTo().alert().accept();
	}
	public void doAlertReject()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void doAlertSendKeys(String alerttext)
	{
		driver.switchTo().alert().sendKeys(alerttext);
	}
	
	/*
	 * These Methods are used to wait for particular interval of time for the web element to load in the web page
	 * 1. Wait for the alert dialog box to be displayed
	 * 2. Wait for the text to be present in the web element  
	 * 3. Wait for the element to be visible in the web page
	 * 4. Wait for the list of elements to be visible in the web page
	 * 4. Wait for the element to be clickable in the web page
	 * 5. Wait for the element to be selectable in the web page
	 * 
	 */
	public Alert waitForAlertWindow(int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public Boolean waitForTextToBePresentInTheElement(By locator,String text,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
	}
	
	public WebElement waitForVisibilityOfElement(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	public List<WebElement> waitForVisibilityOfElements(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public WebElement waitForElementToBeClickable(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
	}
	
	public Boolean waitForElementToBeSelected(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeSelected(getElement(locator)));
	}
}
