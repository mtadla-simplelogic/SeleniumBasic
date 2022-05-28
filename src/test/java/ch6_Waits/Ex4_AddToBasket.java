package ch6_Waits;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex4_AddToBasket extends TestBase {

    @Test
    public void shouldAddProductToBasket(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product");

        driver.findElement(By.cssSelector(".add-to-cart")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal-content .btn-primary")))
                .click();

        driver.findElement(By.cssSelector(".remove-from-cart")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".remove-from-cart")));

        String emptyBasketText = driver.findElement(By.cssSelector(".no-items")).getText();
        Assert.assertEquals(emptyBasketText, "There are no more items in your cart");
    }
}
