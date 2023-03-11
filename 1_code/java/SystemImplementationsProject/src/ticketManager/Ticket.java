package ticketManager;

import java.util.Calendar;

public class Ticket{
	private final String roomId;
	private final int seatId;
	private final String location;
	private Calendar date;
	
	public Ticket(String loc, String room, int seat, Calendar c) {
		seatId = seat;
		roomId = room;
		location = loc;
		date = c;
	}

	public String getRoomId() {
		return roomId;
	}

	public int getSeatId() {
		return seatId;
	}

	public String getLocation() {
		return location;
	}
	
	public String toString(Ticket t) {
		return "Room Number: " + roomId + "/n" + "Seat Number: " + seatId + "/n" + "Location: " + location + "/n" + "Date: " + date;
	}
}
