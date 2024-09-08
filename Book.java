/**
 * Book class represents a book in the library.
 *
 * Each book has a unique ID, a title, and an author. This class stores and
 * provides access to these attributes.
 */
public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    /**
     * getId method to get the ID of the book.
     *
     * @return The ID of the book
     */
    public int getId() {
        return id;
    }

    /**
     * getTitle method to get the title of the book.
     *
     * @return The title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * getAuthor method to get the author of the book.
     *
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * toString method to return a string representation of the book.
     *
     * @return A string in the format "ID: [id], Title: [title], Author: [author]"
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}