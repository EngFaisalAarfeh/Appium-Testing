package Tests;

import Pages.Cart;
import Pages.Checkout;
import Pages.Login;
import Pages.Products;
import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends TestBase {


    Login login;
    Products products;
    Cart cart;
    Checkout checkout;
    @Test
    public void testProducts_fullFlow() {
        login = new Login(driver);
        products = new Products(driver);
        cart = new Cart(driver);
        checkout = new Checkout(driver);

        login.loginForm("Faisal", "Pass", true);
        products.addProductCartButton("Sauce Labs Backpack");
        cart.goToCartThenCheckoutScreen();
        checkout.checkout("Faisal Arafeh","Amman St", "Amman",
                "546", "Jordan", "123456789012",
                "12/26", "123");

        Assert.assertEquals(checkout.getThankYouMessage(), "Thank you for your order");
        //Assert.assertEquals(checkout.thankYouMessage_.getText(), "Thank you for your order");

    }


}
