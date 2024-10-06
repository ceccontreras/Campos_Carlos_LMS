/**
 * Library class manages a collection of books.
 *
 * Name: Carlos Campos
 * Course: Software Development
 * Date: September 22, 2024
 *
 * This class provides functionalities to add books to the collection,
 * remove books by ID, title, or barcode, check in or check out books,
 * and list all books currently in the collection.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor initializes the books list
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * addBooksFromFile method reads books from a text file and adds them to the collection.
     *
     * @param filePath The file path of the text file containing book details.
     * @throws IOException if there's an error reading the file.
     */
    public void addBooksFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 4) {
                    int id = Integer.parseInt(details[0].trim());
                    String title = details[1].trim();
                    String author = details[2].trim();
                    String barcode = details[3].trim();
                    books.add(new Book(id, title, author, barcode));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * removeBookById method removes a book from the collection using its ID.
     *
     * @param id The ID of the book to remove.
     * @return true if the book was removed, false if the book was not found.
     */
    public boolean removeBookById(int id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * removeBookByTitle method removes a book from the collection using its title.
     *
     * @param title The title of the book to remove.
     * @return true if the book was removed, false if the book was not found.
     */
    public boolean removeBookByTitle(String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * removeBookByBarcode method removes a book from the collection using its barcode.
     *
     * @param barcode The barcode of the book to remove.
     * @return true if the book was removed, false if the book was not found.
     */
    public boolean removeBookByBarcode(String barcode) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBarcode().equals(barcode)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * checkOutBook method checks out a book by its title.
     *
     * @param title The title of the book to check out.
     * @return true if the book was successfully checked out, false if the book is already checked
     * out or not found.
     */
    public boolean checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.getStatus().equals("checked out")) {
                    System.out.println("Error: Book is already checked out.");
                    return false;
                }
                book.setStatus("checked out");
                book.setDueDate(LocalDate.now().plusWeeks(4)); // 4 weeks from today
                return true;
            }
        }
        return false;
    }

    /**
     * checkInBook method checks in a book by its title.
     *
     * @param title The title of the book to check in.
     * @return true if the book was successfully checked in, false if the book is already checked
     * in or not found.
     */
    public boolean checkInBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.getStatus().equals("checked in")) {
                    System.out.println("Error: Book is already checked in.");
                    return false;
                }
                book.setStatus("checked in");
                book.setDueDate(null);
                return true;
            }
        }
        return false;
    }

    /**
     * listBooks method prints all books currently in the library's collection.
     * If no books are in the collection, a message indicating so will be displayed.
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