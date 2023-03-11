package ticketManager;

import java.util.Calendar;

public class Room extends Seat{
	private final String roomName;
	private String showing;
	private boolean isFull;
	private final int totalSeats;
	private int usedSeats;
	private Mode seatMode;
	private Seat[][] seatGrid;
	private Calendar date;
	
	public Room(String name, int capacity, int rows, int columns, Calendar c) {
		roomName = name;
		totalSeats = capacity;
		
		isFull = false;
		seatMode = Mode.Standard;
		
		this.seatGrid = new Seat[rows][columns];
		int counter = 0;
		for(int i = 0; i < seatGrid.length; i++) {
			for(int j = 0; j < seatGrid[i].length; j++) {
				counter++;
				setSeatId(counter);
				setOccupied(false);
				setSpecial(false);
			}
		}
		
		date = c;
	}
	
	public void setShowing(String show){
		showing = show;
	}
	
	public String getShowing() {
		return showing;
	}
	
	public int getOccupancy() {
		return totalSeats;
	}
	
	public boolean full() {
		return isFull;
	}
		
	public void setSeating(Mode seating) {
		switch(seating){
		case Standard:
			seatMode = Mode.Standard;
		case Priority:
			seatMode = Mode.Priority;
		case Assigned:
			seatMode = Mode.Assigned;
		case Restricted:
			seatMode = Mode.Restricted;
		}
	}
	
	public Mode getSeatingMode() {
		return seatMode;
	}

	public String getRoomName() {
		return roomName;
	}

	public int getUsedSeats() {
		return usedSeats;
	}

	public void updateUsedSeats(boolean add) {
		if(add) {
			usedSeats++;
		}else {
			usedSeats--;
		}
	}
	
	public Ticket issueTicket(int spot, String location) throws Exception {
		int y = spot / seatGrid[0].length;
		int x = spot % seatGrid[0].length;
		if(x < 0) {
			x = 0;
		}
		if(seatGrid[y][x].isOccupied()) {
			throw new Exception();
		}else {
			seatGrid[y][x].setOccupied(true);
		}
		return new Ticket(location, roomName, spot, date);
	}
	
	public void removeTicket(Ticket t) {
		int y = t.getSeatId() / seatGrid[0].length;
		int x = t.getSeatId() % seatGrid[0].length;
		if(x < 0) {
			x = 0;
		}
		seatGrid[y][x].setOccupied(false);
	}
}
