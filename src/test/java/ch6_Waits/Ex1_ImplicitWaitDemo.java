package ch6_Waits;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex1_ImplicitWaitDemo extends TestBase {

    @Test
    public void firstWaitDemo(){
        driver.get("https://seleniumui.moderntester.pl/form.php");

        driver.findElement(By.cssSelector("iuhqwdiuhqwdiuqhwd"));
    }

    @Test
    public void secondWaitDemo(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://seleniumui.moderntester.pl/form.php");

        driver.findElement(By.cssSelector("iuhqwdiuhqwdiuqhwd"));
    }
}
