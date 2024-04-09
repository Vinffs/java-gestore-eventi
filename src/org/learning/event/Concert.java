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
}
