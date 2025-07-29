package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class whitlistpage {

    ChromeDriver drive;

    public whitlistpage(ChromeDriver d) {
        this.drive = d;
    }


    public void navtowhitlistpage(){
        drive.get("https://demo.nopcommerce.com/wishlist");
    }
}
