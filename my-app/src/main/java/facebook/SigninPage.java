package facebook;
 
import org.openqa.selenium.WebDriver; 
public class SigninPage extends BasePage {
	public SigninPage(WebDriver driver) {
		super(driver);
	}
  
  public void signin(String signinEmail, String signinPassword) {
	  
	setFieldText(Locators.signInEmail,signinEmail); 
	setFieldText(Locators.signInPassword,signinPassword);
	clickElemet(Locators.signInButton);   
  	 
  }   
  public boolean isDisplaySigninEmailError() { 
	  String elementText="The email you’ve entered doesn’t match any account. Sign up for an account."; 
	  return isElementDisplayed(Locators.signInInvalidEmailLabel) && getElementText(Locators.signInInvalidEmailLabel).equals(elementText);
		  
  }
  public boolean isDisplaySigninPasswordError() { 
      String elementText="The password you’ve entered is incorrect. Forgot Password?";  
	  return isElementDisplayed(Locators.signInInvalidPasswordLabel) && getElementText(Locators.signInInvalidPasswordLabel).equals(elementText);

  }
  
}
