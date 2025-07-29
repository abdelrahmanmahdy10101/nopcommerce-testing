package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homepage;
import pages.loginassertionpage;
import pages.loginpage;

public class whitlisttest1 {
    ChromeDriver driver;
    homepage hp;
    loginpage log;
    loginassertionpage assertpage;

    @Given("the user is on the homepage")
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        hp = new homepage(driver);
        log = new loginpage(driver);
        assertpage = new loginassertionpage(driver);
    }





    @When("the user click add {string} to the wishlist")
    public void theUserClickAddToTheWishlist(String arg0) {
        hp.useraddwhitlist();
    }

    @And("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
    }


    @Then("a green success message {string} should appear")
    public void aGreenSuccessMessageShouldAppear(String arg0) {
        hp.appearmessage();
    }




}
