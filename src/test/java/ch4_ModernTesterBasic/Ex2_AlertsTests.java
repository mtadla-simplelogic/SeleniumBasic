package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.testng.annotations.BeforeMethod;

public class Ex2_AlertsTests extends TestBase {

    @BeforeMethod
    public void testSetup(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }




}
