package Pages;

import Utilities.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Products extends TestBase {

    public Products(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Mobile
    }

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(0)")
    WebElement sauceLabsBackpack;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sauce Labs Backpack (green)\")")
    WebElement sauceLabsBackpack_green;

    @iOSXCUITFindBy(iOSClassChain = "iOS ")
    @AndroidFindBy(accessibility = "Tap to add product to cart")
    WebElement addToCartButton;


    public void addProductCartButton(String product){

        if (product.equalsIgnoreCase("Sauce Labs Backpack")) {
            click(sauceLabsBackpack);
        }else if (product.equalsIgnoreCase("Sauce Labs Backpack (green)")) {
            click(sauceLabsBackpack_green);
        }else {
            System.out.println("Invalid product name");
            throw new RuntimeException("Invalid product name");
        }

        click(addToCartButton);

    }








}
