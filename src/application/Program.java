package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {
	public static void main(String[] args)  {
		Scanner entr = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = entr.nextInt();
	
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(entr.next());
	
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(entr.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(entr.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(entr.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
//		catch(InputMismatchException e) {
//			System.out.println("Invalid Room Number");
//			
//		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		entr.close();

	}
}