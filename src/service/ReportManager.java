package service;

import model.Event;
import model.Registration;

import java.util.ArrayList;

public class ReportManager {

    public void generateEventReport(
            ArrayList<Event> events) {

        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "          EVENT REPORT"
        );

        System.out.println(
                "======================================"
        );

        if (events.isEmpty()) {

            System.out.println("No events available.");
            return;
        }

        int totalCapacity = 0;
        int totalRegistrations = 0;

        Event mostPopular = events.get(0);

        for (Event event : events) {

            totalCapacity += event.getCapacity();

            totalRegistrations +=
                    event.getRegisteredCount();

            if (event.getRegisteredCount()
                    > mostPopular.getRegisteredCount()) {

                mostPopular = event;
            }
        }

        System.out.println(
                "Total Events       : "
                        + events.size()
        );

        System.out.println(
                "Total Capacity     : "
                        + totalCapacity
        );

        System.out.println(
                "Total Registrations: "
                        + totalRegistrations
        );

        System.out.println(
                "Most Popular Event : "
                        + mostPopular.getEventName()
        );

        System.out.println(
                "Popular Event Count: "
                        + mostPopular.getRegisteredCount()
        );

        System.out.println(
                "======================================"
        );
    }

    public void generateRegistrationReport(
            ArrayList<Registration> registrations) {

        System.out.println(
                "\n===== REGISTRATION REPORT ====="
        );

        System.out.println(
                "Total Registrations: "
                        + registrations.size()
        );

        for (Registration registration :
                registrations) {

            System.out.println(
                    registration.getRegistrationId()
                            + " | "
                            + registration.getStudent().getName()
                            + " | "
                            + registration.getEvent()
                            .getEventName()
            );
        }
    }
}