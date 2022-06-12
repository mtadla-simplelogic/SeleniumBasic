package ch8_scroll;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex2_DataProviderWith2Params extends TestBase {
    @DataProvider(name = "user-names-provider")
    public Object[][] getParameters() {
        return new Object[][]{
                {"Jan", "Kowalski"},
                {"Adam", "Nowak"},
                {"Piotr", "Nowak"},
                {"Mateusz", "Nowak"},
                {"Iza", "Mazur"},
                {"Kamila", "Nowak"}
        };
    }

    @Test(dataProvider = "user-names-provider")
    public void shouldFillFormWithSuccess(String firstName, String lastName) {
        driver.get("https://seleniumui.moderntester.pl/short-form.html?");

        driver.findElement(By.id("inputFirstName3")).sendKeys(firstName);
        driver.findElement(By.id("inputSurname3")).sendKeys(lastName);
    }

}
