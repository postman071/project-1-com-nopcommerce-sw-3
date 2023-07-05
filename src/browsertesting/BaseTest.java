package browsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;



public class BaseTest
{
    public static WebDriver driver;

    public void openBrowser(String baseUrl)
    {
        // Launch The Browser
        driver=new ChromeDriver();
        // Selenium the URL into Browser
        driver.get(baseUrl);
        //Maximise the Browser
        driver.manage().window().maximize();
        //We give implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser()
    {
        //Close the Browser
        driver.quit();
    }
}
