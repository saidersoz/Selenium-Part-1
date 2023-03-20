package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C04_ManageMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        WebDriver driver = new EdgeDriver();

        //techpro sayfasına gidin
        driver.get("https://techproeducation.com");


        //Sayfanın konumu ve boyutlarını yazdırın
        System.out.println("Sayfanın konumu :"+driver.manage().window().getPosition()); //==> Sayfanın konumunu veriyor. (10, 10)
        System.out.println("Sayfanın boyutları :"+driver.manage().window().getSize()); //==> Sayfanın boyutlarını verir (1050, 700)


        //Sayfayı minimize(simge durumu) yapalım
        Thread.sleep(1800);
        driver.manage().window().minimize(); //minimize()==> Sayfayı simge durumuna getirir


        //Sayfayı maximize yapalım
        Thread.sleep(1800);
        driver.manage().window().maximize(); //maximize() ==> tam kaplamaz ama ekranda açık yer kalmaz.


        //Sayfanın konumu ve boyutlarını yazdırın
        System.out.println("Sayfanın konumu :"+driver.manage().window().getPosition()); //==> Sayfanın konumunu veriyor. (10, 10)
        System.out.println("Sayfanın boyutları :"+driver.manage().window().getSize()); //==> Sayfanın boyutlarını verir (1050, 700)


        //Sayfayı tam ekran (full screen) yapalım
        Thread.sleep(1800);
        driver.manage().window().fullscreen(); //==> Sayfayı tamm ekran yapar


        //sayfayı kapatalım
        Thread.sleep(1800);
        driver.close();

    }

}
