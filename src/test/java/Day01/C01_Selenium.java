package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Selenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/Drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        /*
        En temel haliyle otomasyon yapmak için Class'ımıza gerekli olan webdriver'ın yerini belirtiyoruz.
        Java kütüphanesinde ki System.setProperty() methoduyla driver'ı yazıp fiziki yerini belirtiyoruz.
         */


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

    }

}
