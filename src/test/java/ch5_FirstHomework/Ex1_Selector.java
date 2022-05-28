package ch5_FirstHomework;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Ex1_Selector extends TestBase {

    @Test
    public void shouldFind7PriceElements(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElements(By.cssSelector("#homefeatured .right-block .price"));
    }
}
