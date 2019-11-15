package TicketSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Book_Ticket {

	Scanner sc = new Scanner(System.in);

	private char row;

	private class Invoice {
		int NoSeats;
		int Amount;
		String UserName;

	}

	private int TotalSeats = 50;

	public void isAvailable() {
		System.out.println("Enter the Number of Seats Required");
		int seats = sc.nextInt();
		if (isAvailable(seats)) {
			System.out.println("Seats are available,Please commence!");
		}
		if (!isAvailable(seats))
			System.out.println("Sorry, all Seats are full");

	}

	private boolean isAvailable(int ReqSeats) {
		if (TotalSeats == 0 || ReqSeats > TotalSeats) {
			return false;
		} else
			return true;

	}

	public void BookSeats() {

		System.out.println("Enter the Number of Seats Required ");
		Invoice i1 = new Invoice();
		i1.NoSeats = sc.nextInt();
		if (isAvailable(i1.NoSeats)) {

			i1.Amount = 150 * i1.NoSeats;
			System.out.println("Please enter your First Name");
			i1.UserName = sc.next();

			ReserveSeats(i1.NoSeats);
			System.out.println("Thanks for booking seats with us,Please check the invoice And pay At the Entry:=");
			System.out.println(" Custumer Name="+i1.UserName);
			System.out.println("Number of Seats="+i1.NoSeats);

			System.out.println("Total payable amount="+i1.Amount);
			
			
			
		} else
			System.out.println("Sorry! No seats");

	}

	private void ReserveSeats(int noSeats) {
		// TODO Auto-generated method stub

		HashMap<String, Boolean> hall = new HashMap<String, Boolean>();
		for (int i = 1; i <= 10; i++) {

			hall.put("A" + i, false);

			hall.put("B" + i, false);
			hall.put("C" + i, false);
			hall.put("D" + i, false);
			hall.put("E" + i, false);

		}
		System.out.println("*total seats are A1-E10");
		String cd = "";
		for (int x = 1; x <= noSeats; x++) {
			System.out.println("enter the seat number " + x + "you want to book");
			String ab = sc.next();
			if (hall.get(ab) == false) {
				System.out.println(" was Empty seat , booked for you now");
				hall.put(ab, true);

			}
			else {
				System.out.println("seat already booked ,try again");
				ab+=sc.next();
			}
			cd = cd + ab;

		}
		int count = 0;
		System.out.println("your seats=" + cd);
		Set<Map.Entry<String, Boolean>> entries = hall.entrySet();
		for (Map.Entry<String, Boolean> entry : entries) {
			if (count % 10 == 0) {
				System.out.println();
			}

			if (entry.getValue() == (true)) {
				System.out.print(" "+entry.getKey()+" ");
			}
			if (entry.getValue() == (false)) {
				System.out.print(" $$ ");
			}
			count++;
		}

		// booking system show
	}

}
