package ch8_scroll;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex2_DataProviderWith1Param extends TestBase {
    @DataProvider(name = "user--simple-names-provider")
    public Object[][]  getSimpleParameters(){
        return new Object[][]  {
                {"Jan"},
                {"Adam"},
                {"Piotr"},
                {"Mateusz"}
        };
    }

    @Test(dataProvider = "user--simple-names-provider")
    public void shouldFillSimpleFormWithSuccess(String firstName) {
        driver.get("https://seleniumui.moderntester.pl/short-form.html?");

        driver.findElement(By.id("inputFirstName3")).sendKeys(firstName);
    }
}
