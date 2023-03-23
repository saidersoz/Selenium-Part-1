package Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_Xpath {

    /*
        https://www.amazon.com/ sayfasına gidin.
        “city bike” araması yapın
        Under 200 olanı tıklayın
        Sayfayı kapatın
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");
        Thread.sleep(1800);

        //“city bike” araması yapın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);
        Thread.sleep(1800);

        //Under 200 olanı tıklayın
        WebElement we1 = driver.findElement(By.xpath("//span[.='Under $200']")); //attribute ismi yoksa "." koy
        we1.click();
        Thread.sleep(1800);

        //Sayfayı kapatın
        driver.close();

    }

}
