import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingTest {
	WebDriver driver;
	 
    public FlightBookingTest(WebDriver driver){ 
             this.driver=driver; 
    }
    
    
    @Test
    public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {
    	
       /* setDriverPath();
        driver.get("https://www.cleartrip.com/");*/
    	
    	//calling implicit wait for 2 sec
    	waitFor(2000);
       
    	//clicking on the one way (Anyway it is default selected. if not one way click code written also following code work)
    	driver.findElement(By.id("OneWay")).click();
    	
    	//Selecting Source place
        driver.findElement(By.id("FromTag")).clear();
        driver.findElement(By.id("FromTag")).sendKeys("Bangalore"); //Sending data in Source place

        //wait for the auto complete options to appear for the origin

        waitFor(2000);
//      List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
//      originOptions.get(0).click();

        //Selecting Destination place
        driver.findElement(By.id("ToTag")).clear();
        driver.findElement(By.id("ToTag")).sendKeys("Delhi");

      //wait for the auto complete options to appear for the origin

        waitFor(2000);
       //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        //Selecting Current Date as Departed Date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();

        //all fields filled in. Now click on search
        driver.findElement(By.id("SearchBtn")).click();

       // waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        //close the browser
        //driver.quit();
        

    }


    private void waitFor(int durationInSeconds) {
    	try {
            // Thread.sleep(durationInMilliSeconds);
             driver.manage().timeouts().implicitlyWait(durationInSeconds, TimeUnit.SECONDS);	
         } catch (Exception e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

   
}
