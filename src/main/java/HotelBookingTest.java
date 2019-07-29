import com.sun.javafx.PlatformUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HotelBookingTest {

	 WebDriver driver;
	 
		   
	 public HotelBookingTest(WebDriver driver){ 
         this.driver=driver; 
}
    
     
    @Test
    public void shouldBeAbleToSearchForHotels() throws InterruptedException {

    	waitFor(2000);
//        driver.get("https://www.cleartrip.com/");
    	
    
      driver.findElement(By.xpath("//section[@id='GlobalNav']/div/div[2]/div/strong")).click();
      driver.findElement(By.xpath("//[@class='ctBrand']")).click();
      driver.findElement(By.xpath("//a[contains(text(),'Hotels')]")).click();
      driver.findElement(By.xpath("//input[@id='Tags']")).click();
      driver.findElement(By.xpath("//input[@id='Tags']")).sendKeys("Indiranagar, Bangalore");
      driver.findElement(By.id("SearchHotelsButton")).click();
      
        
    }
    
    private void waitFor(int durationInSeconds) {
        try {
           // Thread.sleep(durationInMilliSeconds);
            driver.manage().timeouts().implicitlyWait(durationInSeconds, TimeUnit.SECONDS);	
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @SuppressWarnings("restriction")
	private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
        	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
