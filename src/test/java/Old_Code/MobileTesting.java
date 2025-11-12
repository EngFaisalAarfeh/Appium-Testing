package Old_Code;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class MobileTesting {

    AppiumDriver driver = null;

    @Test
    public void aboutTestMobileAndroid() {
        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL("http://127.0.0.1:4723/"); // step-1
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
            String fileSeparator= File.separator;
        // Step-2
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("C:"+fileSeparator+"Users"+fileSeparator+"enghi"+fileSeparator+"IdeaProjects\\Appium-Testing\\src\\main\\resources\\mda-2.2.0-25.apk");
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        options.setDeviceName("07574251AS009058");
        options.setUdid("07574251AS009058");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        driver = new AndroidDriver(appiumServerUrl, options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.findElement(AppiumBy.accessibilityId("View menu")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"About\")")).click();

        String screenTitle = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/aboutTV")).getText();

        System.out.println("Screen Title: " + screenTitle);

        Assert.assertEquals(screenTitle, "About", "Screen title");
    }

    @Test
    public void aboutTestMobileIOS() throws InterruptedException {
        String SAUCE_USERNAME = "faisal_Arafeh";
        String SAUCE_ACCESS_KEY = "9498ec77-eac7-46b2-b7b6-79079682f720";

        String SAUCE_URL = String.format("https://%s:%s@ondemand.eu-central-1.saucelabs.com:443/wd/hub", SAUCE_USERNAME, SAUCE_ACCESS_KEY);

        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL(SAUCE_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iOS");
        options.setAutomationName("XCUITest");
        options.setDeviceName("iPhone 15");
        options.setApp("storage:dea3199e-edae-477e-81fb-4ee2074bd749");
        options.setIncludeSafariInWebviews(true);


        options.setCapability("sauce:options", new java.util.HashMap<String, Object>() {
            {
                put("name", "iOS MyDemoApp Login Verification (Sauce)");
                put("appiumVersion", "appium2-20250901");
            }
        });

        options.setNewCommandTimeout(Duration.ofSeconds(60));
        driver = new IOSDriver(appiumServerUrl, options);

        Thread.sleep(5000);

        //driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"About\")")).click();

        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")).click();
        driver.findElement(AppiumBy.accessibilityId("About-menu-item")).click();
        String screenTitle = driver.findElement(AppiumBy.iOSNsPredicateString("name == \"About \"")).getText();

        System.out.println("Screen Title: " + screenTitle);

        Assert.assertEquals(screenTitle.trim(), "About", "Screen title");
    }



    @Test
    public void loginTest() {

        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL("http://127.0.0.1:4723/"); // step-1
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Step-2
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("C:\\Apps\\mda-2.2.0-25.apk");
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        options.setDeviceName("07574251AS009058");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        driver = new AndroidDriver(appiumServerUrl, options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("View menu")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")")).click();
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("Faisal");

        driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET"))
                .sendKeys("Faisal123");

        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"View menu\"]")).click();

        String logutbuttonvalue = driver.findElement(AppiumBy.accessibilityId("Logout Menu Item")).getText();
        String packageAttributeValue =
                driver.findElement(AppiumBy.accessibilityId("Logout Menu Item")).getAttribute("package");

        System.out.println("Package Attribute Value: " + packageAttributeValue);


        String content_descAttributeValue = driver.findElement(AppiumBy.accessibilityId("Logout Menu Item")).getAttribute("content-desc");

        System.out.println("Content Desc Attribute Value: " + content_descAttributeValue);


        String resourceIDdValue = driver.findElement(AppiumBy.accessibilityId("Logout Menu Item")).getAttribute("resource-id");


        System.out.println("Content Desc Attribute Value: " + content_descAttributeValue);


        Assert.assertEquals(logutbuttonvalue, "Log Out");
        Assert.assertEquals(resourceIDdValue, "com.saucelabs.mydemoapp.android:id/itemTV");

    }


    @Test
    public void loginTestkeyboard() throws InterruptedException {

        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL("http://127.0.0.1:4723/"); // step-1
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Step-2
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("C:\\Apps\\mda-2.2.0-25.apk");
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        options.setDeviceName("07574251AS009058");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.autoGrantPermissions();
        options.fullReset();
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        driver = new AndroidDriver(appiumServerUrl, options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("View menu")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")")).click();
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).click();

        Thread.sleep(3000);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(30000);

    }

    @Test
    public void scrollToElement() throws InterruptedException {

        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL("http://127.0.0.1:4723/"); // step-1
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Step-2
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("src/main/resources/mda-2.2.0-25.apk");
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        //options.setDeviceName("10.70.1.20:5555");
        options.setDeviceName("emulator-5554");
        options.setUdid("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.autoGrantPermissions();
      //  options.fullReset();
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        driver = new AndroidDriver(appiumServerUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("View menu")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")")).click();
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("Faisal");

        driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET"))
                .sendKeys("Faisal123");

        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        scrollToTextContains("Bike");
        Thread.sleep(5000);
    }

    public void scrollToTextContains(String partialText) {


        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + partialText + "\"));"
        ));
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
//				.withArgument(() -> "--allow-insecure","chromedriver_autodownload")
                .withEnvironment(environment)
                .withLogFile(new File("ServerLogs/server.log")));
    }


    private static AppiumDriverLocalService server;

   // @BeforeSuite
    public void beforeSuite() throws Exception, Exception {
//		server = getAppiumService(); // For Mac.
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