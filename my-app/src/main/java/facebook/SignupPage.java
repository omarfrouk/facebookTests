package facebook;

import org.openqa.selenium.WebDriver; 

public class SignupPage extends BasePage{ 
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	 
	public void signupWithEmail(String firstname, String lastname,String email,String confiEmail, 
		String password,String day,String month,String year){
		setFieldText(Locators.creatAccountFirstname,firstname);
		setFieldText(Locators.creatAccountLasttname,lastname);
		setFieldText(Locators.creatAccountEmail,email);
		setFieldText(Locators.creatAccountEmailConfirmation,confiEmail);
		setFieldText(Locators.creatAccountPassword,password); 
		
		setDropdownValue(Locators.creatAccountDay,day);
		setDropdownValue(Locators.creatAccountMonth,month); 
		setDropdownValue(Locators.creatAccountYear,year); 

        clickElemet(Locators.creatAccountMale);  
    } 
	
	 public boolean isCreatAccountEmailCodeLabelDisplayed() { 
		return isElementDisplayed(Locators.creatAccountEnteTheCodeEmalLabel);
		 
	    }
	 
	 public boolean isCreatAccountSMSCodeLabelDisplayed() { 
			return isElementDisplayed(Locators.creatAccountEnteTheCodeSMSLabel);
			 
		    }
	  
	 public void clickCraectAccountButton() {
		 clickElemet(Locators.craectAccountButton);
	    }
	 
	 public void clickSignUpButton() {
		 clickElemet(Locators.creatAccountSignUp); 
	    }
}
