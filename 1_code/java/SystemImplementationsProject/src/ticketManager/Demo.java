package ticketManager;
import java.sql.*;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		final String URL = "jdbc:mysql://localhost:3306/sql_ticket_manager";
		final String USER = "java";
		final String PASS = "password";
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Connection successful!");
			
			Statement stmt = connection.createStatement();
			String query = "";
			ResultSet rs = null;
			
			String holder = "";
			
			while(!input.equals("exit") && !input.equals("0")) {
				System.out.println("Please choose an option from the following:");
				System.out.println("1. See current rooms");
				System.out.println("2. Add a room");
				System.out.println("3. Remove a room");
				System.out.println("4. Change seating mode for a room");
				System.out.println("5. Change seat count for a room");
				System.out.println("0. Exit");
				input = scan.nextLine();
				if(!input.equals("exit") && !input.equals("0")) {
					if(input.equals("1")) {
						query = "SELECT * FROM rooms;";
						rs = stmt.executeQuery(query);
						while(rs.next()) {
							System.out.println("Room ID: " + rs.getString(1));
							System.out.println("Room Name: " + rs.getString(2));
							System.out.println("Showing: " + rs.getString(3));
							System.out.println("Total Seats: " + rs.getString(6));
							System.out.println("Available Seats: " + rs.getString(7));
							switch(Integer.parseInt(rs.getString(8))) {
								case 1:
									System.out.println("Seating Mode: Standard");
									break;
								case 2:
									System.out.println("Seating Mode: Priority");
									break;
								case 3:
									System.out.println("Seating Mode: Assigned");
									break;
								case 4:
									System.out.println("Seating Mode: Restricted");
									break;
							}
							System.out.println();
						}
					}else if(input.equals("2")) {
						// Note to self, sanitize inputs. Currently, using a ' can break the query.
						System.out.println("What is the new room's name:");
						input = scan.nextLine();
						query = "INSERT INTO rooms (room_name, showing, total_capacity, seat_rows, seat_columns) VALUES ('" + input + "', '";
						
						System.out.println("What is scheduled to be shown in this room:");
						input = scan.nextLine();
						query = query + input + "', '";
						
						System.out.println("How many total seats does this room have:");
						input = scan.nextLine();
						query = query + input + "', '";
						
						System.out.println("How many rows of seats does this room have:");
						input = scan.nextLine();
						query = query + input + "', '";
						
						System.out.println("How many columns of seats does this room have:");
						input = scan.nextLine();
						query = query + input + "');";
						
						stmt.executeUpdate(query);
					}else if(input.equals("3")) {
						System.out.println("What is the id of the room you want to remove:");
						input = scan.nextLine();
						query = "DELETE FROM rooms WHERE id = " + input;
						stmt.executeUpdate(query);
					}else if(input.equals("4")) {
						System.out.println("What is the id of the room you want to change:");
						input = scan.nextLine();
						holder =  " WHERE id = " + input + ";";
						query = "UPDATE rooms SET seating_mode = ";
						
						System.out.println("Which mode do you want to change to:");
						input = scan.nextLine();
						input = input.toLowerCase();
						while(!input.equals("standard") && !input.equals("priority") && !input.equals("assigned") && !input.equals("restricted")) {
							System.out.println("Please enter a valid seating mode:");
							input = scan.nextLine();
							input = input.toLowerCase();
						}
						if(input.equals("standard")) {
							query = query + "1" + holder;
							stmt.executeUpdate(query);
							System.out.println("Successfully updated room to Standard seating.");
						}else if(input.equals("priority")) {
							query = query + "2" + holder;
							stmt.executeUpdate(query);
							System.out.println("Successfully updated room to priority seating.");
						}else if(input.equals("priority")) {
							query = query + "3" + holder;
							stmt.executeUpdate(query);
							System.out.println("Successfully updated room to assigned seating.");
						}else if(input.equals("restricted")) {
							query = query + "4" + holder;
							stmt.executeUpdate(query);
							System.out.println("Successfully updated room to restricted seating.");
						}
					}else if(input.equals("5")) {
						// THIS NEEDS CLEANER IMPLEMENTATION
						// PROPOSED SOLUTION:
						// 		Ask for total rows and total columns, update in one line. Use rows * columns to get total_capacity
						System.out.println("What is the id of the room you want to modify:");
						input = scan.nextLine();
						holder = " WHERE id = " + input + ";";
						
						System.out.println("How many total seats does the room have:");
						input = scan.nextLine();
						query = "UPDATE rooms SET total_capacity = " + input + holder;
						stmt.executeUpdate(query);
						
						System.out.println("How many rows of seats does the room have:");
						input = scan.nextLine();
						query = "UPDATE rooms SET seat_rows = " + input + holder;
						stmt.executeUpdate(query);
						
						System.out.println("How many columns of seats does the room have:");
						input = scan.nextLine();
						query = "UPDATE rooms SET seat_columns = " + input + holder;
						stmt.executeUpdate(query);
					}else {
						System.out.println("Input not recognized.");
					}
				}
				query = "";
				rs = null;
			}
			
			connection.close();
			System.out.println("Connection terminated.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
