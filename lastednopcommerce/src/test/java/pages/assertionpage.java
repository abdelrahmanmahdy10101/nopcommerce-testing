package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assertionpage {
    ChromeDriver drive;
    private By successmsg = By.className("result");
    private By txt = By.xpath("//*[contains(text(),'Your registration completed')]");

    public assertionpage(ChromeDriver d) {
        this.drive = d;
    }

    public void successmessage() {
        boolean x = drive.findElement(successmsg).isDisplayed();
        Assert.assertTrue(x);
    }

    public void assertbytestmessage() {
        boolean x = drive.findElement(txt).isDisplayed();
        Assert.assertTrue(x);
    }

    public void assertbycolor() {
        WebElement successElement = drive.findElement(successmsg);
        String actualColor = successElement.getCssValue("color");

        Assert.assertTrue(actualColor.contains("76") && actualColor.contains("177") && actualColor.contains("124"),
                "Expected green color, but found: " + actualColor);
    }



}