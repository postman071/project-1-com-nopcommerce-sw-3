package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility
{
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    //Create method with name "SelectMenu" it has one parameter name "menu" of type string
    public void selectMenu()
    {
        //This method should click on the menu whatever  name is passed as parameter
        String menu = "Computers";
        driver.findElement(By.xpath("(//a[normalize-space()='Computers'])[1]")).click();
    }
    @Test
    public void verifyPageNavigation()
    {
        //Use selectMenu method to select the Menu and click on it
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //click on it and verify the page navigation.
        String expectedMessage="Computers";
        String actualMessage= getTextFromElement(By.xpath("//a[text()='Computers ']"));
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void tearDown()
    {
        // Close the Browser
        closeBrowser();
    }
}
