package Pages;

import Utilities.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Cart extends TestBase {

    public Cart(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Mobile
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"About \"`]")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    WebElement cartIcon;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"About \"`]")
    @AndroidFindBy(className = "android.widget.Button")
    WebElement goToCheckoutButton;


    public void goToCartThenCheckoutScreen() {
        click(cartIcon);
        click(goToCheckoutButton);
    }









}
