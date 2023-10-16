package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak4 {

    public static void main(String[] args)  throws InterruptedException {
        ////Potrebno je preko Gugla naci stranicu Wikipedije o Nikoli Tesli na cirilici

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");


        WebElement googleSearchBox = driver.findElement(By.id("APjFqb"));
        googleSearchBox.sendKeys("Никола Тесла");

        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        WebElement wikipediaLink = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikipediaLink.click();

        String expectedURL = "https://sr.wikipedia.org/sr-ec/%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0_%D0%A2%D0%B5%D1%81%D0%BB%D0%B0";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String pageTitleText = pageTitle.getText();
        String expectedTitleText = "Никола Тесла";

        Assert.assertEquals(pageTitleText, expectedTitleText);


    }

}
