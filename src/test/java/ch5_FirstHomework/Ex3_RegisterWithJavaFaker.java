package ch5_FirstHomework;

import ch3_TestBase.TestBase;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class Ex3_RegisterWithJavaFaker extends TestBase {

    @Test
    public void shouldRegisterNewUser() {
        driver.get("http://146.59.32.4/index.php");

        Faker faker = new Faker();

        
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();



        driver.findElement(By.cssSelector(".user-info a")).click();

        driver.findElement(By.cssSelector(".no-account")).click();

        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#customer-form [name='email']")).sendKeys(getRandomEmail());
        driver.findElement(By.name("password")).sendKeys("asdiujasiduhasd");

        driver.findElements(By.name("id_gender")).get(0).click();
        driver.findElement(By.name("customer_privacy")).click();
        driver.findElement(By.name("psgdpr")).click();

        driver.findElement(By.cssSelector(".form-footer button")).click();

        String userName = driver.findElement(By.cssSelector(".account")).getText();
        Assert.assertEquals(userName, firstName + " " + lastName);
    }

    private String getRandomEmail() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return fakeValuesService.bothify("????##@gmail.com");
    }

}
