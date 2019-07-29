import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {
	WebDriver driver;
	 
    public SignInTest(WebDriver driver){ 
             this.driver=driver; 
    }
   
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws InterruptedException {

    	/*setDriverPath();
    	driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");*/
        
    	//calling implicit wait for 2 sec
    	waitFor(2000);
    	
    	//Clicking on the Your Trip which is located at right top corner
        driver.findElement(By.linkText("Your trips")).click();
        
      //Clicking on the Sign-in option in the Your Trip drop down
        driver.findElement(By.id("SignIn")).click();
        
    
      //Catching the error message through assert
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInSeconds) {
        try {
           // Thread.sleep(durationInMilliSeconds);
            driver.manage().timeouts().implicitlyWait(durationInSeconds, TimeUnit.SECONDS);	
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
