package com.qa.opencart;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    DriverFactory driverFactory;
    Properties prop;
    LoginPage loginPage;
    RegisterPage registerPage;
    AccountsPage accountsPage;
    ForgotPasswordPage forgotPasswordPage;
    ResultsPage resultsPage;
    ProductInfoPage productInfoPage;

    @BeforeTest
    public void setUp()
    {
        driverFactory=new DriverFactory();
        prop=driverFactory.initiateProp();
        driver=driverFactory.initiateDriver(prop);
        loginPage=new LoginPage(driver);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}
