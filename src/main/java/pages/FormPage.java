package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstName;

    // 3 pola: lastName, email, age
    // 3 metody: setLastName, setEmail, setAge
    // dopisac uzycie tych 3 metod w teście

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }
}
