package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class C02_DriverMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        //En temel haliyle otomasyon yapmak için Class'ımıza gerekli olan webdriver'ın yerini belirtiyoruz.
        //Java kütüphanesinde ki System.setProperty() methoduyla driver'ı yazıp fiziki yerini belirtiyoruz.

        WebDriver driver = new EdgeDriver(); //Boş bir browser açar
        driver.get("https://www.google.com");  //Gitmek istediğimiz sayfayı belirtiriz

        System.out.println("Sayfa Başlığı : " + driver.getTitle()); //driver.getTitle() ==>  Sayfa Başlığını getirir.
        System.out.println("Sayfa adresi(URL) : " + driver.getCurrentUrl()); //driver.getCurrentUrl() ==> Sayfa adresiNİ(URL) Getirir.
        //System.out.println(driver.getPageSource()); //getPageSource() ==> Sayfa kaynak kodlarını getirir.
        System.out.println(driver.getWindowHandle()); //driver.getWindowHandle() ==> Sayfanın(Window) Hash değerini getirir.
                                                      //Bu Hash değerleri ile başka sayfadan bu sayfaya direk dönebilmeyi sağlar
                                                      //(Sayfalar arası geçiş)


    }

}
