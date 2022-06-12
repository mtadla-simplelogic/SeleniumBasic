package ch8_scroll;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex2_DataProviderWith4Params extends TestBase {
    @DataProvider(name = "form-provider")
    public Object[][] getParameters() {
        return new Object[][]{
                {"Jan", "Kowalski", 57, "europe"},
                {"Adam", "Kowalski", 32, "asia"},
                {"test", "test", 11, "asia"},
                {"Adam", "Koasdwalski", 22, "asia"},
                {"qweqwe", "qwe", 33, "asia"},
                {"Adsadasdam", "test", 32, "asia"},
                {"Darek", "Nowak", 42, "europe"},
                {"Mateusz", "Kowalski", 55, "europe"},
                {"Iza", "Mazur", 55, "europe"}
        };
    }

    @Test(dataProvider = "form-provider")
    public void shouldFillFormWithSuccess(String firstName, String lastName, int age, String continent) {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        driver.findElement(By.id("inputFirstName3")).sendKeys(firstName);
        driver.findElement(By.id("inputLastName3")).sendKeys(lastName);
        driver.findElement(By.id("inputAge3")).sendKeys(String.valueOf(age));
        new Select(driver.findElement(By.id("selectContinents"))).selectByValue(continent);
    }

}
