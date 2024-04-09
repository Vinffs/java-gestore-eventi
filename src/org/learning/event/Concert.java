package org.learning.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{

    //Attributes
    LocalTime time;
    BigDecimal price;

    // Constructor
    public Concert(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) {
        super(title, date, totalSeats);
        this.time = time;
        this.price = price;
    }

    // Methods

    public String formatTime() {
        return getTime().format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String formatDate() {
        return getDate().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
    }

    public String getFormattedPrice() {
        return String.format("%.2f€", getPrice());
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", formatDate() + " " + formatTime(), getTitle(), getFormattedPrice());
    }

    // Getters

    public LocalTime getTime() {
        return time;
    }

    public BigDecimal getPrice() {
        return price;
    }



    // Setters

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    // Main used for Concert Testing

    public static void main(String[] args) {

        Concert concertOne = new Concert("Rock Concert", LocalDate.parse("2024-10-01"), 200,
                LocalTime.parse("20:30:00"), new BigDecimal("19.99"));

        Concert concertTwo = new Concert("Pop Concert", LocalDate.parse("2024-09-01"), 250, LocalTime.parse("19:20:50"),
                new BigDecimal("29.99"));

        Concert concertThree = new Concert("Metal Concert", LocalDate.parse("2024-12-01"), 900, LocalTime.parse("22" +
                ":00:20"), new BigDecimal("39.99"));


        System.out.println(concertOne.toString());
        System.out.println(concertTwo.toString());
        System.out.println(concertThree.toString());


    }
}
