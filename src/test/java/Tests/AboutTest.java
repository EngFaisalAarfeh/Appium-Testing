package Tests;

import Pages.About;
import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutTest extends TestBase {

    About about = null;



    @Test
    public void testAboutScreenTitle() {
     about = new About(driver);
     about.goToAboutScreen();
        Assert.assertEquals(about.getScreenTitle().trim(), "About", "About Screen Title");

    }
}
