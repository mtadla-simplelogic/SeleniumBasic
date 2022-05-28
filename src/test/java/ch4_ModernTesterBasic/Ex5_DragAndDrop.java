package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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

    @Test
    public void shouldDragAndDropV2() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(drag, drop)
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDropV3() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        int dragX = drag.getLocation().x;
        int dragY = drag.getLocation().y;

        int dropX = drop.getLocation().x;
        int dropY = drop.getLocation().y;

        int dropWidth = drop.getSize().width;
        int dropHeight = drop.getSize().height;

        int offsetX = dropX - dragX + dropWidth / 4;
        int offsetY = dropY - dragY + dropHeight / 4;

        Actions actions = new Actions(driver);

        actions.clickAndHold(drag)
                .moveByOffset(offsetX, offsetY)
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDropV4() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actionsBuilder = new Actions(driver);

        Action actionToPerform =
                actionsBuilder
                        .clickAndHold(drag)
                        .moveToElement(drop)
                        .release()
                        .build();

        actionToPerform.perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }
}
