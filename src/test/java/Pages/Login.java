package Pages;

import Utilities.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class Login extends TestBase {

    public Login(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Mobile
    }


    Menu menu = null;



    @iOSXCUITFindBy(iOSClassChain = "iOS locator...etc")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    WebElement userName;



    @iOSXCUITFindBy(iOSClassChain = "iOS locator...etc")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/passwordET\")")
    WebElement password;




    @iOSXCUITFindBy(iOSClassChain = "iOS locator...etc")
    @AndroidFindBy(accessibility = "Tap to login with given credentials")
    WebElement loginBtn;


    @CacheLookup
    @iOSXCUITFindBy(iOSClassChain = "iOS locator...etc")
    @AndroidFindBy(xpath =
            "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordErrorTV\"]")
   WebElement errorMessage;


    public String getErrorMessage(){
        return getText(errorMessage);
    }

    private void enterUsername(String userName){
        sendKey(this.userName, userName);
    }


    private void enterPassword(String password){
        sendKey(this.password, password);
    }

    private void tapLoginBtn(){
        click(loginBtn);
    }



    public void loginForm(String userName, String password, boolean nav){
        if (nav){
            menu = new Menu(driver);
            menu.goToLoginScreen();
        }

        enterUsername(userName);
        enterPassword(password);
        tapLoginBtn();

    }








}
