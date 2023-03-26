package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;

public class C01_Xpath {

    //

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(1800);

        //arama butonuna "city bike" yazdır
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchButton.sendKeys("city bike");
        searchButton.submit();
        Thread.sleep(1800);


        //hybrid bikes bölümüne tıklayın
        /*
        (//span[@class='a-size-base a-color-base'])[8] ==> Bu şekilde index kullanarak unique olarak WE ulaşabiliriz.
        //*[text()='Hybrid Bikes'] ==> xpath ile locate alırken html kodlarında attribute name olmayan yani <tag name=class değeri> text()
                                       bu şekilde locate edebiliriz.
         */

        WebElement hybridBikes = driver.findElement(By.xpath("//span[text()='Hybrid Bikes']"));
        System.out.println(hybridBikes.isDisplayed()); //WebElement görüntüleniyor mu? --> Görüntülenebiliyor True
        System.out.println(hybridBikes.isEnabled());   //WebElement erişilebiliyor mu? --> Erişilebiliyor True
        System.out.println(hybridBikes.isSelected());  //WebElement Seçilebiliyor mu?  --> Seçilemiyor False
        hybridBikes.click();
        Thread.sleep(1800);


        //sadece sonuç yazısın yazdır
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(sonuc.getText());
        Thread.sleep(1800);

        //Karşınıza çıkan ilk sonucun resmine tıklayın
        WebElement firstPhoto = driver.findElement(By.xpath("(//span[@class='rush-component'])[7]"));
        firstPhoto.click();
        Thread.sleep(1800);

        driver.close();

    }

}
