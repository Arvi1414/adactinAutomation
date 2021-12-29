package adactinPractFile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adactinLocaHotelFile extends adactinBaseCode {
	
	public adactinLocaHotelFile() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="location")
	public WebElement locationSelect;
	
	@FindBy(id="hotels")
	public WebElement hotelSelect;
	
	@FindBy(name="room_type")
	public WebElement roomSelect;
	
	@FindBy(id="room_nos")
	public WebElement noOfRooms;
	
	@FindBy(name="datepick_in")
	public WebElement checkIn;
	
	@FindBy(name="datepick_out")
	public WebElement checkOut;
	
	@FindBy(id="adult_room")
	public WebElement noOfAdult;
	
	@FindBy(name="child_room")
	public WebElement noOfChild;
	
	@FindBy(name="Submit")
	public WebElement submit;

}
