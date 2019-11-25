import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/Users/kzolotarev/IdeaProjects/testyandex/drivers/geckodriver");

        WebDriver driver =  new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/catalog--kompiuternaia-tekhnika/54425");

        WebDriverWait wait = (new WebDriverWait(driver, 10));


        WebElement link1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Планшеты")));
        link1.click();

//        Тут какая то засада надо больше времени разобраться
//        WebElement link2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Apple')]")));
//        link2.click();

        WebElement link3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("glpricefrom")));
        link3.sendKeys("20000");

        WebElement link4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("glpricefrom")));
        link4.sendKeys("35000");


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".n-snippet-card2__title > a.link")));
        List<WebElement> products = driver.findElements(By.cssSelector(".n-snippet-card2__title > a.link"));

        String test = products.get(2).getText();
        System.out.println(test);

        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-search")));
        search.sendKeys(test);


        WebElement button2 = driver.findElement(By.cssSelector(".button2"));
        button2.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".n-snippet-card2__title > a.link")));
        List<WebElement> result_titles = driver.findElements(By.cssSelector(".n-snippet-card2__title > a.link"));

        String title = result_titles.get(2).getText();



        driver.quit();
    }

}
//.n-snippet-card2__title > a.link
//header-search