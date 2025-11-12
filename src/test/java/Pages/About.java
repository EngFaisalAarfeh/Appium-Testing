package Pages;

import Utilities.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class About extends TestBase {

    public About(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Mobile
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"About \"`]")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/aboutTV")
    WebElement screenTitle;


    @iOSXCUITFindBy(accessibility = "About")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/versionTV")
    WebElement build;

    public String getScreenTitle() {
       return getText(screenTitle);
       // return screenTitle.getText();
    }

    public String getBuild() {
        return build.getText();
    }

    Menu menu;

    public void goToAboutScreen() {
        menu = new Menu(driver);
        menu.clickMenu();
        menu.clickAbout();




    }









}
