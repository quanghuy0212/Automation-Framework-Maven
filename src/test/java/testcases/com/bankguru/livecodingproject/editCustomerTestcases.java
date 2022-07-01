package testcases.com.bankguru.livecodingproject;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.bankguru.EditCustomerPO;
import pageObjects.bankguru.HomePagePO;
import pageObjects.bankguru.LoginPO;
import pageObjects.bankguru.NewCustomerPO;
import pageObjects.bankguru.PageGenerator;
import pageObjects.bankguru.RegisterPO;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class editCustomerTestcases extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        driver.manage().window().maximize();
//        urlPage = "http://demo.guru99.com/V4";
        emailRegister = getRandomEmail();

        loginPage = PageGenerator.getLoginPage(driver);
    }

    @Test
    public void TC_01_Create_New_Customer_And_Checked_Created_Succesfully(Method method) {

        ExtentTestManager.startTest(method.getName(),"Test 01");
        ExtentTestManager.getTest().log(LogStatus.INFO,"Test 02");
        loginPage.clickToHereLinkToGetAccount(driver);
        registerPage = PageGenerator.getRegisterPage(driver);

        log.info("Input Email To Textbox");
        registerPage.inputEmailToTextBox(driver, "emailid", emailRegister);

        log.info("Click to Submit button");
        registerPage.clickToSubmitButton(driver, "btnLogin");

        log.info("Get Attribute UserID ");
        userID = registerPage.getTextUserIDOnTable(driver);

        log.info("Get Attribute Password");
        password = registerPage.getPasswordOnTable(driver);

        ExtentTestManager.endTest();

    }


    public WebDriver getWebDriver() {
        return this.driver;
    }

    @Parameters({"browser"})
    @AfterClass(alwaysRun = false)
    public void cleanBrowser(String browserName) {
        log.info("Post-Condition: Close browser" + browserName + "");
        closeBrowserAndDriver();
    }

    String userID, password, urlPage, emailRegister, customerID;

    WebDriver driver;
    LoginPO loginPage;
    HomePagePO homePage;
    RegisterPO registerPage;

}
