package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex4_SliderTest extends TestBase {

    @Test
    public void shouldMoveSlider() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        Assert.assertEquals(getActualSliderValue(), 0);

        moveSliderTo(50);
        moveSliderTo(30);
        moveSliderTo(30);
        moveSliderTo(20);
        moveSliderTo(65);

    }

    private void moveSliderTo(int expectedValue) {
        if (expectedValue > getActualSliderValue()) {
            moveSlider(expectedValue, Keys.ARROW_RIGHT);
        } else if (expectedValue < getActualSliderValue()) {
            moveSlider(expectedValue, Keys.ARROW_LEFT);
        }
        Assert.assertEquals(getActualSliderValue(), expectedValue);
    }

    private void moveSlider(int expectedValue, Keys keys) {
        while (expectedValue != getActualSliderValue()) {
            getSliderHandle().sendKeys(keys);
        }
    }

    private int getActualSliderValue() {
        // "50" -> 50
        return Integer.parseInt(getSliderHandle().getText());
    }

    private WebElement getSliderHandle() {
        return driver.findElement(By.cssSelector("#custom-handle"));
    }
}
