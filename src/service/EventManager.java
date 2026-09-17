package service;

import model.Event;
import model.Organizer;
import model.Venue;
import exception.EventNotFoundException;

import java.util.ArrayList;

public class EventManager {

    private ArrayList<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {

        events.add(event);

        System.out.println("\nEvent created successfully!");
        System.out.println("Event ID: " + event.getEventId());
    }

    public void displayAllEvents() {

        if (events.isEmpty()) {
            System.out.println("\nNo events available.");
            return;
        }

        System.out.println("\n========== AVAILABLE EVENTS ==========");

        for (Event event : events) {

            System.out.println("\nID       : " + event.getEventId());
            System.out.println("Name     : " + event.getEventName());
            System.out.println("Date     : " + event.getDate());
            System.out.println("Venue    : " + event.getVenue());
            System.out.println("Seats    : " + event.getAvailableSeats());
        }
    }

    public Event findEvent(String eventId)
            throws EventNotFoundException {

        for (Event event : events) {

            if (event.getEventId().equalsIgnoreCase(eventId)) {
                return event;
            }
        }

        throw new EventNotFoundException(
                "Event with ID " + eventId + " not found."
        );
    }

    public void searchEvent(String keyword) {

        boolean found = false;

        for (Event event : events) {

            if (event.getEventName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                event.displayEvent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo matching event found.");
        }
    }

    public void deleteEvent(String eventId)
            throws EventNotFoundException {

        Event event = findEvent(eventId);

        events.remove(event);

        System.out.println("\nEvent deleted successfully.");
    }

    public void updateEvent(String eventId,
                             String name,
                             String description,
                             String date,
                             Venue venue,
                             int capacity)
            throws EventNotFoundException {

        Event event = findEvent(eventId);

        event.setEventName(name);
        event.setDescription(description);
        event.setDate(date);
        event.setVenue(venue);

        if (capacity >= event.getRegisteredCount()) {
            event.setCapacity(capacity);
        }

        System.out.println("\nEvent updated successfully.");
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
}