package Day05_RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.xml.transform.sax.SAXResult;
import java.nio.channels.NotYetBoundException;
import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html	adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        Thread.sleep(1000);

        //Berlin’i 3 farkli relative locator ile locate edin
        WebElement NYCWebElement = driver.findElement(By.id("pid3_thumb"));
        WebElement bayAreaWebElement = driver.findElement(By.id("pid8_thumb"));
        WebElement berlinWebElement = driver.findElement(with(By.tagName("img")).below(NYCWebElement).
                                                                               toLeftOf(bayAreaWebElement));
        berlinWebElement.click();
        Thread.sleep(1000);

        //Relative locator’larin dogru calistigini test edin
        System.out.println(berlinWebElement.getAttribute("id"));
        System.out.println(NYCWebElement.getAttribute("id"));
        String actualIdDegeri = berlinWebElement.getAttribute("id");
        String expectedIdDegeri = "pid7_thumb";

        if (actualIdDegeri.equals(expectedIdDegeri)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        //sayfayı kapatalım
        driver.close();

    }

}
