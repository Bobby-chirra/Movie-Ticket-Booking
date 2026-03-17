# Movie Ticket Booking System (Java)

## Overview

This project is a console-based Movie Ticket Booking System implemented in Java. It simulates core functionalities of a real-world ticket booking platform, including theater selection, show scheduling, seat availability management, and user-specific booking history.

The system is designed with a focus on object-oriented principles, efficient data structures, and thread-safe booking operations.

---

## Features

- Support for multiple theaters and shows
- Seat selection using standard format (e.g., A1, B2)
- Real-time seat availability tracking
- Thread-safe booking to prevent double allocation
- User-specific booking history management
- Persistent storage using file I/O
- Input validation and custom exception handling

---

## Technology Stack

- **Language**: Java
- **Core Concepts**:
  - Object-Oriented Programming (Encapsulation, Abstraction)
  - Java Collections Framework (ArrayList, HashMap)
  - Concurrency control using `synchronized`
  - Custom Exception Handling
  - File I/O for persistence

---

## Project Structure

MovieBookingSystem/
│
├── Main.java              // Entry point and user interaction
├── BookingService.java   // Core business logic
├── Theater.java          // Theater abstraction with show management
├── Show.java             // Seat allocation and booking logic
├── BookingException.java // Custom exception handling
└── FileHandler.java      // File persistence layer

---

## System Design

The application follows a layered design:

- **Presentation Layer**: `Main` class (handles user input and flow control)
- **Service Layer**: `BookingService` (handles business logic)
- **Domain Layer**: `Theater`, `Show` (core entities)
- **Persistence Layer**: `FileHandler` (stores booking data)

### Data Structures

- `boolean[][]` for seat matrix  
  Enables constant-time seat availability checks (O(1))

- `HashMap<String, List<String>>` for user bookings  
  Provides efficient mapping of users to their booking history

---

## Booking Workflow

1. User selects a theater from the available list  
2. User selects a show (movie and timing)  
3. System displays seat layout  
4. User selects a seat (e.g., A1)  
5. System validates input and checks availability  
6. Seat is booked using a thread-safe method  
7. Booking is stored in memory and persisted to file  

---

## Concurrency Handling

Seat booking is implemented using synchronized methods at the `Show` class level:

public synchronized void bookSeat(String seat)


This ensures that concurrent booking attempts do not result in double booking of the same seat.

Additionally, user booking storage uses synchronized collections to maintain consistency.

---

## Exception Handling

Custom exception `BookingException` is used to handle:

- Invalid seat format
- Seat already booked
- Out-of-range seat selection

This improves code clarity and separates error handling from business logic.


---
## How to Run
to Compile -> javac *.java
to Execute -> java Main
---

## Sample Execution

==== MOVIE BOOKING SYSTEM ====

1. Book Ticket
2. View My Bookings
3. Exit

Select Theater: INOX
Select Show: Interstellar - 1:00 PM

1 2 3 4 5
A  O O O O O
B  O O O O O
C  O O O O O

Enter Seat: B3
Booking successful

## Future Enhancements

- Support for booking multiple seats in a single transaction
- Ticket cancellation functionality
- Integration with relational databases (e.g., MySQL)
- RESTful API layer using Spring Boot
- Web-based frontend (React or similar frameworks)
- User authentication and authorization

---

## Key Learnings

- Designing modular and scalable systems using OOP principles
- Implementing thread-safe operations in concurrent environments
- Efficient use of data structures for real-time systems
- Structuring applications with clear separation of concerns

---

Author
Bobby
