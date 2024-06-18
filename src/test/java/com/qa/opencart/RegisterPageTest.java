package com.qa.opencart;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.FakerUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterPageTest extends BaseTest{

    @BeforeClass
    public void regPageSetUp()
    {
        registerPage=loginPage.navigateToRegisterPage();
    }

    @Test
    public void registerPageTitleTest()
    {
        String actualTitle=registerPage.getRegisterPageTitle();
        Assert.assertEquals(actualTitle,Constants.REGISTER_PAGE_TITLE);
    }

    @Test
    public void registerPageHeaderTextTest()
    {
        Assert.assertEquals(registerPage.getRegisterAccountHeaderText(),Constants.REGISTER_PAGE_HEADER_TEXT);
    }

    @Test
    public void registerPageHeaderLabelsTest()
    {
        List<String> actualFieldSetHeaderList=registerPage.getFieldSetHeaderTextList();
        Assert.assertEquals(actualFieldSetHeaderList,Constants.REGISTER_PAGE_FIELDSET_HEADERS_TEXT_LIST);
    }

    @Test
    public void registerPageLinkTest()
    {
        Assert.assertTrue(registerPage.loginPageHyperLinkExist());
    }
    @Test
    public void registerPageWebElementsTest()
    {
        Assert.assertTrue(registerPage.yesRadioButtonExist());
        Assert.assertTrue(registerPage.noRadioButtonExist());
        Assert.assertTrue(registerPage.agreeCheckBoxExist());
    }

    @Test
    public void registerPageWebElementsLabelsTest()
    {
        List<String> actualLabelTextList=registerPage.getLabelElementsText();
        Assert.assertEquals(actualLabelTextList,Constants.REGISTER_PAGE_LABELS_TEXT_LIST);
    }

    @DataProvider
    public Object[][] getUserData()
    {
        return new Object[][]{
                {FakerUtil.generateFirstName(),FakerUtil.generateLastName(),
                FakerUtil.generateEmail(),FakerUtil.generateTelePhoneNumber(),
                        FakerUtil.generatePassword(),"yes"},
                {FakerUtil.generateFirstName(),FakerUtil.generateLastName(),
                FakerUtil.generateEmail(),FakerUtil.generateTelePhoneNumber(),
                        FakerUtil.generatePassword(),"no"}};

    }

    @Test(dataProvider ="getUserData")
    public void newUserRegisterTest(String fname,String lname,
                                    String email,String phone,
                                    String pass, String sub)
    {
        Assert.assertTrue(registerPage.newUserRegister(fname, lname, email,
                phone, pass,sub));
    }
}
