package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex2_AlertsTests extends TestBase {

    @BeforeMethod
    public void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void shouldAcceptAlert(){
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();

        String msg = driver.findElement(By.cssSelector("#simple-alert-label")).getText();
        Assert.assertEquals(msg, "OK button pressed");
    }
}
