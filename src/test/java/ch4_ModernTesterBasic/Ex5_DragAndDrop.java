package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex5_DragAndDrop extends TestBase {

    @Test
    public void shouldDragAndDropV1() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }
}
