/**
 * Main class for the Library Management System (LMS)
 * Name: Carlos Campos
 * Course: Software Development
 * Date: 2024-09-07
 *
 * This class contains the main method that runs the Library Management System.
 * The system allows users to add books to the library from a file, remove a book
 * by its ID, and list all books in the library. The program runs as a console-based
 * application with a simple menu-driven interface.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add books from file");
            System.out.println("2. Remove a book by ID");
            System.out.println("3. List all books");
            System.out.println("4. Exit");

            int choice = -1;
            // Loop to ensure valid integer input for menu choice
            while (choice == -1) {
                System.out.print("Enter your choice: ");
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    // Handle non-integer inputs
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                    scanner.nextLine(); // Clear the invalid input from the scanner buffer
                }
            }

            // Switch case to handle different menu options
            switch (choice) {
                case 1:
                    System.out.print("Enter file path: ");
                    scanner.nextLine();
                    String filePath = scanner.nextLine();
                    library.addBooksFromFile(filePath);
                    break;
                case 2:
                    System.out.print("Enter book ID to remove: ");
                    int id = -1;
                    // Loop to ensure valid integer input for book ID
                    while (id == -1) {
                        try {
                            id = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid book ID (integer).");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }
                    if (library.removeBookById(id)) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    library.listBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
