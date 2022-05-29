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

    @FindBy(css = "#inputLastName3")
    private WebElement lastName;

    @FindBy(css = "#inputEmail3")
    private WebElement email;

    @FindBy(css = "#inputAge3")
    private WebElement age;

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }
    public void setAge(String age) {
        this.age.sendKeys(age);
    }

}
