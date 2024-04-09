package org.learning.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class EventProgram {

    // Attributes

    private String title;
    private List<Event> eventList;


    // Constructor

    public EventProgram(String title) {
        this.title = title;
        this.eventList = new ArrayList<>();
    }

    // Methods

    public void addEvent(Event e){
        this.eventList.add(e);
    }


    public List<Event> eventsCurrentDate(LocalDate date) {
        return eventList.stream().filter(event -> event.getDate().equals(date)).collect(Collectors.toList());
    }

    public int getNumberOfEvents(){
        return eventList.size();
    }

    public void emptyEvents() {
        eventList.clear();
    }

    public String orderedResult() {
        StringBuilder result = new StringBuilder(title + "\n");
        eventList.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .forEach(event -> result.append(event).append("\n"));
        return result.toString();
    }

    // testing EventProgram
    public static void main(String[] args) {

        // create a new EvenProgram called October 2024
        EventProgram schedule = new EventProgram("October 2024");

        // Populate the ArrayList with 3 new Events ( from Concerts )
        schedule.addEvent(new Concert("Rock Concert", LocalDate.parse("2024-10-01"), 200,
                LocalTime.parse("20:30:00"), new BigDecimal("19.99")));

        schedule.addEvent(new Concert("Pop Concert", LocalDate.parse("2024-10-13"), 250, LocalTime.parse("19:20:50"),
                new BigDecimal("29.99")));

        schedule.addEvent(new Concert("Metal Concert", LocalDate.parse("2024-10-03"), 900, LocalTime.parse("22" +
                ":00:20"), new BigDecimal("39.99")));


        // Prints event present in a selected date
        System.out.println("\n" + "Concerts scheduled for the October 1st 2024: ");
        System.out.println(schedule.eventsCurrentDate(LocalDate.parse("2024-10-01")) + "\n");

        // Prints how many concerts are in the eventList
        System.out.println("\n" + "Your Event List has now " + schedule.getNumberOfEvents() + " Concerts scheduled." + "\n");

        // Prints all the Events in EventList ordered by nearer date
        System.out.println(schedule.orderedResult());

        // Method that empties Event List
        schedule.emptyEvents();
        System.out.println("Your Event List has been emptied! You Now have " + schedule.getNumberOfEvents() +
                " Concerts scheduled.") ;


    }



}
