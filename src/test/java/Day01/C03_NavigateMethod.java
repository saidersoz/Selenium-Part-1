package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C03_NavigateMethod {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        WebDriver driver = new EdgeDriver();

        //Amazon sayfasına gidelim
        driver.navigate().to("https://amazon.com");
        //driver.get("https://amazon.com");


        //techproedu sayfasına gidelim
        Thread.sleep(3000); //Thread.sleep() ==> 3000 ms bekleyebilir
        driver.navigate().to("https://www.techproeducation.com");
        //driver.get("https://www.techproeducation.com");


        //Amazon sayfasına geri gönerlim
        Thread.sleep(3000);
        driver.navigate().back();


        //Techproeducation sayfasına tekrar gidelim
        Thread.sleep(3000);
        driver.navigate().forward();


        //Sayfayı yenileyelerim (refresh)
        Thread.sleep(3000);
        driver.navigate().refresh();


        //Sayfayı kapatalım
        Thread.sleep(3000);
        driver.close();
    }

}
