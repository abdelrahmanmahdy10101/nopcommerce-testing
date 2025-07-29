package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homepage;
import pages.loginassertionpage;
import pages.loginpage;

public class logintest {

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

   @Given("the user navigates to the login page")
   public void the_user_navigates_to_the_login_page() {
       hp.navtologinpage();
   }

   @When("the user enters a valid email {string} and password {string}")
   public void the_user_enters_a_valid_email_and_password(String email, String password) {
       log.validemailandpassword(email, password);
   }

   @And("the user clicks the login button")
   public void the_user_clicks_the_login_button() {
       log.clicklogin();
   }

   @Then("the current URL should be {string}")
   public void the_current_url_should_be(String expectedUrl) {
       assertpage.ensureurl(expectedUrl);
   }

   @And("the {string} tab should be displayed")
   public void the_tab_should_be_displayed(String tabName) {
       if (tabName.equalsIgnoreCase("MY ACCOUNT")) {
           assertpage.checkmyaccounttab();
       }
       assertpage.assertAll();
   }

   @After
   public void teardown() {
       driver.quit();
   }




}