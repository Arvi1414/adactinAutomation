package adactinPractFile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adactinLocaBookHotel extends adactinBaseCode{
	
	public adactinLocaBookHotel() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first_name")
	public WebElement guestFNameLoc;
	
	@FindBy(name="last_name")
	public WebElement guestLNameLoc;
	
	@FindBy(name="address")
	public WebElement guestAddressLoc;
	
	@FindBy(id="cc_num")
	private WebElement guestPayCCLoc;
	
	public WebElement guestCCLoc(){
		return guestPayCCLoc;
	}
	
	@FindBy(name="cc_type")
	private WebElement guestCardTypeLoc;
	
	public WebElement guestCardType() {
		return guestCardTypeLoc;
	}
	
	@FindBy(name="cc_exp_month")
	private WebElement guestExpMonthLoc;
	
	public WebElement guestExp() {
		return guestExpMonthLoc;
	}
	
	@FindBy(name="cc_exp_year")
	private WebElement guestExpYearLoc;
	
	public WebElement guestExpYear() {
		return guestExpYearLoc;
	}
	
	@FindBy(name="cc_cvv")
	private WebElement guestCardCvvLoc;
	
	public WebElement guestCardCvv() {
		return guestCardCvvLoc;
	}
	
	
	@FindBy(id="book_now")
	public WebElement BookNowLoc;
	

}
