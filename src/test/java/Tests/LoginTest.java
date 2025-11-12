package Tests;

import Pages.Login;
import Pages.Menu;
import Utilities.TestBase;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    Login login = null;
    Menu menu = null;
    @BeforeMethod
            public void setUp(){
        login = new Login(driver);
        menu = new Menu(driver);            }



    @Test(priority = 1)
    public void loginTestLockedOut(){
        login.loginForm("alice@example.com", "correctpassword", true);
        Assert.assertEquals(login.getErrorMessage(), "Sorry this user has been locked out.");
    }

     Utilities utils = new Utilities();
    @Test(priority = 2)
    public void validLoginloginTest(){
        login.loginForm("Faisal", "Faisal123", false);

        utils.sleep(5000);
    }






}
