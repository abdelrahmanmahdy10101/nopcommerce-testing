package tests;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class whitlisttestcase2 {

    ChromeDriver driver;
    homepage hp;
    loginpage log;
    loginassertionpage assertpage;
    htcsmartphone s;
    whitlistpage w;
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        hp = new homepage(driver);
        log = new loginpage(driver);
        assertpage = new loginassertionpage(driver);
         s= new htcsmartphone(driver);
         w=new whitlistpage(driver);
    }
    @Given("the user is on the HTC smartphone product page")
    public void theUserIsOnTheHTCSmartphoneProductPage() {
s.navtosmartphonepage();
    }


    @When("the user adds the item to the wishlist again")
    public void theUserAddsTheItemToTheWishlistAgain() {
hp.useraddwhitlist();
    }

    @And("the success message disappears")
    public void theSuccessMessageDisappears() {
        hp.appearmessage();

    }

    @And("the user clicks on the Wishlist tab")
    public void theUserClicksOnTheWishlistTab() {
hp.click_on_whitlist_in_green_message();
    }
    @And("the user goes to the wishlist page")
    public void theUserGoesToTheWishlistPage() {

w.navtowhitlistpage();
    }



    @Then("the item quantity in the Wishlist should be greater than {int}")
    public void theItemQuantityInTheWishlistShouldBeGreaterThan(int arg0) {
hp.theItemQuantityInTheWishlistShouldBeGreaterThan(arg0);
    }



}
