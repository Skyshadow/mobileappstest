import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITest;
import org.testng.ITestContext;

public class StoreStartPage {

    public AndroidDriver<AndroidElement> driver;
    public FluentWait<WebDriver> wait;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GRY']")
    private MobileElement gamesButton;

    public StoreStartPage(ITestContext context)
    {
        this.driver = (AndroidDriver<AndroidElement>) context.getAttribute("driver");
        this.wait = (FluentWait) context.getAttribute("wait");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void FindButton(String buttonName)
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElementByXPath("//android.widget.TextView[@text='"+buttonName+"']")));
        MobileElement element = this.driver.findElementByXPath("//android.widget.TextView[@text='"+buttonName+"']");
        element.click();
    }

    public void SearchInputValue(String xPathInputName, String value)
    {
        //this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElementByAccessibilityId("com.android.vending:id/text_container")));
        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElementByXPath("//android.widget.TextView[@text='"+xPathInputName+"']")));
        MobileElement element = this.driver.findElementByAccessibilityId("com.android.vending:id/text_container");
        element.clear();
        element.click();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }


    public boolean isDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(gamesButton));
        return true;
    }

}
