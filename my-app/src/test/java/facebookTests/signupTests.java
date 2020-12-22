package facebookTests;
 
import org.testng.Assert;
import org.testng.annotations.*;
 

public class signupTests extends BaseTest  { 
    facebook.SignupPage signupPg;
    private String successSignupWithEmailDataPath = "src\\main\\resources\\inputData\\successSignupWithEmailData.csv";  
    
    @DataProvider(name="successSignupWithEmailData")
    public Object[][]  getFaillSigninWithInvEmailsData() throws Exception {
		
		return facebook.CSVFiles.readCSVFile(successSignupWithEmailDataPath); 
    }
	@Test(dataProvider ="successSignupWithEmailData")
    public void user_can_signup_With_MobileNum_successfully(String firstname, String lastname,String email,String confiEmail,
    		String password,String day,String month,String year){  
		
		signupPg=new facebook.SignupPage(driver); 
		signupPg.clickCraectAccountButton();  
		signupPg.signupWithEmail(firstname,lastname,email,confiEmail,password,day,month,year);   
		signupPg.clickSignUpButton(); 
		Assert.assertTrue(signupPg.isCreatAccountEmailCodeLabelDisplayed()); 
    } 
}
