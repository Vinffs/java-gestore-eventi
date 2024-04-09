package org.learning.event;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Event event = null;
        boolean flag = false;
        while(!flag) {
            System.out.print("Enter the title of the event: ");
            String title = scan.nextLine();

            System.out.print("Enter the date of the event (YYYY-MM-DD): ");

            LocalDate date = LocalDate.parse(scan.nextLine());

            System.out.print("Enter the total number of seats available: ");
            int totalSeats = Integer.parseInt(scan.nextLine());

            try{
                event = new Event(title, date, totalSeats);
                flag = true;
            } catch (IllegalArgumentException e){
                System.out.println("\n" + "Error : " + e.getMessage().toUpperCase() + "\n");
            }
        }


        System.out.println("\n" + "Your Event has been created successfully!" + "\n");

        System.out.print("Do you want to make a reservation? (Y/N) ");
        String response = scan.nextLine().toUpperCase();
        while (response.equalsIgnoreCase("Y")) {
            try {
                System.out.print("How many seats do you want to book? ");
                int seatsToBook = Integer.parseInt(scan.nextLine());
                event.makeReservation(seatsToBook);
                System.out.println("Reservation made successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Do you want to make another reservation? (Y/N) ");
            response = scan.nextLine().toUpperCase();
        }

        System.out.println("\n" + "Booked seats: " + event.getSeatsBooked());
        System.out.println("Available seats: " + (event.getTotalSeats() - event.getSeatsBooked()) + "\n");



        System.out.print("Do you want to cancel a reservation? (Y/N) ");
        response = scan.nextLine().toUpperCase();
        while (response.equalsIgnoreCase("Y")) {
            try {
                System.out.print("How many seats do you want to cancel? ");
                int seatsToCancel = Integer.parseInt(scan.nextLine());
                event.cancelReservation(seatsToCancel);
                System.out.println("Cancellation made successfully!");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
            System.out.print("Do you want to make another cancellation? (Y/N) ");
            response = scan.nextLine().toUpperCase();
        }

        System.out.println("\n" + "Booked seats after cancellations: " + event.getSeatsBooked());
        System.out.println("Available seats after cancellations: " + (event.getTotalSeats() - event.getSeatsBooked()) + "\n");

        scan.close();
    }
}
