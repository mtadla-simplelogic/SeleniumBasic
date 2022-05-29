package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

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

    @FindBy(css = "#validator-message")
    private WebElement validationMsg;

    @FindBy(css = "#selectContinents")
    private WebElement selectContinents;
    @FindBy(css = "#chooseFile")
    private WebElement fileInput;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> genders;


    // obsl listy lat dośw.
    // obsl profession
    // obsl selekt selenium commands
    // obsl uploadu pliku
    // obsl przycisku SignIn
    //
    // obs = WebElement + metoda -> uzycie w teście
    // spodziewany rezultat -> test przechodzi na zielono


    public void uploadFile(File file){
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void selectContinent(String continent){
        new Select(selectContinents).selectByValue(continent);
    }

    public void selectRandomGender(){
        getRandomElement(genders).click();
    }

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

    public String getValidationMsg(){
        return validationMsg.getText();
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        return elements.get(randomListIndex);
    }
}
