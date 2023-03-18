import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class IlkClass {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/Drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.gsstore.org/");

    }
}
