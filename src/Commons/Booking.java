package Commons;
import java.math.*;
import java.util.Date;
public class Booking extends Flight {
	private static int confirmNum = (int)(Math.random()* 999); //making this random
	private long timeBooked;
	private String bookingStatus;
	public Booking() {}
	
	public Booking(int flightID, int flightNum, int Cost, int confirmNum) {
		super ();
		this.confirmNum = confirmNum;
		this.timeBooked = new Date().getTime();
		this.bookingStatus = "Confirmed";
	}
	
	//more get and set
	public int getConfirmNum() {
		return confirmNum;
	}
	public void setConfirmNum(int confirmationNum) {
		this.confirmNum = confirmNum;
	}
	
	
	public long getTimeBooked() {
		return timeBooked;
	}
	public void setTimeBooked(long timeBooked) {
		this.timeBooked = timeBooked;
	}
	
	
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
		
	}
}
