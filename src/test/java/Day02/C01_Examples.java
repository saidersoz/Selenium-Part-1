package Day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.sql.DriverManager;
import java.time.Duration;

public class C01_Examples {

    /*
       Browser'ı açıp maximize yapın
       Tüm sayfa için maksimum bekleme süresi olarak 15 saniye belirleyin
       Sırasıyla Amazon, Facebook ve Youtube sayfalarına gidin
       Amazon sayfasına geri dönün
       Amazon sayfasının adresinin(Url) https://www.amazon.com/ adresine eşit olduğunu test edin
       Sayfanın konumunu ve boyutunu yazdırın
       Sayfanın konumunu ve boyutunu istediğimiz şekilde ayarlıyın
       İstediğiniz şekilde olup olmadığını test edin
       Sayfayı kapatın
    */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        //       Browser'ı açıp maximize yapın
        driver.manage().window().maximize();

        //       Tüm sayfa için maksimum bekleme süresi olarak 15 saniye belirleyin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //       Sırasıyla Amazon, Facebook ve Youtube sayfalarına gidin
        driver.get("https://www.amazon.com");
        driver.get("https://www.facebook.com");
        driver.get("https://www.youtube.com");

        //       Amazon sayfasına geri dönün
        driver.navigate().back();
        driver.navigate().back();

        //       Amazon sayfasının adresinin(Url) https://www.amazon.com/ adresine eşit olduğunu test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("URL Testi PASS");
        } else {
            System.out.println("URL Testi FAIL");
        }

        //       Sayfanın konumunu ve boyutunu yazdırın
        System.out.println("Sayfa Konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfa Boyutu : " + driver.manage().window().getSize());

        //       Sayfanın konumunu ve boyutunu istediğimiz şekilde ayarlıyın
        driver.manage().window().setPosition(new Point(50, 50));
        driver.manage().window().setSize(new Dimension(600, 600));

        //       İstediğiniz şekilde olup olmadığını test edin
        Point actualKonum = driver.manage().window().getPosition(); //Konum bilgilerini getPosition() methodu ile bir Point container!ı içerisine koyuyoruz
        if (actualKonum.x == 50 && actualKonum.y == 50) { //x ve y değerlerini karşılaştırıyoruz
            System.out.println("Position(Konum) Test PASS");
        } else {
            System.out.println("Position(Konum) Test FAIL");
        }


        Dimension actualBoyut = driver.manage().window().getSize(); //Konum bilgilerini getSize() methodu ile bir Dimension container!ı içerisine koyuyoruz
        if (actualBoyut.width == 600 && actualBoyut.height == 600) {
            System.out.println("Size(Boyut) Test PASS");
        } else {
            System.out.println("Size(Boyut) Test FAIL");
        }

        //Sayfayı kapatın
        driver.close();
    }

}
