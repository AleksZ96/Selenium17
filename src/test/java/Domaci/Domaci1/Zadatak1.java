package Domaci.Domaci1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //Domaci Zadatak 1:
        //Otici na YouTube i pustiti jednu pesmu po Vasem izboru.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        WebElement googleSearch = driver.findElement(By.id("APjFqb"));
        googleSearch.sendKeys("Youtube");

        WebElement googleSearchButton = driver.findElement(By.name("btnK"));
        Thread.sleep(2000);
        googleSearchButton.click();


        WebElement item = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        item.click();

       WebElement youtubeSearch = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
       youtubeSearch.sendKeys("Snow");
       youtubeSearch.sendKeys(ENTER);

       Thread.sleep(2000);
       WebElement playSong = driver.findElement(By.linkText("Red Hot Chili Peppers - Snow (Hey Oh) (Official Music Video)"));
       playSong.click();





    }

}
