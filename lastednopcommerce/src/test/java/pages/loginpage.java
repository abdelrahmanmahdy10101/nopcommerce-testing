package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginpage {
    ChromeDriver drive;


    public loginpage(ChromeDriver d) {
        this.drive = d;
    }
    private By emails = By.id("Email");
    private By passvar = By.id("Password");
    private By loginbtn = By.xpath("//button[@class='button-1 login-button']");

    public void validemailandpassword(String email,String pass){
        drive.findElement(emails).sendKeys(email);

        drive.findElement(passvar).sendKeys(pass);
    }

    public void invalidemailandpassword(String email,String pass){
        drive.findElement(emails).sendKeys(email);

        drive.findElement(passvar).sendKeys(pass);
    }


    public void clicklogin(){
        drive.findElement(loginbtn).click();
        // Add a small wait to ensure page loads
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }





}
