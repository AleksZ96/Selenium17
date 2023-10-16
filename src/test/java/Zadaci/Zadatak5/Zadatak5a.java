package Zadaci.Zadatak5;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5a {
    public static void main(String[] args) {
        //Testirati login

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        String validUsername = "student";
        String validPassword = "Password123";

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());

        logoutButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }
}
