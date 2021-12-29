package adactinPractFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class adactinBaseCode {
	
	static WebDriver driver;
	
	public static WebDriver browserLaunch(int time) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void userName(WebElement uName,String data) {
		uName.sendKeys(data);
	}
	
	public static void passWord(WebElement passWord,String data)  {
		passWord.sendKeys(data);
	}
	
	public static void submit(WebElement clickLogin){
		clickLogin.click();
	}
	
	public static void location(WebElement locationSelect,String data) throws InterruptedException  {
		Thread.sleep(5000);
		Select goToLocation = new Select(locationSelect);
		goToLocation.selectByValue(data);		
	}
	
	public static void hotel(WebElement hotelSelect,String data)  {
		Select goToHotel = new Select(hotelSelect);
		goToHotel.selectByValue(data);
	}
	
	public static void room(WebElement roomSelect,String data) {
		Select goToRoom = new Select(roomSelect);
		goToRoom.selectByValue(data);
	}
	
	public static void noOfRoomsSelect(WebElement noOfRooms,String data){
		Select goToNoRooms = new Select(noOfRooms);
		goToNoRooms.selectByValue(data);
	}
	
	public static void checkInDate(WebElement checkIn,String data){
		checkIn.clear();
		checkIn.sendKeys(data);
	}
	
	public static void checkOutDate(WebElement checkOut,String data){
		checkOut.clear();
		checkOut.sendKeys(data);
	}
	
	public static void noOfAdultIn(WebElement noOfAdult,String data){
		Select goToAdult = new Select(noOfAdult);
		goToAdult.selectByValue(data);
	}
	
	public static void noOfChildIn(WebElement noOfChild,String data){
		Select goToChild = new Select(noOfChild);
		goToChild.selectByValue(data);
	}
	
	public static void submit1(WebElement submit){
		submit.click();
	}
	
	public static void confHotel(WebElement finalHotel) {
		finalHotel.click();
	}
	
	public static void confirmHotel(WebElement confirmHotel) {
		confirmHotel.click();
	}
	
	public static void guestFName(WebElement guestFNameLoc,String data) throws InterruptedException {
		Thread.sleep(5000);
		guestFNameLoc.sendKeys(data);
	}
	
	public static void guestLName(WebElement guestLNameLoc,String data) {
		guestLNameLoc.sendKeys(data);
	}
	
	public static void guestAddress(WebElement guestAddressLoc,String data) {
		guestAddressLoc.sendKeys(data);
	}
	
	public static void guestCCName(WebElement guestPayCCLoc,String data) {
		guestPayCCLoc.sendKeys(data);
	}
	
	public static void guestCardType(WebElement guestCardTypeLoc,String data) {
		Select goToCardType = new Select(guestCardTypeLoc);
		goToCardType.selectByValue(data);
	}
	
	public static void guestCCExpMonth(WebElement guestExpMonthLoc,String data) {
		Select goToCardExp = new Select(guestExpMonthLoc);
		goToCardExp.selectByValue(data);
	}
	
	
	public static void guestCCExpYear(WebElement guestExpYearLoc,String data) {
		Select goToCardExp = new Select(guestExpYearLoc);
		goToCardExp.selectByValue(data);
	}
	
	public static void guestCardCvv(WebElement guestCardCvvLoc,String data) {
		guestCardCvvLoc.sendKeys(data);
	}
	
	public static void bookRoom(WebElement BookNowLoc) {
		BookNowLoc.click();
	}
	
	
	public static void takeScreenShot(String imageName) throws IOException {
		TakesScreenshot  printScreen = (TakesScreenshot)driver;
		File src = printScreen.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+ imageName+".png");
		FileUtils.copyFile(src,des);
		
	}
	
	public static Object[][] getXlData(String fileLoc,String sheetName) throws IOException {
			
		File loc = new File(fileLoc);
		
		FileInputStream ip = new FileInputStream(loc);
		
		Workbook workbook = new XSSFWorkbook(ip);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(0);
		
		int noOfRows = sheet.getPhysicalNumberOfRows();
		
		int noOfCells = row.getPhysicalNumberOfCells();
		
		Object[][] obj = new Object[noOfRows][noOfCells];
		
		for(int i=0;i<noOfRows;i++) {
			Row r = sheet.getRow(i);
			System.out.println(" ");
			for(int j=0;j<noOfCells;j++) {
				Cell c = r.getCell(j);
				int type = c.getCellType();
				String value=null;
				
				if(type==1) {
					value = c.getStringCellValue();	 
					System.out.print("           ");
					  System.out.print(value);
				}
				else {
					if(DateUtil.isCellDateFormatted(c)) {
						Date date = c.getDateCellValue();
						SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
						value = form.format(date);
						System.out.print("           ");
						  System.out.print(value);
					}
					else {
						double cellValue = c.getNumericCellValue();
						long ln = (long) cellValue;					
						value = String.valueOf(ln);
						System.out.print("           ");
						  System.out.print(value);
						}			
			   }				
				obj[i][j] = value;
		}
	}		
		return obj;		
	}
	
	public static void setXlData(String fileLoc,String sheetName, int noOfRows, int noOfCells) throws IOException {
		
		File loc = new File(fileLoc);
		
		Workbook workFile = new XSSFWorkbook();
		
		Sheet sheet = workFile.createSheet(sheetName);
		
		for(int i=0;i<noOfRows;i++) {
			Row row = sheet.createRow(i);
			for(int j=0;j<noOfCells;j++) {
				Cell cell = row.createCell(j);
				
				Scanner ip = new Scanner(System.in);
				String data = ip.next();
				cell.setCellValue(data);
			}
		}
		
			
		FileOutputStream OP = new FileOutputStream(loc);

		workFile.write(OP);
		
		System.out.println("Done");
	

}
	
}
