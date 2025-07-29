package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class homepage {
    ChromeDriver drive;

    WebDriverWait wait; // Add this global WebDriverWait variable

    private By reglink = By.className("ico-register");
    public homepage(ChromeDriver d){
        this.drive=d;
        this.wait = new WebDriverWait(d, Duration.ofSeconds(10)); // Initialize wait in constructor

    }
    public void navigatetoreg(){
        drive.findElement(reglink).click();
    }
    public void navtologinpage() {
        drive.findElement(By.linkText("Log in")).click();
    }
    // Correct selectors for nopCommerce demo site
    By currencyDropdown = By.id("customerCurrency");
    By productPrices = By.cssSelector(".price.actual-price");

    public void the_user_selects_from_the_currency_dropdown(String currency) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(currencyDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(currency);

        // Wait for page refresh after currency change
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void the_euro_symbol_should_be_displayed_for_all_product_prices(String symbol) {
        // Wait for prices to load with Euro symbol
        wait.until(ExpectedConditions.presenceOfElementLocated(productPrices));

        List<WebElement> prices = drive.findElements(productPrices);

        if (prices.isEmpty()) {
            throw new AssertionError("No product prices found on the page");
        }

        for (WebElement price : prices) {
            String priceText = price.getText();
            System.out.println("Price found: " + priceText);

            if (!priceText.contains(symbol)) {
                throw new AssertionError("Euro symbol " + symbol + " not found in price: " + priceText);
            }
        }

        System.out.println("All " + prices.size() + " product prices contain the Euro symbol: " + symbol);
    }



public void useraddwhitlist(){
    drive.findElement(By.cssSelector("img[alt='Picture of HTC smartphone']")).findElement(By.xpath("..")).click();

}
     public void appearmessage() {
         SoftAssert softAssert = new SoftAssert();

         try {
             WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));

             // 1. Wait and click the "Add to wishlist" button
             WebElement wishlistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-wishlist-button-18")));
             wishlistBtn.click();

             // 2. Wait for the green message bar to appear
             WebElement messageBar = wait.until(ExpectedConditions.presenceOfElementLocated(
                     By.cssSelector("div.bar-notification.success")));

             // 3. Wait for the text to be present
             wait.until(ExpectedConditions.textToBePresentInElement(messageBar, "The product has been added to your wishlist"));

             // 4. Assert message is displayed
             softAssert.assertTrue(messageBar.isDisplayed(), "❌ Success message not displayed.");

             // 5. Assert message content
             String actualMessage = messageBar.getText().trim();
             softAssert.assertTrue(actualMessage.contains("The product has been added to your wishlist"),
                     "❌ Message text mismatch. Got: " + actualMessage);

             // 6. Get background-color in RGBA format
             String rgbaColor = messageBar.getCssValue("background-color");
             System.out.println("🎨 Background color (RGBA): " + rgbaColor);

             // 7. Convert RGBA to HEX
             String hexColor = Color.fromString(rgbaColor).asHex();
             System.out.println("🎨 Converted to HEX: " + hexColor);

             // 8. Compare to expected HEX color
             String expectedHexColor = "#4bb07a";
             softAssert.assertEquals(hexColor, expectedHexColor, "❌ Background color does not match expected green.");

         } catch (Exception e) {
             System.out.println("⚠️ Exception during appearmessage(): " + e.getMessage());
             e.printStackTrace();
             softAssert.fail("❌ Test failed due to exception: " + e.getMessage());
         }

         // 9. Finalize soft assertions
         softAssert.assertAll();
     }


     public void click_on_whitlist_in_green_message(){
         drive.findElement(By.linkText("wishlist"));
     }


     public void theItemQuantityInTheWishlistShouldBeGreaterThan(int minExpectedQuantity) {
         WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));

         // Wait until the wishlist quantity is visible
         WebElement wishlistQtyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector("span.wishlist-qty")
         ));

         // Get the text and extract the number from "(1)"
         String qtyText = wishlistQtyElement.getText(); // e.g., "(1)"
         int actualQty = Integer.parseInt(qtyText.replaceAll("[^0-9]", ""));

         // Assert the quantity is greater than the minimum
         assertTrue("Wishlist quantity should be greater than " + minExpectedQuantity, actualQty > minExpectedQuantity);
     }

     public void clickbanner(){
         WebElement slider = drive.findElement(By.className("slider-img"));

     }

     public void navigattonotexistnokiapage(String expectedurl){
         String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";

         WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlContains("nokia-lumia")); // wait for navigation attempt

         String actualUrl = drive.getCurrentUrl();

         // Hard assertion to ensure it's a bug if we don't land on the correct page
         Assert.assertEquals("UI Bug: URL did not change after clicking slider", expectedUrl, actualUrl);
     }

    public void navigattonotexistiphonepage(String expectedurl){
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";

        WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("iphone-6")); // wait for navigation attempt

        String actualUrl = drive.getCurrentUrl();

        // Hard assertion to ensure it's a bug if we don't land on the correct page
        Assert.assertEquals("UI Bug: URL did not change after clicking slider", expectedUrl, actualUrl);
    }

public void enteritemandclicksearch(String productName ) {
    SoftAssert softAssert = new SoftAssert();

    // Step 1: Go to homepage
    drive.get("https://demo.nopcommerce.com/");

    // Step 2: Enter product in search and click search button
    WebElement searchBox = drive.findElement(By.id("small-searchterms"));
    searchBox.clear();
    searchBox.sendKeys(productName);
    drive.findElement(By.cssSelector("button[type='submit']")).click();

}

public void verifyurl(String productName){
    SoftAssert softAssert = new SoftAssert();
    // Step 3: Verify URL contains correct pattern
    String currentUrl = drive.getCurrentUrl();
    softAssert.assertTrue(currentUrl.contains("https://demo.nopcommerce.com/search?q="),
            "URL does not contain expected pattern for search: " + currentUrl);

    // Step 4: Verify search results section is populated
    List<WebElement> results = drive.findElements(By.cssSelector(".product-item"));
    softAssert.assertTrue(results.size() > 0, "No search results found for: " + productName);

    // Step 5: Validate each result contains the search keyword
    for (WebElement result : results) {
        String resultText = result.getText().toLowerCase();
        softAssert.assertTrue(resultText.contains(productName.toLowerCase()),
                "Search result does not contain product name: " + resultText);
    }

    // Step 6: Call assertAll to gather all soft assertions
    softAssert.assertAll();
}

}








