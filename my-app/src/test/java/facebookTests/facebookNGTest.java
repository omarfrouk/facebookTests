package facebookTests; 
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.support.ui.Select; 
//import org.testng.annotations.*; 
import org.openqa.selenium.WebElement; 
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
 
/**
 * @author ENG-Omar
 *
 */
public class facebookNGTest {
    WebDriver driver;
    String url="http://www.fb.com";
    String driverPath = "src\\main\\resources\\drivers\\chromedriver.exe";  

    
    public void invokeBrowser() { 
    	System.setProperty("webdriver.chrome.driver", driverPath); 
        driver = new ChromeDriver();
        driver.get(url); 
    }
    public void terminateBrowser(){
    	try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.close(); 
    }
 
    public void passSignup(String firstname, String lastname,String email,String confiEmail, 
		String password,String day,String month,String year){
    	invokeBrowser();
    	try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    	clickCraectAccountButton();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        enterSignupData( firstname,  lastname, email, confiEmail,password, day, month, year);
        clickSignupButton();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Assert.assertTrue(validatCreatAccountCode());
        terminateBrowser();
    }
    
   
    public void passSignin(String email, String password){ 
    	invokeBrowser(); 
    	try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //login  
    	enterSigninData(email,password); 
    	clickSignInButton();
      
	  try {
	      Thread.sleep(7000);
	  } catch (InterruptedException ex) {
	      Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
	  }
      
      String actualUrl="https://www.facebook.com/";
      String expectedUrl= driver.getCurrentUrl(); 
      Assert.assertEquals(expectedUrl,actualUrl);
      
      terminateBrowser();
       
      //logout 
//      driver.findElement(Locators.logOutMenu).click();
//      driver.findElement(Locators.logOutButton).click();
    }
    
    public void signinwithInvalidEmail(String email, String password){
    	invokeBrowser(); 
    	try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //login  
       
    	enterSigninData(email,password); 
    	clickSignInButton();
      
      try {
          Thread.sleep(7000);
      } catch (InterruptedException ex) {
          Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      Assert.assertTrue(validateSigninEmailError());
      terminateBrowser();
    }
    
    
    
    public void signinwithInvalidPassword(String email, String password){ 
    	invokeBrowser(); 
    	try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //login  
       
    	enterSigninData(email,password); 
    	clickSignInButton();
      
      try {
          Thread.sleep(7000);
      } catch (InterruptedException ex) {
          Logger.getLogger(facebookNGTest.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      Assert.assertTrue(validateSigninPasswordError());
      terminateBrowser();
       
    }
    
    public void clickCraectAccountButton() {
    	driver.findElement(facebook.Locators.craectAccountButton).click();
    }
    
    public void enterSignupData(String firstname, String lastname,String email,String confiEmail, 
    		String password,String day,String month,String year) {
    	driver.findElement(facebook.Locators.creatAccountFirstname).sendKeys(firstname);
        driver.findElement(facebook.Locators.creatAccountLasttname).sendKeys(lastname);
        driver.findElement(facebook.Locators.creatAccountEmail).sendKeys(email);
        driver.findElement(facebook.Locators.creatAccountEmailConfirmation).sendKeys(confiEmail);
        driver.findElement(facebook.Locators.creatAccountPassword).sendKeys(password);

        WebElement dayElement= driver.findElement(facebook.Locators.creatAccountDay);
        WebElement monthElement= driver.findElement(facebook.Locators.creatAccountMonth);
        WebElement yearElement= driver.findElement(facebook.Locators.creatAccountYear);

        Select dayDropdown = new Select(dayElement);
        Select monthDropdown = new Select(monthElement);
        Select yearDropdown = new Select(yearElement);

        dayDropdown.selectByVisibleText(day);
        monthDropdown.selectByVisibleText(month);
        yearDropdown.selectByVisibleText(year);

        driver.findElement(facebook.Locators.creatAccountMale).click(); 
    }
    public void clickSignupButton() {
    	driver.findElement(facebook.Locators.creatAccountSignUp).click();
    }
    
    public boolean validatCreatAccountCode() {
    	boolean EnteTheCode= driver.findElement(facebook.Locators.creatAccountEnteTheCodeEmalLabel).isDisplayed();
        if(EnteTheCode)
      	  return true;
        else
      	  return false; 
    }
    
    public void enterSigninData(String email, String password) {
  	  driver.findElement(facebook.Locators.signInEmail).sendKeys(email);
  	  driver.findElement(facebook.Locators.signInPassword).sendKeys(password);
     }
    public void clickSignInButton() {
    	driver.findElement(facebook.Locators.signInButton).click();
    }
    public boolean validateSigninEmailError() {
    	boolean  invalidEmail= driver.findElement(facebook.Locators.signInInvalidEmailLabel).isDisplayed();
        if(invalidEmail)
        	return true;
        else
        	return false; 
    }
    public boolean validateSigninPasswordError() {
    	boolean invalidPassword= driver.findElement(facebook.Locators.signInInvalidPasswordLabel).isDisplayed();
        if(invalidPassword)
      	  return true;
        else
        	return false;
    }
     
    //public static void main(String[] args) {	}
      				
    
}	