package Day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(1800);

        //Add Element butonuna basın
        WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElement.click();
        Thread.sleep(1800);

        //Delete butonu'nun görünür olduğunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));
        System.out.println("Delete Butonu gözüküyor mu ? ==> " + deleteButton.isDisplayed());
        Thread.sleep(1800);

        //Delete tuşuna basın
        deleteButton.click();
        Thread.sleep(1800);


        //"Add/Remove/Elements" yazısının görünür olduğunu test edin
        WebElement addRemoveElements = driver.findElement(By.cssSelector("h3"));
        System.out.println("AddRemove görnüyor mu ? ==> "+addRemoveElements.isDisplayed());
        Thread.sleep(1800);

        //Tarayacıyı kapat
        driver.close();

        /*
        xpath ve vssSelector arasıında ki farklar
        --Xpath metin ile çalışabilir    CssSelector Çalışamaz
        --Xpath daha fazla kombinasyona sahiptir ve index'e göre arama yapabilir
        --CssSelector index'e göre arama yapamaz ancak daha hızlı çalışır.
         */
    }
}
