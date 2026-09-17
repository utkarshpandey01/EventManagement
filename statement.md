# Project Statement

## 1. Problem Statement

Managing college events involves keeping track of event details, available seats, student registrations, cancellations, and organizer activities. Handling these operations manually can make it difficult to maintain accurate registration information and prevent issues such as duplicate registrations or registrations beyond the available capacity.

The VIT Event Management System provides a console-based Java solution for organizing these activities in a structured way. It allows students to browse and register for events while providing organizers with tools to create, update, delete, and manage events.

---

## 2. Scope of the Project

The project focuses on the core operations required for managing college events and student registrations.

The system covers:

* Creating and managing events
* Viewing and searching events
* Managing event capacity
* Student event registration
* Preventing duplicate registrations
* Cancelling registrations
* Tracking registered and available seats
* Generating event and registration reports
* Handling common errors using custom exceptions

The current version is a console-based Java application and stores application data during runtime using Java collections. Persistent database storage and a graphical/web interface are outside the scope of the current version.

---

## 3. Target Users

### Students

Students use the system to:

* View available college events
* Search for events
* Register for events
* View their registrations
* Cancel registrations

### Organizers

Organizers use the system to:

* Create new events
* Update event information
* Delete events
* Manage event capacity
* View event information
* Generate reports related to events and registrations

---

## 4. High-Level Features

* **Event Management** — Create, update, search, view, and delete events.
* **Student Registration** — Register students for available events.
* **Capacity Management** — Track event capacity and available seats.
* **Duplicate Registration Prevention** — Prevent a student from registering for the same event more than once.
* **Registration Cancellation** — Allow students to cancel existing registrations.
* **Exception Handling** — Handle conditions such as unavailable events, full events, and duplicate registrations.
* **Reporting** — Generate event and registration-related reports.
* **Role-Based Operations** — Provide separate workflows for students and organizers.
