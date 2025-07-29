package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.assertionpage;
import pages.homepage;
import pages.registerpage;

public class homeslideriphonetest2 {

    ChromeDriver driver;
    homepage home;
    registerpage reg;

    @Given("the user going homepage")
    public void user_is_on_homepage() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        home = new homepage(driver);
        reg = new registerpage(driver);
    }


    @When("the user clicks the second home slider")
    public void theUserClicksTheFirstHomeSlider() {
        home.clickbanner();
    }

    @Then("the user should be navigated to {string}")
    public void navigateToTheiphonepage(String expectedUrl) {
        home.navigattonotexistiphonepage(expectedUrl);
    }

}
