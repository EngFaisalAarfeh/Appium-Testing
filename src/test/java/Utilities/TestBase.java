package Utilities;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class TestBase {

   protected AppiumDriver driver;
  //  String url = JSONReader.getValue("config.json","url");
    String SAUCE_USERNAME = "Your User Name";
    String SAUCE_ACCESS_KEY = "Your Access Key";
    String SAUCE_URL = String.format("https://%s:%s@ondemand.eu-central-1.saucelabs.com:443/wd/hub", SAUCE_USERNAME, SAUCE_ACCESS_KEY); // make sure you are on the correct data center
    URL appiumServerUrl = null;

    @Parameters("platform")
    @BeforeClass(alwaysRun = true)
    public void setup(@Optional("android") String platform) {

        if (platform.equalsIgnoreCase("Android")){

            try {
                appiumServerUrl = new URL("http://127.0.0.1:4723/"); // step-1
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            String fileSeparator = File.separator;
            String ProjectPath = System.getProperty("user.dir");


            // Step-2
            UiAutomator2Options options = new UiAutomator2Options();
            options.setApp(ProjectPath+fileSeparator+"src"+fileSeparator+"main"+fileSeparator+"resources"+fileSeparator+"mda-2.2.0-25.apk");
            options.setAppPackage("com.saucelabs.mydemoapp.android");
            options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
            options.setDeviceName("07574251AS009058");
            options.setUdid("emulator-5554");
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setNewCommandTimeout(Duration.ofSeconds(60));

            driver = new AndroidDriver(appiumServerUrl, options);


        } else if (platform.equalsIgnoreCase("iOS")){
            try {
                appiumServerUrl = new URL(SAUCE_URL);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }


            XCUITestOptions options = new XCUITestOptions();
            options.setPlatformName("iOS");
            options.setAutomationName("XCUITest");
            options.setDeviceName("iPhone 15");
            options.setApp("storage:Use Your App ID");
            options.setIncludeSafariInWebviews(true);

            options.setCapability("sauce:options", new java.util.HashMap<String, Object>() {
                {
                    put("name", "iOS MyDemoApp Login Verification (Sauce)");
                    put("appiumVersion", "appium2-20250901");
                }
            });

            options.setNewCommandTimeout(Duration.ofSeconds(60));
            driver = new IOSDriver(appiumServerUrl, options);
        }
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }




    @AfterClass(alwaysRun = true)
    public void teardown() {

        if (driver != null) {

            driver.quit();
        }
    }


 public void click(WebElement element){
        waitElementToBeVisible(element);
        element.click();
 }
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    protected void selectByVisibleText(WebElement element, String visibleText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

 public String getText(WebElement element){
        waitElementToBeVisible(element);
        return element.getText();
 }

 public boolean isDisplayed(WebElement element){
        waitElementToBeVisible(element);
        return element.isDisplayed();
 }

    public void selectFromDropdown(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
    }

    public void click(WebElement element, String Message){
        waitElementToBeVisible(element);
        element.click();

        if (ExtentManager.getTest()!=null) {
            ExtentManager.getTest().log(Status.INFO, "Clicked On: "+Message);}
    }

    Utilities utils = new Utilities();

public void sendKey(WebElement element, String text){
    waitElementToBeVisible(element);
    element.clear();
    element.sendKeys(text);
}

    protected void waitElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }



    // for Windows
    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }


    // for Mac. Update the paths
    public AppiumDriverLocalService getAppiumService() {
        HashMap<String, String> environment = new HashMap<String, String>();
        environment.put("PATH", "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:/Users/faisal.ar/Library/Android/sdk/tools:/Users/faisal.ar/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "/Users/faisal.ar/Library/Android/sdk");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//           .withArgument(() -> "--allow-insecure","chromedriver_autodownload")
                .withEnvironment(environment)
                .withLogFile(new File("ServerLogs/server.log")));
    }
    private static AppiumDriverLocalService server;

   @BeforeSuite
    public void beforeSuite() throws Exception, Exception {
//     server = getAppiumService(); // For Mac.
        server = getAppiumServerDefault(); // -> For Windows.
        if(!checkIfAppiumServerIsRunnning(4723)) {
            server.start();
            server.clearOutPutStreams(); // -> Comment this if you want to see server logs in the console log4j
        } else {
        }
    }


    public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
        boolean isAppiumServerRunning = false;
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
            socket.close();
        } catch (IOException e) {
            System.out.println("1");
            isAppiumServerRunning = true;
        } finally {
            socket = null;
        }
        return isAppiumServerRunning;
    }

}


