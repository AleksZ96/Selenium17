package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak8 {
    public static void main(String[] args) throws IOException {
        //Zadatak 8
        //Otici na stranicu https://imgflip.com/memegenerator
        //Uploadovati sliku od koje treba napraviti mim
        //Mim mora biti vezan za IT, QA ili kurs
        //Sliku rucno skinuti i ubaciti na Slack thread poruku
        //Autor mima sa najvise lajkova dobija pivo na druzenju
        //
        //Napomena: Izazov zadatka je kod lokatora, assertove ne treba dodavati i ne treba raditi sa anotacijama

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");


        String imageLocation = "C:\\Users\\Alex\\Desktop\\Man.jpg";

        WebElement uploadTemplate = driver.findElement(By.id("mm-show-upload"));
        uploadTemplate.click();

        WebElement uploadPicture = driver.findElement(By.id("mm-upload-file"));
        uploadPicture.sendKeys(imageLocation);

        WebElement uploadButton = driver.findElement(By.id("mm-upload-btn"));
        uploadButton.click();

        List<WebElement> textbox = driver.findElements(By.className("mm-text"));
        textbox.get(0).sendKeys("My code doesnt work");
        textbox.get(1).sendKeys("Lets change nothing and run it again");


        WebElement generateMeme = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateMeme.click();

        //-----------------------------------


        //Save image
        WebElement meme = driver.findElement(By.id("done-img"));
        wdwait.until(ExpectedConditions.attributeContains(meme, "src", "imgflip.com"));
        String link = meme.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageIO.write(saveImage, "png", new File("C:\\Users\\Alex\\Desktop\\Man.jpg"));

    }
}