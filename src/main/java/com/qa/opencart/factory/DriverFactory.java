package com.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    public Properties prop;
    public WebDriver driver;
    public OptionsManager optionsManager;
    public static String highlight;


    public WebDriver initiateDriver(Properties prop)
    {
        String browserName= prop.getProperty("browser").trim();
        optionsManager=new OptionsManager(prop);
        if(browserName.equalsIgnoreCase("chrome"))
        {
            //WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(optionsManager.getChromeOptions());
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            //WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver(optionsManager.getFireFoxOptions());
        }
        else if(browserName.equalsIgnoreCase("edge"))
        {
            //WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver(optionsManager.getEdgeOptions());
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(initiateProp().getProperty("url"));
        highlight=prop.getProperty("highlight").trim();
        return driver;
    }

    public Properties initiateProp()
    {
        prop=new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/Config/config.properties");
            prop.load(fileInputStream);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
            throw new RuntimeException("failed to find the config properties file....");
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
            throw new RuntimeException("failed to read properties in the file....");
        }
        return prop;
    }
}
