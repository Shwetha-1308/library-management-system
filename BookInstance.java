package librarymanagementsystem;

import java.util.UUID;

public class BookInstance {
    private final String copyId;
    private final Book bookDetails;
    private boolean available;

    public BookInstance(Book bookDetails) {
        this.copyId = UUID.randomUUID().toString();
        this.bookDetails = bookDetails;
        this.available = true;
    }

    public synchronized boolean isAvailable() {
        return available;
    }

    public synchronized void issue() {
        if (!available) {
            throw new IllegalStateException("Book copy is already issued");
        }
        available = false;
    }

    public synchronized void returnCopy() {
        available = true;
    }

    public Book getBookDetails() {
        return bookDetails;
    }

    public String getCopyId() {
        return copyId;
    }
}
