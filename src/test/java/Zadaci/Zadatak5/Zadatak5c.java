package Zadaci.Zadatak5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5c {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        String validUsername = "student";
        String invalidPassword = "Password1234";

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(invalidPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement usernameInvalidMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your password is invalid!";
        Assert.assertTrue(usernameInvalidMessage.isDisplayed());
        Assert.assertEquals(usernameInvalidMessage.getText(), expectedErrorMessage);
    }
}
