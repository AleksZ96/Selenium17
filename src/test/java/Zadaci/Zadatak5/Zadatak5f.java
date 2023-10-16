package Zadaci.Zadatak5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5f {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        String invalidUsername = "";
        String invalidPassword = "";

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(invalidUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(invalidPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement usernameInvalidMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your username is invalid!";
        Assert.assertTrue(usernameInvalidMessage.isDisplayed());
        Assert.assertEquals(usernameInvalidMessage.getText(), expectedErrorMessage);
    }
}
