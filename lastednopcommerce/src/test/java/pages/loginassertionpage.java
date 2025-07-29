package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
public class loginassertionpage {

    ChromeDriver drive;
    SoftAssert softAssert = new SoftAssert();

    public loginassertionpage(ChromeDriver d) {
        this.drive = d;
    }

    public void ensureurl(String expectedUrl) {
        // Add debugging
        String currentUrl = drive.getCurrentUrl();
        System.out.println("Current URL before wait: " + currentUrl);
        System.out.println("Expected URL: " + expectedUrl);

        WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));
        try {
            wait.until(driver -> {
                String url = driver.getCurrentUrl();
                System.out.println("Checking URL: " + url);
                return url.equals(expectedUrl);
            });
        } catch (Exception e) {
            System.out.println("Final URL after timeout: " + drive.getCurrentUrl());
            throw e;
        }

        String actualUrl = drive.getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl,
                "URL does not match! expected [" + expectedUrl + "] but found [" + actualUrl + "]");
    }

    public void checkmyaccounttab() {
        WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(By.xpath("//a[@class='ico-account']"))
                .isDisplayed());

        boolean x = drive.findElement(By.className("ico-account")).isDisplayed();
        softAssert.assertTrue(x, "'MY ACCOUNT' tab is not displayed!");
    }

    public void assertAll() {
        softAssert.assertAll();
    }



    public void checkLoginErrorMessage(String expectedMessage) {
        WebElement error = drive.findElement(By.cssSelector(".message-error.validation-summary-errors"));
        String actualMessage = error.getText();
        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Error message mismatch!");
    }

    public void checkErrorMessageColor(String expectedHex) {
        WebElement error = drive.findElement(By.cssSelector(".message-error.validation-summary-errors"));
        String rgbaColor = error.getCssValue("color");
        String actualHex = Color.fromString(rgbaColor).asHex();
        softAssert.assertEquals(actualHex, expectedHex, "Error color mismatch!");
    }

}
