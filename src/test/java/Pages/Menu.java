package Pages;

import Utilities.TestBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu extends TestBase {


    // Step-1
    public Menu(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Mobile

    }

     @CacheLookup
     @AndroidFindBy(accessibility = "View menu")
     @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
     WebElement menu;


     @AndroidFindBy(uiAutomator = "new UiSelector().text(\"About\")")
     @iOSXCUITFindBy(accessibility = "About-menu-item")
     WebElement about;


     @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log In\")")
     @iOSXCUITFindBy(iOSClassChain = "Login Button")
     WebElement login;

   public void clickMenu() {
     //  menu.click();// bad code
       click(menu);

   }

   public void clickAbout() {
       click(about);
   }

   public void clickLogin() {
       click(login);
   }

   public void goToLoginScreen() {
       clickMenu();
       clickLogin();
   }






}
