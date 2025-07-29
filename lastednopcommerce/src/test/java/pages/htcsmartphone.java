package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class htcsmartphone {

    ChromeDriver drive;
    public htcsmartphone(ChromeDriver d) {
        this.drive = d;
    }
    public void navtosmartphonepage(){
        drive.get("https://demo.nopcommerce.com/htc-smartphone");
    }
}
