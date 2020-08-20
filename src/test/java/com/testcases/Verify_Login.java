package com.testcases;

import com.BasePage;
import data.LoginData;
import objects.Account;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Utils;

public class Verify_Login {
    WebDriver driver = null;
    Account account = new Account();
    LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void SetUp(@Optional("chrome") String browser) {
        BasePage basePage = new BasePage(driver);
        driver = basePage.setupDriver(browser);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 0, description = "Verify test case login")
    public void testLogin1() {
        Reporter.log("Read data from LoginData class");
        account.setEmail(LoginData.EMAIL);
        account.setPassword(LoginData.PASSWORD);
        account.setKeepMeSignIn(LoginData.KEEP_ME_SIGN_IN);

        loginPage.loginToAmazon(account);
        String title = loginPage.validateLoginPageTitle();
        Reporter.log("This test case is failed because it requires to approve from my mobile.");
        Assert.assertTrue(title.contains("Amazon"));
    }

    @Test(priority = 1, description = "Verify test case login")
    public void testLogin2() {
        Reporter.log("Read data from config.properties file");
        account = Utils.getAccount();
        loginPage.loginToAmazon(account);
        String title = loginPage.validateLoginPageTitle();
        Reporter.log("This test case is failed because it requires to approve from my mobile.");
        Assert.assertTrue(title.contains("Amazon"));
    }

    @AfterMethod
    public void tearDown(){
        loginPage.cleanUp();
    }
}
