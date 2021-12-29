package adactinPractFile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adactinLocaConfHotel extends adactinBaseCode{
	
	public adactinLocaConfHotel() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="radiobutton_0")
	public WebElement finalHotel;
	
	@FindBy(name="continue")
	public WebElement confirmHotel;
	

}
