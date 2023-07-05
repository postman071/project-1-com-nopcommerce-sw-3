package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;
import zmq.socket.radiodish.Radio;

public class ElectronicsTest extends Utility
{
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    {
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics '] "));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //Verify the text “Cell phones”
        String expectedMessage ="Cell phones";
        String actualMessage =getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
         //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics '] "));
         //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
         //Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expectedMessage,actualMessage);
         //Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);
         //Click on product name “Nokia Lumia 1020”link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
         //Verify the text “Nokia Lumia 1020”
        String expectedTxt = "Nokia Lumia 1020";
        String actualTxt = getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(expectedMessage,actualMessage);
         //Verify the price “$349 .00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expectedMessage,actualMessage);
         //Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElements(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
         //Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        Thread.sleep(1000);
         //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMsg,actualMsg);
         //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
         //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
         //Verify the message "Shopping cart"
        String expectedTxxt = "Shopping cart";
        String actualTxxt = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedTxxt,actualTxxt);
        Thread.sleep(1000);
         //Verify the quantity is 2
        //String expectedQnt= "2";
        //String actualQnt =getTextFromElement(By.xpath("//input[@id='itemquantity11231']")
         //Verify the Total $698.00
        String expected_price="$698.00";
        String actual_price=getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(expected_price,actual_price);
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
         //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
         //Verify the Text “Welcome, Please Sign In!”
        String expStr="Welcome, Please Sign In!";
        String actstr= getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(expStr,actstr);
         //Click on “REGISTER” tab
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
         //Verify the text “Register”
        String expectstring= "Register";
        String actualstring= getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(expectstring,actualstring);
         //Fill the mandatory fields
        clickOnElement(By.xpath("//label[contains(text(),'Male')]"));
        sendTextToElements(By.xpath("//input[@id='FirstName']"),"john");
        sendTextToElements(By.xpath("//input[@id='LastName']"),"david");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"),"29");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"),"october");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"),"1993");
        sendTextToElements(By.xpath("//input[@id='Email']"),"johndavid123@gmail.com");
        clickOnElement(By.xpath("//input[@id='Newsletter']"));
        sendTextToElements(By.xpath("//input[@id='Password']"),"johndavid@123");
        sendTextToElements(By.xpath("//input[@id='ConfirmPassword']"),"johndavid@123");
         //Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
         //Verify the message “Your registration completed”
        String expMsg1="Your registration completed";
        String actMsg1=getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(expMsg1,actMsg1);
         //Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
         //Verify the text “Shopping card”
        String expectedVerify= "Shopping cart";
        String actualVerify= getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(expectedVerify,actualVerify);
         //click on checkbox “I agree with the terms of service”
         //Click on “CHECKOUT”
         //Fill the Mandatory fields
         //Click on “CONTINUE”
         //Click on Radio Button “2nd Day Air ($0.00)”
         //Click on “CONTINUE”
         //Select Radio Button “Credit Card”
         //Select “Visa” From Select credit card dropdown
         //Fill all the details
         //Click on “CONTINUE”
         //Verify “Payment Method” is “Credit Card”
         //Verify “Shipping Method” is “2nd Day Air”
         //Verify Total is “$698.00”
         //Click on “CONFIRM”
         //Verify the Text “Thank You”
         //Verify the message “Your order has been successfully processed!”
         //Click on “CONTINUE”
         //Verify the text “Welcome to our store”
         //Click on “Logout” link
         //Verify the URL is “https://demo.nopcommerce.com/
    }
}
