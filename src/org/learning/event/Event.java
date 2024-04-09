package org.learning.event;

import java.time.LocalDate;

public class Event {

    // Attributes

    private String title;

    private LocalDate date;

    private int totalSeats;

    private int seatsBooked;


    // Constructor

    public Event(String title, LocalDate date, int totalSeats) {
        this.title = title;
        this.date = checkDate(date);
        this.totalSeats = checkCapacity(totalSeats);
        this.seatsBooked = 0;
    }

    // Methods
    private LocalDate checkDate(LocalDate date) throws IllegalArgumentException {
        if (date.isBefore(LocalDate.now()) ) {
            throw new IllegalArgumentException("You can't insert an event which date is in the past");
        }
        return date;
    }

    private int checkCapacity(int totalSeats) throws IllegalArgumentException {
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("You can't insert a number <= 0");
        }
        return totalSeats;
    }

    public void makeReservation(int seatsToBook) throws IllegalArgumentException {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("You can't book an event that is in the past.");
        }
        if (seatsBooked + seatsToBook > totalSeats) {
            throw new IllegalArgumentException("There aren't enough available places to proceed with your reservation.");
        }
        seatsBooked += seatsToBook;
    }

    public void cancelReservation(int seatsToCancel) throws IllegalArgumentException {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("You can't cancel a reservation of an event that is in the past.");
        }
        if (seatsToCancel > seatsBooked) {
            throw new IllegalArgumentException("The number of seats to cancel is superior to the number of " +
                    "reservations.");
        }
        seatsBooked -= seatsToCancel;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", date.toString(), title);
    }


    // Getters
    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) throws IllegalArgumentException {
        if (date.isBefore(LocalDate.now()) ) {
            throw new IllegalArgumentException("You can't insert an event which date is in the past");
        }
        this.date = date;
    }

}
