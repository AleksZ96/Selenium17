package Domaci.Domaci2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Zadatak1 {
    /*
    Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjige
 na svoj nalog, zatim se izlogovati brisanjem cookies-a. Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.
     */
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/books");

        Cookie cookie1 = new Cookie.Builder("userName", "aleks").sameSite("Lax").isSecure(false).isHttpOnly(false).build();
        driver.manage().addCookie(cookie1);

        Cookie cookie2 = new Cookie.Builder("userID", "ca521f8e-7fd7-48d1-b22c-d443defecdd0").sameSite("Lax").isSecure(false).isHttpOnly(false).build();
        driver.manage().addCookie(cookie2);

        Cookie cookie3 = new Cookie.Builder("expires", "2023-10-06T15:16:03.049Z").sameSite("Lax").isSecure(false).isHttpOnly(false).build();
        driver.manage().addCookie(cookie3);

        Cookie cookie4 = new Cookie.Builder("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFsZWtzIiwicGFzc3dvcmQiOiJQQHNzd29yZDEiLCJpYXQiOjE2OTYwMDA1NjN9.0OhAB3EIlagDKktGrlYiu4r0ALLhM_G0gJ1mm4N_cZs").sameSite("Lax").isSecure(false).isHttpOnly(false).build();
        driver.manage().addCookie(cookie4);
        driver.navigate().refresh();

        Thread.sleep(2000);

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)", "");

        Thread.sleep(2000);

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();

        js.executeScript("window.scrollBy(0, 250)", "");

        Thread.sleep(2000);

        WebElement addButtonAgain = driver.findElement(By.id("addNewRecordButton"));
        addButtonAgain.click();

        Thread.sleep(2000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement logInButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        logInButton.click();

        WebElement userNameBox = driver.findElement(By.id("userName"));
        userNameBox.sendKeys("aleks");

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("P@ssword1");

        Thread.sleep(2000);

        WebElement logInButtonAgain = driver.findElement(By.cssSelector(".btn.btn-primary"));
        logInButtonAgain.click();

        Thread.sleep(2000);

        List<WebElement> card = driver.findElements(By.cssSelector(".btn.btn-light"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Profile")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card.get(i));
                card.get(i).click();
                break;
            }
        }

        WebElement book1Again = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(book1Again.isDisplayed());

        WebElement book2Again = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2Again.isDisplayed());





















    }
}
