# Event Management System

A console-based Java application for managing college events, student registrations, event capacity, and organizer operations.

The project was built as a practical implementation of **Object-Oriented Programming (OOP)** concepts in Java, with separate workflows for students and organizers.

---

## 📌 Overview

Managing college events manually can become messy when there are multiple events, limited seats, student registrations, cancellations, and organizers trying to keep track of everything.

This project provides a simple command-line system where:

* Students can browse and search available events
* Students can register for events and cancel registrations
* Organizers can create, update, and delete events
* Event capacity is automatically tracked
* Duplicate registrations are prevented
* Organizers can generate event and registration reports
* Custom exceptions are used to handle common errors

The application currently uses Java collections for runtime data storage and does not require an external database.

---

## ✨ Features

### 👨‍🎓 Student Operations

* View available events
* Search events
* Register for an event
* View registered events
* Cancel a registration
* Prevent duplicate registrations
* Check event availability

### 🧑‍💼 Organizer Operations

* Add new events
* Update event details
* Delete events
* View event information
* Generate event reports
* Generate registration reports

### ⚙️ System Features

* Event capacity management
* Case-insensitive event search
* Custom exception handling
* Input validation
* Registration ID generation
* Modular class structure
* Separate service and model classes

---

## 🛠️ Technologies Used

| Technology         | Usage                    |
| ------------------ | ------------------------ |
| Java               | Core application         |
| OOP                | Application architecture |
| ArrayList          | Runtime data storage     |
| Exception Handling | Error management         |
| File Handling      | Data handling structure  |
| Git/GitHub         | Version control          |

---

## 🧠 OOP Concepts Used

The project was designed around core Java OOP concepts rather than putting the entire application into a single class.

### Abstraction

`User` is implemented as an abstract class, with `Student` and `Organizer` extending it.

### Inheritance

```text
User
├── Student
└── Organizer
```

### Encapsulation

Classes such as `Event`, `Venue`, and `Registration` keep their data and related operations organized within the class.

### Polymorphism

Common user functionality can be handled through the parent `User` type while allowing student and organizer objects to provide their own behavior.

### Composition

Classes such as `Event` use other objects such as `Venue` to represent related information.

### Exception Handling

The application uses custom exceptions for situations such as:

* Event not found
* Event is full
* Student already registered

---

## 🏗️ Project Structure

```text
VIT-Event-Management-System/
│
├── src/
│   ├── Main.java
│   ├── TestRunner.java
│   │
│   ├── model/
│   │   ├── User.java
│   │   ├── Student.java
│   │   ├── Organizer.java
│   │   ├── Event.java
│   │   ├── Venue.java
│   │   └── Registration.java
│   │
│   ├── service/
│   │   ├── EventManager.java
│   │   ├── RegistrationManager.java
│   │   └── ReportManager.java
│   │
│   ├── exception/
│   │   ├── EventNotFoundException.java
│   │   ├── EventFullException.java
│   │   └── AlreadyRegisteredException.java
│   │
│   └── util/
│       └── FileHandler.java
│
└── README.md
```

---

## 🔄 How It Works

The basic workflow is:

```text
Start Application
       │
       ▼
Choose User Role
   ┌───┴────┐
   ▼        ▼
Student   Organizer
   │        │
   ▼        ▼
Browse     Manage
Events     Events
   │        │
   ▼        ▼
Register   Reports
   │
   ▼
Check Capacity
   │
   ▼
Registration Created
```

When a student registers:

1. The requested event is searched using its ID.
2. The system checks whether the student has already registered.
3. Available capacity is checked.
4. A registration is created.
5. The event's registered count is updated.

If any condition fails, the appropriate exception is triggered.

---

## 📅 Sample Events

The application comes with sample event data for demonstration.

| ID   | Event                    | Date       | Venue            | Capacity |
| ---- | ------------------------ | ---------- | ---------------- | -------: |
| E101 | AI Workshop              | 25-09-2026 | AB1 Auditorium   |      100 |
| E102 | Coding Contest           | 28-09-2026 | Innovation Lab   |       50 |
| E103 | Hackathon 2026           | 02-10-2026 | Main Auditorium  |      150 |
| E104 | Robotics Workshop        | 05-10-2026 | Seminar Hall     |       60 |
| E105 | Tech Talk                | 10-10-2026 | AB2 Auditorium   |      120 |
| E106 | Sports Fest              | 15-10-2026 | Sports Complex   |      200 |
| E107 | Web Development Workshop | 18-10-2026 | Innovation Lab   |       80 |
| E108 | Entrepreneurship Summit  | 22-10-2026 | AB1 Seminar Hall |      100 |

---

## 🧪 Testing

A separate `TestRunner` class is included to test important application scenarios.

The test cases cover:

* Adding an event
* Searching for an existing event
* Handling an invalid event
* Registering a student
* Detecting duplicate registration
* Registering multiple students
* Handling a full event
* Cancelling a registration

This helps verify the main registration and event-management logic independently from the main application flow.

---

## ▶️ Running the Project

### 1. Clone the repository

```bash
git clone <repository-url>
cd VIT-Event-Management-System
```

### 2. Compile the Java files

Compile the source files using your preferred Java IDE or command line.

### 3. Run the application

Run:

```text
Main.java
```

### 4. Run the tests

Run:

```text
TestRunner.java
```

> **Note:** The project is currently a console-based application and does not require a separate database setup.

---

## 📊 Data Handling

The current implementation stores events and registrations using Java `ArrayList` collections during runtime.

```text
EventManager
     │
     └── ArrayList<Event>

RegistrationManager
     │
     └── ArrayList<Registration>
```

A `FileHandler` utility is also included as part of the project structure for file-based data handling.

---

## 🚧 Current Limitations

This version is intentionally focused on demonstrating the core event-management logic and OOP concepts.

Some areas that can be improved in future versions include:

* Persistent database storage
* User authentication
* Graphical/web interface
* Email or notification system
* Event reminders
* Better input handling
* Deployment as a web application

---

## 🚀 Future Improvements

Possible future versions could include:

* **MySQL/PostgreSQL** for persistent storage
* **Spring Boot** backend
* REST APIs for event management
* Web or Android frontend
* Student login and authentication
* QR-code based event check-in
* Automated email notifications
* Admin dashboard
* Event analytics and statistics

---

## 🎯 Learning Outcomes

This project helped in understanding how individual Java concepts can be combined to build a complete application.

Key areas covered:

* Object-Oriented Programming
* Class design
* Inheritance and abstraction
* Encapsulation and polymorphism
* Collections
* Exception handling
* Modular programming
* Basic testing
* Event-driven application logic
* Git/GitHub project management

---

## 👨‍💻 Project

**VIT Event Management System**

Built as a Java-based academic project with a focus on applying OOP concepts to a practical problem.

---

## 📄 Project Documentation

A detailed project report is included separately, covering the system architecture, requirements, design diagrams, implementation details, testing approach, challenges, and future enhancements.

---

⭐ If you find the project useful or want to build on it, feel free to fork the repository and experiment with it.
