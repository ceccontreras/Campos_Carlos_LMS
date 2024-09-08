/**
 * Library class to manage a collection of books.
 *
 * The Library class handles the addition, removal, and listing of books.
 * Books can be added from a file, removed by ID, and all books in the collection
 * can be displayed.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>(); // List to store books in the library
    }

    /**
     * addBooksFromFile method to add books to the library from a text file.
     *
     * This method reads a file line by line, where each line contains book details
     * in the format "ID, Title, Author". It then adds the books to the library.
     *
     * @param filePath The file path of the text file containing book details
     */
    public void addBooksFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    int id = Integer.parseInt(details[0].trim());
                    String title = details[1].trim();
                    String author = details[2].trim();
                    books.add(new Book(id, title, author));
                }
            }
        } catch (IOException e) {
            // Handle file reading errors
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * removeBookById method to remove a book from the collection using its ID.
     *
     * This method iterates through the list of books and removes the book that
     * matches the provided ID.
     *
     * @param id The ID of the book to remove
     * @return true if the book was removed, false if the book was not found
     */
    public boolean removeBookById(int id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove(); // Remove the book from the collection
                return true;
            }
        }
        return false;
    }

    /**
     * listBooks method to display all books currently in the collection.
     *
     * This method iterates through the list of books and prints their details
     * to the console. If there are no books, a message indicating that is shown.
     */
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the collection.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}