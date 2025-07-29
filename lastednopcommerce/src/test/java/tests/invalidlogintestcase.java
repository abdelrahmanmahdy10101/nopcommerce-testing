package tests;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homepage;
import pages.loginassertionpage;
import pages.loginpage;

public class invalidlogintestcase {
    ChromeDriver driver;
    homepage hp;
    loginpage log;
    loginassertionpage assertpage;

   @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        hp = new homepage(driver);
        log = new loginpage(driver);
        assertpage = new loginassertionpage(driver);
    }


    @Given("the user goes to the Login page")
    public void theUserGoesToTheLoginPage() {
        hp.navtologinpage();
    }


    @When("the user enters invalid email {string} and password {string}")
    public void theUserEntersInvalidEmailAndPassword(String arg0, String arg1) {
        log.invalidemailandpassword(arg0, arg1);
    }

    @And("the user click the Login buttom")
    public void theUserClickTheLoginButtom() {
        log.clicklogin();
    }


    @Then("the user should see an error message containing {string}")
    public void theUserShouldSeeAnErrorMessageContaining(String arg0) {
assertpage.checkLoginErrorMessage(arg0);
    }


    @And("the error message color should be {string}")
    public void theErrorMessageColorShouldBe(String arg0) {
        assertpage.checkErrorMessageColor(arg0);
    }
}
