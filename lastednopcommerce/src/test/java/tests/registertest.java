package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.assertionpage;
import pages.homepage;
import pages.registerpage;

public class registertest {
    ChromeDriver driver;
    homepage home;
    registerpage reg;
    assertionpage assertpage;

    @Given("User is on the NopCommerce homepage")
    public void user_is_on_homepage() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        home = new homepage(driver);
        reg = new registerpage(driver);
        assertpage = new assertionpage(driver);
    }

    @When("User navigates to the Register page")
    public void user_navigates_to_register_page() {
        home.navigatetoreg();
    }

    @And("User selects gender {string}")
    public void user_selects_gender(String gender) {
        reg.selectgender(); // Only male implemented
    }

    @And("User enters first name {string} and last name {string}")
    public void user_enters_first_and_last_name(String fname, String lname) {
        reg.enterfirstandlastname(fname, lname);
    }

    @And("User enters Date of Birth {string}, {string}, {string}")
    public void user_enters_dob(String day, String month, String year) {
        // Implement if needed
    }

    @And("User enters email {string}")
    public void user_enters_email(String email) {
        reg.enteremail(email);
    }

    @And("User enters password {string} and confirms it")
    public void user_enters_password_and_confirms(String pass) {
        reg.enterpassword(pass, pass);
    }

    @And("User clicks the Register button")
    public void user_clicks_register_button() {
        reg.clickregister();
    }

    @Then("A success message should be displayed")
    public void success_message_displayed() {
        assertpage.successmessage();
    }

    @And("The message text should be {string}")
    public void message_text_should_be(String expectedText) {
        assertpage.assertbytestmessage();
    }

    @And("The message color should be {string}")
    public void message_color_should_be(String expectedColor) {
        assertpage.assertbycolor();
    }

//    @After
//    public void close() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }
}
