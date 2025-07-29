package tests;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homepage;

public class currencytestcase {

    ChromeDriver driver;
    homepage hp;

    @Given("the user is at the homepage")
    public void the_user_is_on_the_homepage() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        hp = new homepage(driver);
    }

    @When("the user selects {string} from the currency dropdown")
    public void the_user_selects_from_the_currency_dropdown(String currency) {
        hp.the_user_selects_from_the_currency_dropdown(currency);
    }

    @Then("all product prices should display the {string} symbol")
    public void the_euro_symbol_should_be_displayed_for_all_product_prices(String symbol) {
        hp.the_euro_symbol_should_be_displayed_for_all_product_prices(symbol);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}