/**
 * Main class for the Library Management System (LMS).
 *  
 * Name: Carlos Campos
 * Course: Software Development
 * Date: September 22, 2024
 *
 * This class contains the main method that runs the Library Management System.
 * The system allows users to add books to the library from a file, remove a book by its ID, barcode, or title,
 * check in or check out a book, and list all books in the library. The program runs as a console-based application
 * with a simple menu-driven interface.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Get file path from the user and load books into the library
        System.out.print("Enter file path to load books: ");
        String filePath = scanner.nextLine();
        library.addBooksFromFile(filePath);
        System.out.println("Books added from file. Printing the database:");
        library.listBooks();

        // Remove a book by Barcode
        System.out.print("Enter barcode to remove a book: ");
        String barcode = scanner.nextLine();
        if (library.removeBookByBarcode(barcode)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
        library.listBooks();

        // Remove a book by Title
        System.out.print("Enter title to remove a book: ");
        String titleToRemove = scanner.nextLine();
        if (library.removeBookByTitle(titleToRemove)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
        library.listBooks();

        // Check out a book by Title
        System.out.print("Enter title to check out a book: ");
        String titleToCheckout = scanner.nextLine();
        if (library.checkOutBook(titleToCheckout)) {
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Book not found or already checked out.");
        }
        library.listBooks();

        // Check in a book by Title
        System.out.print("Enter title to check in a book: ");
        String titleToCheckIn = scanner.nextLine();
        if (library.checkInBook(titleToCheckIn)) {
            System.out.println("Book checked in successfully.");
        } else {
            System.out.println("Book not found or already checked in.");
        }
        library.listBooks();

        // Exit the program
        scanner.close();
    }
}
