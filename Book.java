/**
 * Book class represents a book in the library.
 *
 * Name: Carlos Campos
 * Course: Software Development
 * Date: September 22, 2024
 *
 * This class stores information about a book, including its ID, title, author,
 * barcode, status (checked in or checked out), and due date.
 * It provides methods to access and modify this information.
 */
import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String author;
    private String barcode;
    private String status;
    private LocalDate dueDate;

    public Book(int id, String title, String author, String barcode) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.barcode = barcode;
        this.status = "checked in"; // Default status
        this.dueDate = null;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getBarcode() { return barcode; }
    public String getStatus() { return status; }
    public LocalDate getDueDate() { return dueDate; }

    public void setStatus(String status) { this.status = status; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author +
                ", Barcode: " + barcode + ", Status: " + status + ", Due Date: " + dueDate;
    }
}
