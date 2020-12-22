package facebookTests;
    
import org.testng.Assert;
import org.testng.annotations.*;
    
  
public class signinTests extends BaseTest {  
	facebook.SigninPage signinPg; 
	private String successSigninDataPath = "src\\main\\resources\\inputData\\successSigninData.csv";  
	private String faillSigninWithInvEmailsDataPath = "src\\main\\resources\\inputData\\faillSigninWithInvEmailsData.csv";
	private String faillSigninWithInvPasswordsDataPath = "src\\main\\resources\\inputData\\faillSigninWithInvPasswordsData.csv";  
	
	@DataProvider(name="successSigninData")
    public Object[][]  getSuccessSignData() throws Exception {
		
		return facebook.CSVFiles.readCSVFile(successSigninDataPath); 
    }
	
	//Test (dataProvider = "successSigninData")
	public void user_can_login_successfully(String email, String password)  { 
		signinPg =new facebook.SigninPage(driver);   
		signinPg.signin(email, password);   
		String expectedUrl="https://www.facebook.com/";
		String actualUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl);    
	     
	} 
	
	@DataProvider(name="faillSigninWithInvEmailsData")
    public Object[][]  getFaillSigninWithInvEmailsData() throws Exception {
		
		return facebook.CSVFiles.readCSVFile(faillSigninWithInvEmailsDataPath); 
    }
	//@Test(dataProvider ="faillSigninWithInvEmailsData")
	 public void user_cant_login_with_invalid_Email(String email, String password) { 
		signinPg =new facebook.SigninPage(driver); 
		signinPg.signin(email, password);    
		Assert.assertTrue(signinPg.isDisplaySigninEmailError()); 
	   
	    } 
	
	@DataProvider(name="faillSigninWithInvPasswordsData")
    public Object[][]  getFaillSigninWithInvPasswordsData() throws Exception {
		
		return facebook.CSVFiles.readCSVFile(faillSigninWithInvPasswordsDataPath); 
    }
	@Test(dataProvider ="faillSigninWithInvPasswordsData")
	public void user_cant_login_with_invalid_password(String email, String password){  
		signinPg =new facebook.SigninPage(driver);  
		signinPg.signin(email,password);   
		Assert.assertTrue(signinPg.isDisplaySigninPasswordError()); 
	      
	  }

}





