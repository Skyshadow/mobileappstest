import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

@Epic("Google apps")
@Feature("Play Store")
public class AppiumTest {

    public AndroidDriver<AndroidElement> driver;
    public FluentWait<WebDriver> wait;
    public DesiredCapabilities capabilities;


    //@Test
    public void testName(ITestContext context) throws MalformedURLException {

        capabilities = new DesiredCapabilities();
        //capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "6.0");
        capabilities.setCapability("deviceName", "HUJAWEJ Y6 II");
        capabilities.setCapability("udid","LHTDU16707008225");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("appPackage", "com.android.calculator2");
        //capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        // Google App Store
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName", "UiAutomator");
        capabilities.setCapability("newCommandTimeout", 90000);
        capabilities.setCapability("androidInstallTimeout", 90000);




        this.driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4730/wd/hub"), capabilities);

        this.wait = new WebDriverWait(driver, 50)
        .ignoring(StaleElementReferenceException.class)
        .ignoring(NullPointerException.class)
        .ignoring(ClassCastException.class)
        .ignoring(NoSuchElementException.class);

        context.setAttribute("driver", this.driver);
        context.setAttribute("wait", this.wait);

        //AndroidElement button8 = this.driver.findElementById("com.android.calculator2:id/digit8");

        //this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElementById("com.android.calculator2:id/digit8")));

        //calculator is disabled
        //SumOfDigits(4, 3);

        StoreStartPage storeStartPage = new StoreStartPage(context);
        storeStartPage.isDisplayed();

        //storeStartPage.SearchInputValue("myInputName", "Dragon");
        storeStartPage.FindButton("GRY");


    }

    private int SumOfDigits(int firstDigit, int secoundDigit)
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElementById("com.android.calculator2:id/digit"+firstDigit)));
        AndroidElement firstButton = this.driver.findElementById("com.android.calculator2:id/digit"+firstDigit);
        AndroidElement secoundButton = this.driver.findElementById("com.android.calculator2:id/digit"+secoundDigit);
        AndroidElement plusButton = this.driver.findElementById("com.android.calculator2:id/plus");
        AndroidElement sumButton = this.driver.findElementById("com.android.calculator2:id/equal");

        firstButton.click();
        plusButton.click();
        secoundButton.click();
        sumButton.click();

        int summary = firstDigit+secoundDigit;

        return summary;
    }

    @Test (groups={"smoke", "regression"})
    @Story("Fake smoke Test")
    public void smokeTest()
    {
        System.out.println("Hello Smoke");
    }

    @Test (groups={"regression"})
    @Story("Fake regression test")
    @Description("This test is empty")
    public void regressionTest()
    {
        System.out.println("Regression Test");
    }



}
