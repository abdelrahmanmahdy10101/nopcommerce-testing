package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class registerpage {
    ChromeDriver drive;
    private By male = By.id("gender-male");
    private By fnam = By.id("FirstName");
    private By lnam = By.id("LastName");
    private By emailid = By.id("Email");
    private By passvar = By.id("Password");
    private By confpassvar = By.id("ConfirmPassword");
    public registerpage(ChromeDriver d) {
        this.drive = d;
    }

    public void selectgender() {
        drive.findElement(male).click();
    }

    public void enterfirstandlastname(String fname, String lname) {
        drive.findElement(fnam).sendKeys(fname);
        drive.findElement(lnam).sendKeys(lname);
    }

    public void enteremail(String email) {
        drive.findElement(emailid).sendKeys(email);
    }

    public void enterpassword(String pass,String confpass) {
        drive.findElement(passvar).sendKeys(pass);
        drive.findElement(confpassvar).sendKeys(confpass);
    }
public void clickregister() {
        drive.findElement(By.id("register-button")).click();
    }


}
