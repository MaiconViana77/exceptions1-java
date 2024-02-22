package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

//	calcular duração em dias basedo na duas datas
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkout.before(now)) {
			return "Error in reservation: Reservation dates for update must future dates";
		} 
		
	    if (!checkout.after(checkIn)) {
			return "Check-out must be after check-in date";
		}
	    
		this.checkin = checkIn;
		this.checkout = checkOut;
		return null;
		
	}

	@Override
	public String toString() {
		return "Room " +
	    roomNumber +
	    ", check-in: " +
	    sdf.format(checkin) + 
	    ", check-out: " + 
	    sdf.format(checkout)+
	    ", " + 
	    duration() +
	    " nights";
	}
	
	
}
