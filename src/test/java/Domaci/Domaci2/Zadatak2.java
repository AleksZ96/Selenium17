package Domaci.Domaci2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Zadatak2 {
    WebDriver driver;
    String validUsername = "student";
    String validPassword = "Password123";
    String emptyUsername = "";
    String emptyPassword = "";
    String invalidUsername = "student1";
    String invalidPassword = "Password1234";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
    }

    public void usernameInvalidMessage(){
        WebElement usernameInvalidMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your username is invalid!";
        Assert.assertTrue(usernameInvalidMessage.isDisplayed());
        Assert.assertEquals(usernameInvalidMessage.getText(), expectedErrorMessage);
    }
    public void passwordInvalidMessage() {
        WebElement usernameInvalidMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your password is invalid!";
        Assert.assertTrue(usernameInvalidMessage.isDisplayed());
        Assert.assertEquals(usernameInvalidMessage.getText(), expectedErrorMessage);
    }

    @Test
    public void loginWithValidUserNameAndValidPassword() {

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));

        Assert.assertTrue(logoutButton.isDisplayed());

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement message = driver.findElement(By.className("has-text-align-center"));

        String expectedMessage = "Congratulations " + validUsername + ". You successfully logged in!";

        Assert.assertEquals(message.getText(), expectedMessage);
    }

    @Test
    public void logout() {

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

    @Test

    public void loginWithInvalidUserNameAndValidPassword() throws InterruptedException {

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(invalidUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(2000);
        usernameInvalidMessage();

    }

    @Test
    public void loginWithValidUserNameAndInvalidPassword() throws InterruptedException {


        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(invalidPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(2000);

        passwordInvalidMessage();
    }

    @Test
    public void loginWithValidUserNameAndEmptyPassword() throws InterruptedException{

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(emptyPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(2000);
       passwordInvalidMessage();
    }

    @Test
    public void loginWithEmptyUserNameAndValidPassword() throws InterruptedException{

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(emptyUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(2000);

        usernameInvalidMessage();
    }

    @Test
    public void loginWithEmptyUserNameAndEmptyPassword() throws InterruptedException{

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(emptyUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(emptyPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(2000);

        usernameInvalidMessage();
    }

    @Test
    public void loginWithInvalidUserNameAndInvalidPassword() throws InterruptedException{

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(invalidUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(invalidPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(2000);

        usernameInvalidMessage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
