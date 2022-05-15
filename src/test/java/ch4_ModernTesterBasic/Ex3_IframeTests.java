package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Ex3_IframeTests extends TestBase {

    @Test
    public void shouldFillFormsInIframes() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        System.out.println(driver.findElement(By.cssSelector("p[clas='lead']")).getText());

        driver.switchTo().frame("iframe1");
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Jan");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("j.w@wp.pl");

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.cssSelector("p[clas='lead']")).getText());
    }

}
