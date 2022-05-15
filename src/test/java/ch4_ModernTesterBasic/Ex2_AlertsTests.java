package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.Alert;
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
    public void shouldAcceptAlert() {
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();

        String msg = driver.findElement(By.cssSelector("#simple-alert-label")).getText();
        Assert.assertEquals(msg, "OK button pressed");
    }


    @Test
    public void shouldAcceptPromptAlert() {
        driver.findElement(By.cssSelector("#prompt-alert")).click();

        String name = "Jan";
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();

        String promptAlertMsg = driver.findElement(By.cssSelector("#prompt-label")).getText();
        Assert.assertEquals(promptAlertMsg, "Hello " + name + "! How are you today?");
    }

    @Test
    public void shouldAcceptPromptAlert2() {
        driver.findElement(By.cssSelector("#prompt-alert")).click();

        driver.switchTo().alert().sendKeys("Jan");
        driver.switchTo().alert().accept();

        String promptAlertMsg = driver.findElement(By.cssSelector("#prompt-label")).getText();
        Assert.assertEquals(promptAlertMsg, "Hello Jan! How are you today?");
    }

    @Test
    public void shouldDismissAlert() {
        driver.findElement(By.cssSelector("#confirm-alert")).click();

        driver.switchTo().alert().dismiss();

        String promptAlertMsg = driver.findElement(By.cssSelector("#confirm-label")).getText();
        Assert.assertEquals(promptAlertMsg, "You pressed Cancel!");
    }
}
