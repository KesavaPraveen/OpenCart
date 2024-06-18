package com.qa.opencart;


import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitleTest()
    {
        Assert.assertEquals(loginPage.getLoginPageTitle(),
                Constants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void loginPageUrlTest()
    {
        Assert.assertEquals(loginPage.getLoginPageUrl(),
                "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }

    @Test
    public void forgotPasswordLinkTest()
    {
        Assert.assertTrue(loginPage.forgotPasswordLinkExist());
    }

    /*
        Negative Test Scenario
     */
    @Test
    public void invalidLoginTest()
    {
        Assert.assertEquals(loginPage.invalidLogin("dummy@dummy.com","1234"),
                "Warning: No match for E-Mail Address and/or Password.");
    }
}
