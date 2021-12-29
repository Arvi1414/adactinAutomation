package adactinPractFile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adactinLocaLoginFile extends adactinBaseCode{
	
	public adactinLocaLoginFile() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(name="username")
	private WebElement uName;
	public WebElement getUName() {
		return uName;
	}
	
	@FindBy(id="password")
	private WebElement passWord;
	public WebElement getPassWord() {
		return passWord;
	}
	
	@FindBy(id="login")
	public WebElement clickLogin;	
	
	

}
