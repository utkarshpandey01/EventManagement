package model;

public class Registration {

    private String registrationId;
    private Student student;
    private Event event;

    public Registration(String registrationId,
                        Student student,
                        Event event) {

        this.registrationId = registrationId;
        this.student = student;
        this.event = event;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public Student getStudent() {
        return student;
    }

    public Event getEvent() {
        return event;
    }

    public void displayRegistration() {

        System.out.println("\n================================");
        System.out.println("       REGISTRATION DETAILS");
        System.out.println("================================");

        System.out.println("Registration ID : " + registrationId);
        System.out.println("Student Name    : " + student.getName());
        System.out.println("Student ID      : " + student.getStudentId());
        System.out.println("Event           : " + event.getEventName());
        System.out.println("Event ID        : " + event.getEventId());
        System.out.println("Event Date      : " + event.getDate());

        System.out.println("================================");
    }
}