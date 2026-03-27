import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AboutRentPage;
import pages.MainPage;
import pages.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUITest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;
    AboutRentPage aboutRentPage;

    @Before
//    возможность переключать браузеры
    public void startBrowser() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFireFox();
        }
    }

    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        aboutRentPage = new AboutRentPage(driver);
    }

    public void startBrowserFireFox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        aboutRentPage = new AboutRentPage(driver);
    }

    //закрываем браузер
    @After
    public void tearDown() {
        driver.quit();
    }
}

