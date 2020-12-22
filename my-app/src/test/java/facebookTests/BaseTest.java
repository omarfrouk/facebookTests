package facebookTests;
  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*; 

public class BaseTest {
	WebDriver driver;
    String url="https://www.facebook.com/";
    String driverPath = "src\\main\\resources\\drivers\\chromedriver.exe";  
    
    
    @BeforeMethod
    public void invokeBrowser() { 
    	System.setProperty("webdriver.chrome.driver", driverPath); 
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        driver.get(url); 
    }
    @AfterMethod
    public void terminateBrowser() {  
        driver.close(); 
    } 
    
    
}
