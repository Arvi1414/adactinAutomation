package adactinPractFile;

import java.io.IOException;

public class adactinLaunchFile extends adactinBaseCode{

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Launch browser and Url
		browserLaunch(10);
		launchUrl("http://adactinhotelapp.com/");
		
		//Login credentials
		
		adactinLocaLoginFile locator = new adactinLocaLoginFile();
		
		userName(locator.getUName(),"Aravindvaid");
		passWord(locator.getPassWord(),"arvi4tester");
		submit(locator.clickLogin);
		
		//Hotel Selector page Credentials 
		
		adactinLocaHotelFile locaToHotel = new adactinLocaHotelFile();
		
		location(locaToHotel.locationSelect,"New York");
		hotel(locaToHotel.hotelSelect,"Hotel Sunshine");
		room(locaToHotel.roomSelect,"Deluxe");
		noOfRoomsSelect(locaToHotel.noOfRooms,"2");
		checkInDate(locaToHotel.checkIn,"24/12/2021");
		checkOutDate(locaToHotel.checkOut,"27/12/2021");
		noOfAdultIn(locaToHotel.noOfAdult,"2");
		noOfChildIn(locaToHotel.noOfChild,"1");
		submit(locaToHotel.submit);
		
		
		adactinLocaConfHotel confirmHotel = new adactinLocaConfHotel();
		
		confHotel(confirmHotel.finalHotel);
		confirmHotel(confirmHotel.confirmHotel);
		
		
		adactinLocaBookHotel bookRoomConf = new adactinLocaBookHotel();
		
		guestFName(bookRoomConf.guestFNameLoc,"Aravind");
		guestLName(bookRoomConf.guestLNameLoc,"Amaravathi");
		guestAddress(bookRoomConf.guestAddressLoc,"Chennai");
		guestCCName(bookRoomConf.guestCCLoc(),"2649854445562485");
		guestCardType(bookRoomConf.guestCardType(),"VISA");
		guestCCExpMonth(bookRoomConf.guestExp(),"4");
		guestCCExpYear(bookRoomConf.guestExpYear(),"2019");
		guestCardCvv(bookRoomConf.guestCardCvv(),"564");
		bookRoom(bookRoomConf.BookNowLoc);

		takeScreenShot("book");
	}

}
