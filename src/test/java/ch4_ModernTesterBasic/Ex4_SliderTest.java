package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ex4_SliderTest extends TestBase {

    @Test
    public void shouldMoveSlider() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        WebElement handle = driver.findElement(By.cssSelector("#custom-handle"));
        handle.sendKeys(Keys.ARROW_RIGHT);
    }

}
