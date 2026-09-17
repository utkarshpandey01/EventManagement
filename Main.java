import model.*;
import service.*;
import exception.*;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static EventManager eventManager =
            new EventManager();

    static RegistrationManager registrationManager =
            new RegistrationManager();

    static ReportManager reportManager =
            new ReportManager();

    static Organizer organizer =
            new Organizer(
                    "VIT Event Team",
                    "events@vitbhopal.ac.in",
                    "O001"
            );


    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        createSampleEvents();

        System.out.println(
                "\n========================================"
        );

        System.out.println(
                "       VIT EVENT MANAGEMENT SYSTEM"
        );

        System.out.println(
                "========================================"
        );

        while (true) {

            System.out.println(
                    "\n--------------- MAIN MENU ---------------"
            );

            System.out.println(
                    "1. Student"
            );

            System.out.println(
                    "2. Organizer"
            );

            System.out.println(
                    "3. Exit"
            );

            System.out.print(
                    "\nEnter choice: "
            );

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    studentMenu();
                    break;

                case 2:
                    organizerMenu();
                    break;

                case 3:
                    System.out.println(
                            "\nThank you for using VIT Event Management System!"
                    );

                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "\nInvalid choice!"
                    );
            }
        }
    }


    // =========================================================
    // STUDENT MENU
    // =========================================================

    static void studentMenu() {

        System.out.print(
                "\nEnter Student ID: "
        );

        String studentId = scanner.nextLine();

        System.out.print(
                "Enter Student Name: "
        );

        String studentName = scanner.nextLine();

        System.out.print(
                "Enter Student Email: "
        );

        String email = scanner.nextLine();

        Student student =
                new Student(
                        studentName,
                        email,
                        studentId
                );

        while (true) {

            System.out.println(
                    "\n------------- STUDENT MENU -------------"
            );

            System.out.println(
                    "1. View All Events"
            );

            System.out.println(
                    "2. Register for Event"
            );

            System.out.println(
                    "3. View My Registrations"
            );

            System.out.println(
                    "4. Search Event"
            );

            System.out.println(
                    "5. Cancel Registration"
            );

            System.out.println(
                    "6. Back"
            );

            System.out.print(
                    "\nEnter choice: "
            );

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    eventManager.displayAllEvents();

                    break;


                case 2:

                    eventManager.displayAllEvents();

                    System.out.print(
                            "\nEnter Event ID: "
                    );

                    String eventId =
                            scanner.nextLine();

                    try {

                        Event event =
                                eventManager
                                        .findEvent(eventId);

                        registrationManager
                                .registerStudent(
                                        student,
                                        event
                                );

                    }
                    catch (
                            EventNotFoundException |
                            EventFullException |
                            AlreadyRegisteredException e
                    ) {

                        System.out.println(
                                "\nERROR: "
                                        + e.getMessage()
                        );
                    }

                    break;


                case 3:

                    registrationManager
                            .displayStudentRegistrations(
                                    student
                            );

                    break;


                case 4:

                    System.out.print(
                            "\nEnter event name to search: "
                    );

                    String search =
                            scanner.nextLine();

                    eventManager.searchEvent(search);

                    break;


                case 5:

                    registrationManager
                            .displayStudentRegistrations(
                                    student
                            );

                    System.out.print(
                            "\nEnter Registration ID to cancel: "
                    );

                    String registrationId =
                            scanner.nextLine();

                    try {

                        registrationManager
                                .cancelRegistration(
                                        registrationId
                                );

                    }
                    catch (Exception e) {

                        System.out.println(
                                "\nERROR: " + e.getMessage()
                        );
                    }

                    break;


                case 6:

                    return;


                default:

                    System.out.println(
                            "\nInvalid choice!"
                    );
            }
        }
    }


    // =========================================================
    // ORGANIZER MENU
    // =========================================================

    static void organizerMenu() {

        while (true) {

            System.out.println(
                    "\n------------ ORGANIZER MENU ------------"
            );

            System.out.println(
                    "1. View All Events"
            );

            System.out.println(
                    "2. Add Event"
            );

            System.out.println(
                    "3. Update Event"
            );

            System.out.println(
                    "4. Delete Event"
            );

            System.out.println(
                    "5. View Event Report"
            );

            System.out.println(
                    "6. View Registration Report"
            );

            System.out.println(
                    "7. Back"
            );

            System.out.print(
                    "\nEnter choice: "
            );

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    eventManager.displayAllEvents();

                    break;


                case 2:

                    createNewEvent();

                    break;


                case 3:

                    updateEvent();

                    break;


                case 4:

                    deleteEvent();

                    break;


                case 5:

                    reportManager
                            .generateEventReport(
                                    eventManager.getEvents()
                            );

                    break;


                case 6:

                    reportManager
                            .generateRegistrationReport(
                                    registrationManager
                                            .getRegistrations()
                            );

                    break;


                case 7:

                    return;


                default:

                    System.out.println(
                            "\nInvalid choice!"
                    );
            }
        }
    }


    // =========================================================
    // CREATE NEW EVENT
    // =========================================================

    static void createNewEvent() {

        System.out.println(
                "\n========== CREATE EVENT =========="
        );

        System.out.print(
                "Enter Event ID: "
        );

        String eventId =
                scanner.nextLine();

        System.out.print(
                "Enter Event Name: "
        );

        String eventName =
                scanner.nextLine();

        System.out.print(
                "Enter Description: "
        );

        String description =
                scanner.nextLine();

        System.out.print(
                "Enter Date: "
        );

        String date =
                scanner.nextLine();

        System.out.print(
                "Enter Venue Name: "
        );

        String venueName =
                scanner.nextLine();

        System.out.print(
                "Enter Venue Location: "
        );

        String location =
                scanner.nextLine();

        System.out.print(
                "Enter Capacity: "
        );

        int capacity =
                scanner.nextInt();

        scanner.nextLine();

        Venue venue =
                new Venue(
                        venueName,
                        location
                );

        Event event =
                new Event(
                        eventId,
                        eventName,
                        description,
                        date,
                        venue,
                        capacity,
                        organizer
                );

        eventManager.addEvent(event);
    }


    // =========================================================
    // UPDATE EVENT
    // =========================================================

    static void updateEvent() {

        eventManager.displayAllEvents();

        System.out.print(
                "\nEnter Event ID to update: "
        );

        String eventId =
                scanner.nextLine();

        try {

            // Verify the event exists before prompting for changes
            eventManager.findEvent(eventId);

            System.out.print(
                    "Enter new Event Name: "
            );

            String name =
                    scanner.nextLine();

            System.out.print(
                    "Enter new Description: "
            );

            String description =
                    scanner.nextLine();

            System.out.print(
                    "Enter new Date: "
            );

            String date =
                    scanner.nextLine();

            System.out.print(
                    "Enter new Venue Name: "
            );

            String venueName =
                    scanner.nextLine();

            System.out.print(
                    "Enter new Venue Location: "
            );

            String location =
                    scanner.nextLine();

            System.out.print(
                    "Enter new Capacity: "
            );

            int capacity =
                    scanner.nextInt();

            scanner.nextLine();

            Venue venue =
                    new Venue(
                            venueName,
                            location
                    );

            eventManager.updateEvent(
                    eventId,
                    name,
                    description,
                    date,
                    venue,
                    capacity
            );

        }
        catch (EventNotFoundException e) {

            System.out.println(
                    "\nERROR: "
                            + e.getMessage()
            );
        }
    }


    // =========================================================
    // DELETE EVENT
    // =========================================================

    static void deleteEvent() {

        eventManager.displayAllEvents();

        System.out.print(
                "\nEnter Event ID to delete: "
        );

        String eventId =
                scanner.nextLine();

        try {

            eventManager.deleteEvent(
                    eventId
            );

        }
        catch (EventNotFoundException e) {

            System.out.println(
                    "\nERROR: "
                            + e.getMessage()
            );
        }
    }


    // =========================================================
    // SAMPLE EVENTS
    // =========================================================

    static void createSampleEvents() {


        // -----------------------------------------------------
        // EVENT 1
        // -----------------------------------------------------

        Venue venue1 =
                new Venue(
                        "AB1 Auditorium",
                        "VIT Bhopal"
                );

        Event event1 =
                new Event(
                        "E101",
                        "AI Workshop",
                        "Introduction to Artificial Intelligence",
                        "25-09-2026",
                        venue1,
                        100,
                        organizer
                );

        eventManager.addEvent(event1);


        // -----------------------------------------------------
        // EVENT 2
        // -----------------------------------------------------

        Venue venue2 =
                new Venue(
                        "Innovation Lab",
                        "VIT Bhopal"
                );

        Event event2 =
                new Event(
                        "E102",
                        "Coding Contest",
                        "Competitive Programming Challenge",
                        "28-09-2026",
                        venue2,
                        50,
                        organizer
                );

        eventManager.addEvent(event2);


        // -----------------------------------------------------
        // EVENT 3
        // -----------------------------------------------------

        Venue venue3 =
                new Venue(
                        "Main Auditorium",
                        "VIT Bhopal"
                );

        Event event3 =
                new Event(
                        "E103",
                        "Hackathon 2026",
                        "24 Hour Software and Innovation Hackathon",
                        "02-10-2026",
                        venue3,
                        150,
                        organizer
                );

        eventManager.addEvent(event3);


        // -----------------------------------------------------
        // EVENT 4
        // -----------------------------------------------------

        Venue venue4 =
                new Venue(
                        "Seminar Hall",
                        "VIT Bhopal"
                );

        Event event4 =
                new Event(
                        "E104",
                        "Robotics Workshop",
                        "Hands-on Robotics and Automation Workshop",
                        "05-10-2026",
                        venue4,
                        60,
                        organizer
                );

        eventManager.addEvent(event4);


        // -----------------------------------------------------
        // EVENT 5
        // -----------------------------------------------------

        Venue venue5 =
                new Venue(
                        "AB2 Auditorium",
                        "VIT Bhopal"
                );

        Event event5 =
                new Event(
                        "E105",
                        "Tech Talk",
                        "Future of Technology and Artificial Intelligence",
                        "10-10-2026",
                        venue5,
                        120,
                        organizer
                );

        eventManager.addEvent(event5);


        // -----------------------------------------------------
        // EVENT 6
        // -----------------------------------------------------

        Venue venue6 =
                new Venue(
                        "Sports Complex",
                        "VIT Bhopal"
                );

        Event event6 =
                new Event(
                        "E106",
                        "Sports Fest",
                        "Inter-College Sports Competition",
                        "15-10-2026",
                        venue6,
                        200,
                        organizer
                );

        eventManager.addEvent(event6);


        // -----------------------------------------------------
        // EVENT 7
        // -----------------------------------------------------

        Venue venue7 =
                new Venue(
                        "Innovation Lab",
                        "VIT Bhopal"
                );

        Event event7 =
                new Event(
                        "E107",
                        "Web Development Workshop",
                        "Learn Modern Web Development with HTML, CSS and JavaScript",
                        "18-10-2026",
                        venue7,
                        80,
                        organizer
                );

        eventManager.addEvent(event7);


        // -----------------------------------------------------
        // EVENT 8
        // -----------------------------------------------------

        Venue venue8 =
                new Venue(
                        "AB1 Seminar Hall",
                        "VIT Bhopal"
                );

        Event event8 =
                new Event(
                        "E108",
                        "Entrepreneurship Summit",
                        "Startup, Business and Entrepreneurship Summit",
                        "22-10-2026",
                        venue8,
                        100,
                        organizer
                );

        eventManager.addEvent(event8);
    }
}