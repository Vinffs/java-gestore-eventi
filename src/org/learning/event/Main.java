package org.learning.event;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("Enter the title of the event: ");
        String title = scan.nextLine();

        System.out.print("Enter the date of the event (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scan.nextLine());

        System.out.print("Enter the total number of seats available: ");
        int totalSeats = Integer.parseInt(scan.nextLine());


        Event event = new Event(title, date, totalSeats);


        scan.close();
    }
}
