package Domaci.Domaci1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.swing.*;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");

        String anyName = "Aleksandra";
        String validEmail = "a@gmail.com";
        String anyCurrentAdress = "Beograd";
        String anyPermanentAdress = "Srbija";


        WebElement nameBox = driver.findElement(By.id("userName"));
        nameBox.sendKeys(anyName);

        WebElement emailBox = driver.findElement(By.id("userEmail"));
        emailBox.sendKeys(validEmail);

        WebElement currentAddressBox = driver.findElement(By.id("currentAddress"));
        currentAddressBox.sendKeys(anyCurrentAdress);

        WebElement permanentAddressBox = driver.findElement(By.id("permanentAddress"));
        permanentAddressBox.sendKeys(anyPermanentAdress);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)", "");
        Thread.sleep(2000);


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(2000);

        WebElement outputMessage = driver.findElement(By.id("output"));
        String expectedOutputMessage = "Name:" + anyName + "\n" + "Email:" + validEmail + "\n" + "Current Address :" + anyCurrentAdress + "\n" + "Permananet Address :" + anyPermanentAdress;
        Assert.assertEquals(outputMessage.getText(), expectedOutputMessage);






    }
}
