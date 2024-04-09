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


}
