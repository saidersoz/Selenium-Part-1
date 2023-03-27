package Day05_RelativeLocators;

import com.sun.source.tree.Tree;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        Relative Locator
        Bir Web Sayfasında benzer özelliklere aship WebElementlerin olduğu durumlarda kullanılabilir
             - above ==> Belirtilen elementin üstünde olan elementi seçer
             - below ==> Belirtilen elementin altında olan elementi seçer
             - to_left_of ==> Belirtilen elementin solunda olan elementi seçer
             - to_left_of ==> Belirtilen elementin sağında olan elementi seçer
             - near ==> Belirtilen elementin yanında/yakınında olan elementi seçer
         */

        //amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        Thread.sleep(1800);

        //city bike aratalım
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchButton.sendKeys("city bike"+ Keys.ENTER);
        Thread.sleep(1800);


        //Relative Locator kullanarak Hybrid Bide altında ki webElemente tıklayalım
        WebElement hybridBikes = driver.findElement(By.xpath("//span[text()='Hybrid Bikes']"));
        WebElement mountainBikes = driver.findElement(with(By.tagName("a")).below(hybridBikes));
        mountainBikes.click();
        Thread.sleep(1800);


        driver.close();
    }

}
