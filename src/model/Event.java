package model;

public class Event {

    private String eventId;
    private String eventName;
    private String description;
    private String date;
    private Venue venue;
    private int capacity;
    private int registeredCount;
    private Organizer organizer;

    public Event(String eventId,
                 String eventName,
                 String description,
                 String date,
                 Venue venue,
                 int capacity,
                 Organizer organizer) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.date = date;
        this.venue = venue;
        this.capacity = capacity;
        this.organizer = organizer;
        this.registeredCount = 0;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public Venue getVenue() {
        return venue;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRegisteredCount() {
        return registeredCount;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void incrementRegistration() {
        registeredCount++;
    }

    public void decrementRegistration() {
        if (registeredCount > 0) {
            registeredCount--;
        }
    }

    public int getAvailableSeats() {
        return capacity - registeredCount;
    }

    public void displayEvent() {

        System.out.println("\n========================================");
        System.out.println("              EVENT DETAILS");
        System.out.println("========================================");

        System.out.println("Event ID       : " + eventId);
        System.out.println("Event Name     : " + eventName);
        System.out.println("Description    : " + description);
        System.out.println("Date           : " + date);
        System.out.println("Venue          : " + venue);
        System.out.println("Organizer      : " + organizer.getName());
        System.out.println("Capacity       : " + capacity);
        System.out.println("Registered     : " + registeredCount);
        System.out.println("Available Seats: " + getAvailableSeats());

        System.out.println("========================================");
    }
}