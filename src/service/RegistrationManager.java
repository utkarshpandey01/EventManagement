package service;

import model.Event;
import model.Registration;
import model.Student;
import exception.AlreadyRegisteredException;
import exception.EventFullException;
import exception.EventNotFoundException;

import java.util.ArrayList;

public class RegistrationManager {

    private ArrayList<Registration> registrations;

    private int registrationCounter = 1001;

    public RegistrationManager() {
        registrations = new ArrayList<>();
    }

    public void registerStudent(Student student,
                                 Event event)
            throws EventFullException,
                   AlreadyRegisteredException {

        // Check duplicate registration
        for (Registration registration : registrations) {

            if (registration.getStudent()
                    .getStudentId()
                    .equalsIgnoreCase(student.getStudentId())
                    &&
                registration.getEvent()
                    .getEventId()
                    .equalsIgnoreCase(event.getEventId())) {

                throw new AlreadyRegisteredException(
                        "Student is already registered for this event."
                );
            }
        }

        // Check event capacity
        if (event.getAvailableSeats() <= 0) {

            throw new EventFullException(
                    "Registration failed! Event is full."
            );
        }

        String registrationId =
                "REG" + registrationCounter++;

        Registration registration =
                new Registration(
                        registrationId,
                        student,
                        event
                );

        registrations.add(registration);

        event.incrementRegistration();

        System.out.println("\nRegistration successful!");
        System.out.println("Registration ID: " + registrationId);
        System.out.println(
                "Seats remaining: "
                        + event.getAvailableSeats()
        );
    }

    public void cancelRegistration(String registrationId)
            throws Exception {

        Registration found = null;

        for (Registration registration : registrations) {

            if (registration.getRegistrationId()
                    .equalsIgnoreCase(registrationId)) {

                found = registration;
                break;
            }
        }

        if (found == null) {

            throw new Exception(
                    "Registration ID not found."
            );
        }

        found.getEvent().decrementRegistration();

        registrations.remove(found);

        System.out.println(
                "\nRegistration cancelled successfully."
        );
    }

    public void displayStudentRegistrations(Student student) {

        boolean found = false;

        System.out.println(
                "\n===== YOUR REGISTRATIONS ====="
        );

        for (Registration registration : registrations) {

            if (registration.getStudent()
                    .getStudentId()
                    .equalsIgnoreCase(
                            student.getStudentId())) {

                registration.displayRegistration();
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "You have not registered for any event."
            );
        }
    }

    public void displayEventParticipants(Event event) {

        boolean found = false;

        System.out.println(
                "\n===== EVENT PARTICIPANTS ====="
        );

        for (Registration registration : registrations) {

            if (registration.getEvent()
                    .getEventId()
                    .equalsIgnoreCase(
                            event.getEventId())) {

                System.out.println(
                        "Registration ID: "
                                + registration.getRegistrationId()
                );

                System.out.println(
                        "Student: "
                                + registration.getStudent().getName()
                );

                System.out.println(
                        "Student ID: "
                                + registration.getStudent()
                                .getStudentId()
                );

                System.out.println("---------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No students registered yet."
            );
        }
    }

    public ArrayList<Registration> getRegistrations() {
        return registrations;
    }
}