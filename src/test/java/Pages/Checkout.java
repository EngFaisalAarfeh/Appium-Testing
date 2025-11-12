package Pages;

import Utilities.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends TestBase {

    public Checkout(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Mobile
    }

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    WebElement fullName;



    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
    WebElement address;


    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
    WebElement city;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
    WebElement zipCode;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
    WebElement country;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    WebElement paymentBtn;


    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    WebElement fullName_2ndScreen;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
    WebElement cardNumber;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
    WebElement expirationDate;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
    WebElement securityCode;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(accessibility = "Completes the process of checkout")
    WebElement placeOrder;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    WebElement reviewOrderButton;

    @iOSXCUITFindBy(iOSClassChain = "iOS")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/thankYouTV")
    public WebElement thankYouMessage_;

public void checkout(String fullName,String address,String city,String zipCode, String country,
String cardNumber, String expirationDate, String securityCode){

    sendKey(this.fullName,fullName);
    sendKey(this.address,address);
    sendKey(this.city,city);
    sendKey(this.zipCode,zipCode);
    sendKey(this.country,country);
    click(paymentBtn);
    sendKey(fullName_2ndScreen, fullName);
    sendKey(this.cardNumber, cardNumber);
    sendKey(this.expirationDate, expirationDate);
    sendKey(this.securityCode, securityCode);
    click(reviewOrderButton);
    click(placeOrder);
}

public String getThankYouMessage() {
    return getText(thankYouMessage_);
}









}
