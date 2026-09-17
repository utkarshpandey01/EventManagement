package test;

import model.Event;
import model.Student;
import model.Organizer;
import model.Venue;

import service.EventManager;
import service.RegistrationManager;

import exception.AlreadyRegisteredException;
import exception.EventFullException;
import exception.EventNotFoundException;

public class TestRunner {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      VIT EVENT MANAGEMENT SYSTEM");
        System.out.println("             TESTING");
        System.out.println("======================================");


        // Create managers
        EventManager eventManager = new EventManager();
        RegistrationManager registrationManager =
                new RegistrationManager();


        // Create organizer
        Organizer organizer =
                new Organizer(
                        "Admin",
                        "admin@vit.ac.in",
                        "ORG101"
                );


        // Create venue
        Venue venue =
                new Venue(
                        "Innovation Lab",
                        "VIT Bhopal"
                );


        // Create event with capacity = 2
        Event event =
                new Event(
                        "E999",
                        "Java Testing Workshop",
                        "Testing Java Event Management System",
                        "25-09-2026",
                        venue,
                        2,
                        organizer
                );


        // =================================================
        // TEST 1 : ADD EVENT
        // =================================================

        System.out.println("\nTEST 1: Add Event");

        eventManager.addEvent(event);

        if (eventManager.getEvents().contains(event)) {

            System.out.println("PASS - Event added successfully.");

        } else {

            System.out.println("FAIL - Event was not added.");
        }


        // =================================================
        // TEST 2 : FIND EVENT
        // =================================================

        System.out.println("\nTEST 2: Find Event");

        try {

            Event foundEvent =
                    eventManager.findEvent("E999");

            if (foundEvent != null) {

                System.out.println(
                        "PASS - Event found successfully."
                );

            }

        } catch (EventNotFoundException e) {

            System.out.println(
                    "FAIL - Event should have been found."
            );
        }


        // =================================================
        // TEST 3 : EVENT NOT FOUND EXCEPTION
        // =================================================

        System.out.println(
                "\nTEST 3: Event Not Found Exception"
        );

        try {

            eventManager.findEvent("INVALID");

            System.out.println(
                    "FAIL - Exception was not thrown."
            );

        } catch (EventNotFoundException e) {

            System.out.println(
                    "PASS - EventNotFoundException handled."
            );

            System.out.println(
                    "Message: " + e.getMessage()
            );
        }


        // =================================================
        // TEST 4 : STUDENT REGISTRATION
        // =================================================

        System.out.println(
                "\nTEST 4: Student Registration"
        );

        Student student1 =
                new Student(
                        "Utkarsh",
                        "utkarsh@vit.ac.in",
                        "S101"
                );

        try {

            registrationManager.registerStudent(
                    student1,
                    event
            );

            System.out.println(
                    "PASS - Student registered successfully."
            );

        } catch (Exception e) {

            System.out.println(
                    "FAIL - Registration failed."
            );
        }


        // =================================================
        // TEST 5 : DUPLICATE REGISTRATION
        // =================================================

        System.out.println(
                "\nTEST 5: Duplicate Registration"
        );

        try {

            registrationManager.registerStudent(
                    student1,
                    event
            );

            System.out.println(
                    "FAIL - Duplicate registration allowed."
            );

        } catch (AlreadyRegisteredException e) {

            System.out.println(
                    "PASS - Duplicate registration prevented."
            );

            System.out.println(
                    "Message: " + e.getMessage()
            );

        } catch (EventFullException e) {

            System.out.println(
                    "FAIL - Wrong exception thrown."
            );
        }


        // =================================================
        // TEST 6 : SECOND STUDENT REGISTRATION
        // =================================================

        System.out.println(
                "\nTEST 6: Second Student Registration"
        );

        Student student2 =
                new Student(
                        "Student Two",
                        "student2@vit.ac.in",
                        "S102"
                );

        try {

            registrationManager.registerStudent(
                    student2,
                    event
            );

            System.out.println(
                    "PASS - Second student registered."
            );

        } catch (Exception e) {

            System.out.println(
                    "FAIL - Second registration failed."
            );
        }


        // =================================================
        // TEST 7 : EVENT FULL EXCEPTION
        // =================================================

        System.out.println(
                "\nTEST 7: Event Full Exception"
        );

        Student student3 =
                new Student(
                        "Student Three",
                        "student3@vit.ac.in",
                        "S103"
                );

        try {

            registrationManager.registerStudent(
                    student3,
                    event
            );

            System.out.println(
                    "FAIL - Registration allowed despite full event."
            );

        } catch (EventFullException e) {

            System.out.println(
                    "PASS - EventFullException handled."
            );

            System.out.println(
                    "Message: " + e.getMessage()
            );

        } catch (AlreadyRegisteredException e) {

            System.out.println(
                    "FAIL - Wrong exception thrown."
            );
        }


        // =================================================
        // TEST 8 : CANCEL REGISTRATION
        // =================================================

        System.out.println(
                "\nTEST 8: Cancel Registration"
        );

        try {

            registrationManager.cancelRegistration(
                    "REG1001"
            );

            if (event.getRegisteredCount() == 1) {

                System.out.println(
                        "PASS - Registration cancelled."
                );

            } else {

                System.out.println(
                        "FAIL - Event count not updated."
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "FAIL - Cancellation failed."
            );
        }


        // =================================================
        // FINAL RESULT
        // =================================================

        System.out.println("\n======================================");
        System.out.println("         TESTING COMPLETED");
        System.out.println("======================================");

        System.out.println(
                "Total registrations currently: "
                        + registrationManager
                        .getRegistrations()
                        .size()
        );

        System.out.println(
                "Available seats: "
                        + event.getAvailableSeats()
        );
    }
}