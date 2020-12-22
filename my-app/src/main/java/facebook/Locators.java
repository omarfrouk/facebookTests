package facebook;

import org.openqa.selenium.By;

public class Locators {
	public static final By craectAccountButton=By.id("u_0_2");
	public static final By creatAccountFirstname =By.name("firstname"); 
	public static final By creatAccountLasttname =By.name("lastname");
	public static final By creatAccountEmail =By.name("reg_email__"); 
	public static final By creatAccountEmailConfirmation =By.name("reg_email_confirmation__");
	public static final By creatAccountPassword =By.name("reg_passwd__");
	public static final By creatAccountDay =By.id("day");
	public static final By creatAccountMonth =By.id("month");
	public static final By creatAccountYear =By.id("year");
	public static final By creatAccountMale =By.xpath("//input[@type='radio' and @value='1']");
	public static final By creatAccountFemale =By.xpath("//input[@type='radio' and @value='2']");
	public static final By creatAccountSignUp =By.name("websubmit");
	public static final By creatAccountEnteTheCodeEmalLabel =By.xpath("//h2[text()='Enter Security Code']");//"//*[@id='u_0_9']/div/div[1]/div/div[2]/h2");
	public static final By creatAccountEnteTheCodeSMSLabel =By.xpath("//h2[text()='Enter the code from the SMS']");//"//*[@id='content']/div/div/div[1]/div[1]/div/div[2]/h2");
	
	public static final By signInEmail =By.id("email");
	public static final By signInPassword =By.id("pass");
	public static final By signInButton =By.id("u_0_b");
	public static final By signInInvalidEmailLabel =By.xpath("//div[text()='The email you’ve entered doesn’t match any account. ']");//"//*[@id=\"email_container\"]/div[2]");   
	public static final By signInInvalidPasswordLabel =By.xpath("//div[text()='The password you’ve entered is incorrect. ']");//"//*[@id=\"loginform\"]/div[2]/div[2]");
	 
}
