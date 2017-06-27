
package Tests3;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Functions.BusinessFunctions;


public class Test11_10_MyAlertsSubscriptionSaveChanges extends BusinessFunctions {
  //private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
  
	  OpenBrowser();
  }

  @Test
  public void test() throws Exception {

	//Check if My Alerts; Subscription On/off; Save Changes are working 
	  
	  Thread.sleep(10000);
		driver.get("http://scandid.in/pricelist/memory-cards?ref=refsec_menu");
		Thread.sleep(10000);
				
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[1]/a/img")).click();
		
		Thread.sleep(20000);
			
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }
	   
	    driver.findElement(By.id("couponsubscribe1")).click();
	    Thread.sleep(1000);
	    
	    String HandleBefore = driver.getWindowHandle();
	    driver.findElement(By.cssSelector("button.fbbutton_popup.pointer_cursor")).click();
		
		Thread.sleep(20000);
			
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }   
	    
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("scandid.ex@gmail.com");
	    driver.findElement(By.id("pass")).clear();
	    driver.findElement(By.id("pass")).sendKeys("scandid123");
	    driver.findElement(By.id("u_0_2")).click();
	    
	    Thread.sleep(20000);
	    driver.switchTo().window(HandleBefore);
	    for(String winHandle : driver.getWindowHandles()){
	      driver.switchTo().window(winHandle);
	    }
	    
	    driver.findElement(By.xpath("//div[@id='header']/div/div/div[2]/div/div[2]/div/span")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//li[@onclick=\"redirect_url('http://scandid.in/user/alerts')\"]")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("span.statusEmail")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.id("savebtn")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.cssSelector("span.statusEmail")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.id("savebtn")).click();
	    Thread.sleep(10000);
	    
	Reporter.log("My Alerts; Subscription On/off; Save Changes are working.",true);
	      
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
