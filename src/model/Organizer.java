package model;

public class Organizer extends User {

    private String organizerId;

    public Organizer(String name, String email, String organizerId) {
        super(name, email);
        this.organizerId = organizerId;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n===== ORGANIZER INFORMATION =====");
        System.out.println("Name         : " + name);
        System.out.println("Email        : " + email);
        System.out.println("Organizer ID : " + organizerId);
    }
}