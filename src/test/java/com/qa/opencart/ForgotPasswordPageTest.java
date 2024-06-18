package com.qa.opencart;

import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ForgotPasswordPageTest extends BaseTest{

    @BeforeClass
    public void forgotPwdPageSetup()
    {
        forgotPasswordPage=loginPage.navigateToForgotPassword();
    }

    @Test
    public void forgotPwdPageTitleTest()
    {
        String actualTitle=forgotPasswordPage.getForgotPasswordPageTitle();
        Assert.assertEquals(actualTitle, Constants.FORGOT_PASSWORD_PAGE_TITLE);
    }

    @Test
    public void forgotPwdHeaderTextTest()
    {
        String actualText=forgotPasswordPage.getForgotPasswordPageHeaderText();
        Assert.assertEquals(actualText,Constants.FORGOT_PASSWORD_PAGE_HEADER_TEXT);
    }

    @Test
    public void emailIdTextBoxExistTest()
    {
        Assert.assertTrue(forgotPasswordPage.emailAddressBoxExist());
    }
}
