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
        Thread.sleep(1800);

        //Berlin’i 3 farkli relative locator ile locate edin
        WebElement nyc = driver.findElement(By.cssSelector("img[id='pid3_thumb']"));
        WebElement bayArea = driver.findElement(By.cssSelector("img[id='pid8_thumb']"));
        WebElement berlin = driver.findElement(with(By.tagName("a")).below(nyc).toLeftOf(bayArea));
        berlin.click();
        Thread.sleep(1800);

        //Relative locator’larin dogru calistigini test edin
        String actualIdDegeri = berlin.getAttribute("id");
        String exceptedIdDegeri = "pid7_thumb";

        if (actualIdDegeri.equals(exceptedIdDegeri)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //sayfayı kapatalım
        driver.close();

    }

}
