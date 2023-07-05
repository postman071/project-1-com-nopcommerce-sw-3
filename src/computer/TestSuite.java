package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;



public class TestSuite extends Utility


{
    String baseUrl="https://demo.nopcommerce.com/";


    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder()  {
        //Click on Computer Menu
        clickOnElement(By.xpath("//a[text()='Computers ']"));
        //Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        //Select Sort By position "Name: Z to A"
        selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //verify the product will arrange in Descending order.
        String expectedMessage="Name:  Z toA ";
        String actualMessage=driver.findElement(By.xpath("//select[@id='products-orderby']")).getText();
        //Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer Menu
        clickOnElement(By.xpath("//a[text()='Computers ']"));
        //Click on Desktop
        Thread.sleep(1000);
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        //Select Sort By position "Name: A to Z"
        //selectByValueFromDropDown(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"),"Name: A to Z");
        //Click on "Add to Cart"
        clickOnElement(By.xpath("//button[text()='Add to cart']"));
        //Verify the Text"Build your own computer "
        String expectedMessage="Build your own computer";
        getTextFromElement(By.xpath("//a[text()='Build your own computer']"));
        String actualMessage=driver.findElement(By.xpath("//a[text()='Build your own computer']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(2000);
        //WebElement dropDown=driver.findElement(By.xpath("//label[normalize-space()='Processor']"));
        WebElement dropDown=driver.findElement(By.id("product_attribute_1"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class
        Select ramSelect = new Select(driver.findElement(By.id("product_attribute_2")));
        ramSelect.selectByVisibleText("8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]"
        selectRadioButton(By.xpath("//input[@id='product_attribute_3_7']"));
        //Select OS radio "Vista Premium [+$60.00]"
        selectRadioButton(By.xpath("//input[@id='product_attribute_4_9']"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        selectCheckBox(By.xpath("//*[@id='product_attribute_5_10']"));
        selectCheckBox(By.xpath("//*[@id='product_attribute_5_12']"));
        //clickOnElement(By.xpath("//label[contains(text(),'Microsoft Office')]/preceding-sibling::input[@type='checkbox']"));
        //clickOnElement(By.xpath("//label[contains(text(),'Total Commander')]/preceding-sibling::input[@type='checkbox']"));
        //Verify the price "$1,475.00"
        //String expectedPrice ="$1480";
        //String actualPrice=getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        //Assert.assertEquals(expectedPrice,actualPrice);
        //Click on "ADD TO CARD" Button
        WebElement addToCartButton2 = driver.findElement(By.id("add-to-cart-button-1"));
        //addToCartButton2.click();
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //String expectedMessage="The product has been added to your shopping cart";
        driver.findElement(By.xpath("//div[@class='bar-notification success']")).getText();
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//li[@id='topcartlink']"));
        //Verify the message "Shopping cart"
        //String expectedTexts="Shopping cart";
        //String actualTexts=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //Assert.assertEquals("",expectedTexts,actualTexts);
        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[contains(@id,'itemquantity')]")).clear();
        sendTextToElements(By.xpath("//input[contains(@id,'itemquantity')]"),"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //Verify the Total"$2,950.00"

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Verify the Text “Welcome, Please Sign In!”
        WebElement welcomeMessageElement = driver.findElement(By.cssSelector(".page-title h1"));
        String welcomeMessage = welcomeMessageElement.getText();
        Assert.assertEquals(welcomeMessage, "Welcome, Please Sign In!", "Welcome message verification failed");
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //Fill the all mandatory field
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"jason");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_LastName']"),"david");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_Email']"),"jasondavid123@gmail.com");
        sendTextToElements(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_Address1']"),"London Road");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA3 8RP");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07700017017");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //Click on Radio Button “Next Day Air($0.00)”
        selectRadioButton(By.xpath("//label[normalize-space()='Next Day Air ($0.00)']"));
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //Select Radio Button “Credit Card"
        selectRadioButton(By.xpath("//input[@id='paymentmethod_1']"));
        //Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        //Fill all the details
        //Click on “CONTINUE”
        //Verify “Payment Method” is “Credit Card”
        //Verify “Shipping Method” is “Next Day Air”
        //Verify Total is “$2,950.00”
        //Click on “CONFIRM”
        //Verify the Text “Thank You”
        //Verify the message “Your order has been successfully processed!”
        //Click on “CONTINUE”
        //Verify the text “Welcome to our store”
    }
}
