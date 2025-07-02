package librarymanagementsystem;

import java.util.List;

public class LibrarySystemDemo {
    public static void run() {
        LibrarySystem librarySystem = LibrarySystem.getInstance();

        // Add book copies to the catalog
        BookInstance copy1 = librarySystem.addBookCopy("ISBN1", "Book 1", "Author 1");
        BookInstance copy2 = librarySystem.addBookCopy("ISBN2", "Book 2", "Author 1");
        BookInstance copy3 = librarySystem.addBookCopy("ISBN3", "Book 3", "Author 3");

        // Register members
        LibraryMember member1 = librarySystem.registerMember("John Doe", "john@example.com");
        LibraryMember member2 = librarySystem.registerMember("Jane Smith", "jane@example.com");

        // Borrow books
        librarySystem.issueBook(member1.getMemberId(), copy1.getCopyId());
        librarySystem.issueBook(member2.getMemberId(), copy2.getCopyId());

        // Return books
        librarySystem.returnBookByCopy(member1.getMemberId(), copy1.getCopyId());

        // Search books by author
        List<Book> searchResults = librarySystem.searchBooksByAuthor("Author 1");
        System.out.println("Search Results for Author 1:");
        for (Book book : searchResults) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
}
