package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        Random r = new Random();
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");

        WebElement element = driver.findElement(By.linkText("login"));

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(2);

        element.click();

        sleep(2);
        System.out.println("Väärä salasana:");
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("login"));
        sleep(2);
        element.submit();
        System.out.println(driver.getPageSource());

        sleep(2);
        System.out.println("Väärä käyttäjätunnus:");
        element = driver.findElement(By.name("username"));
        element.sendKeys("eiole");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("login"));
        sleep(2);
        element.submit();
        sleep(2);
        System.out.println(driver.getPageSource());
        sleep(2);

        //siirrytään etusivulle
        System.out.println("Etusivulle:");
        sleep(2);
        driver.get("http://localhost:4567");
        System.out.println(driver.getPageSource());

        sleep(2);
        System.out.println("Uusi käyttäjä:");
        element = driver.findElement(By.linkText("register new user"));
        sleep(2);
        element.click();
        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusi" + r.nextInt());
        element = driver.findElement(By.name("password"));
        element.sendKeys("oikein");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("oikein");
        element.submit();
        System.out.println(driver.getPageSource());
        sleep(2);

        
        System.out.println("Uusi käyttäjä ulos kirjaaminen:");
        sleep(2);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        sleep(2);
        element.click();
        System.out.println(driver.getPageSource());
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        sleep(2);
        element.click();
        System.out.println(driver.getPageSource());
        

        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

    private static void clickLinkWithText(String text, WebDriver driver) {
        int trials = 0;
        while (trials++ < 5) {
            try {
                WebElement element = driver.findElement(By.linkText(text));
                element.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
