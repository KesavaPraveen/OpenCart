package com.qa.opencart.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {

    private ChromeOptions chromeOptions;
    private FirefoxOptions firefoxOptions;
    private EdgeOptions edgeOptions;
    private Properties prop;

    public OptionsManager(Properties prop)
    {
        this.prop=prop;
    }
    public ChromeOptions getChromeOptions()
    {
        chromeOptions=new ChromeOptions();
        //chromeOptions.addArguments("--remote-allow-origins=*");
        if (Boolean.parseBoolean(prop.getProperty("headless")))
        {
            chromeOptions.addArguments("--headless");
        }
        if (Boolean.parseBoolean(prop.getProperty("incognito")))
        {
            chromeOptions.addArguments("--incognito");
        }
        return chromeOptions;
    }

    public FirefoxOptions getFireFoxOptions()
    {
        firefoxOptions=new FirefoxOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless")))
        {
            firefoxOptions.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito")))
        {
            firefoxOptions.addArguments("--incognito");
        }
        return firefoxOptions;
    }

    public EdgeOptions getEdgeOptions()
    {
        edgeOptions=new EdgeOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless")))
        {
            edgeOptions.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito")))
        {
            firefoxOptions.addArguments("--incognito");
        }
        return edgeOptions;
    }
}
