import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By tablets = By.linkText("Планшеты");
    private By price_from = By.id("glpricefrom");
    private By price_to = By.id("glpricefrom");
    private By product_title = By.cssSelector(".n-snippet-card2__title > a.link");
    private By search = By.id("header-search");
    private By search_btn = By.cssSelector(".button2");


    private void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
