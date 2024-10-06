# Library Management System (LMS)

## Project Overview
The **Library Management System (LMS)** is a console-based application developed in Java that allows users to manage a library's book collection. The system supports adding, removing, checking out, and checking in books from a collection, all through a simple text-based interface. Future versions will include a GUI and integration with a SQLite database for persistent storage.

## Features
- **Add books** to the system from a file (ID, Title, Author, Barcode).
- **Remove books** from the system using their ID, Title, or Barcode.
- **Check out books**, setting their status to "checked out" and assigning a due date.
- **Check in books**, returning them to the available collection.
- **List all books** in the collection with their current status and due dates (if applicable).

## Project Structure
The LMS consists of three primary classes:
- **Book**: Represents a book object with attributes like ID, title, author, barcode, and status.
- **Library**: Manages the collection of books, providing methods to add, remove, check in, check out, and list books.
- **Main**: The entry point for the application, providing a text-based menu for interacting with the system.

## Example Commands
- **To add books from a file**: Enter the path to your CSV file containing book data.
- **To remove a book**: Enter the book's ID, Title, or Barcode.
- **To check out a book**: Enter the book's Title.
- **To check in a book**: Enter the book's Title.

## Future Enhancements
- **Graphical User Interface (GUI)**: The next phase will introduce a GUI for a more user-friendly experience.
- **Database Integration**: In a later phase, the system will switch from file-based data storage to using an SQL database (SQLite) for better scalability.
