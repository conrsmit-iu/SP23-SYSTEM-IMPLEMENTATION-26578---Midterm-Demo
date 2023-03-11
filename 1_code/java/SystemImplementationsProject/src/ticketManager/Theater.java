package ticketManager;

public class Theater extends PaymentSystem{
	private final String location;
	private final String address;
	private Room[] rooms;
	private PaymentSystem payment;
	
	public Theater(String loc, String add, int roomCount) {
		location = loc;
		address = add;
		
		rooms = new Room[roomCount];
		
	}

	public String getLocation() {
		return location;
	}

	public String getAddress() {
		return address;
	}
	
	public void sellTicket(int roomNumber, int spot) {
		try {
			Ticket t = rooms[roomNumber].issueTicket(spot, location);
			if(!pay()) {
				System.out.println("Your payment was declined.");
			}else {
				System.out.println("Your payment was successful, here is your ticket:");
				System.out.println(t);
			}
		} catch (Exception e) {
			System.out.println("This seat is already taken");
		}
	}
}
