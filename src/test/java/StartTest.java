import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shelty on 14.08.2016.
 */
public class StartTest {

    public static WebDriver driver;

    @BeforeSuite
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterSuite

    public void tearDown() throws Exception {
        driver.quit();

    }
}
