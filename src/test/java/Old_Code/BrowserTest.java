package Old_Code;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserTest {


    @Test
    public void testGoogle() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();  // Step-1

        // Step-2
        options.setPlatformName("Android");
        options.setDeviceName("10.70.1.20:4444");
        options.withBrowserName("Chrome");
        options.setChromedriverExecutable("C:/Users/enghi/IdeaProjects/Appium-Testing/src/main/resources/chromedriver.exe");

        URL appiumServer = new URL("http://127.0.0.1:4723/"); // Step-3

        AndroidDriver driver = new AndroidDriver(appiumServer, options); // Step-4

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement appLogo = driver.findElement(By.className("app_logo"));
        Assert.assertEquals(appLogo.getText(),"Swag Labs", "Logo Text Assertion");

        Thread.sleep(10000);
    }






}
