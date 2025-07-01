package librarymanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookCatalog {
    private final Map<String, List<BookInstance>> titleIndex = new HashMap<>();
    private final Map<String, List<BookInstance>> authorIndex = new HashMap<>();
    private final Map<String, List<BookInstance>> isbnIndex = new HashMap<>();

    public synchronized void addBookInstance(BookInstance instance) {
        Book book = instance.getBookDetails();
        titleIndex.computeIfAbsent(book.getTitle(), k -> new ArrayList<>()).add(instance);
        authorIndex.computeIfAbsent(book.getAuthor(), k -> new ArrayList<>()).add(instance);
        isbnIndex.computeIfAbsent(book.getIsbn(), k -> new ArrayList<>()).add(instance);
    }

    public synchronized List<BookInstance> getCopiesByTitle(String title) {
        return titleIndex.getOrDefault(title, List.of());
    }

    public synchronized List<Book> findBooksByTitle(String title) {
        return titleIndex.getOrDefault(title, List.of()).stream()
                .map(BookInstance::getBookDetails)
                .distinct()
                .toList();
    }

    public synchronized List<Book> findBooksByAuthor(String author) {
        return authorIndex.getOrDefault(author, List.of()).stream()
                .map(BookInstance::getBookDetails)
                .distinct()
                .toList();
    }

    public synchronized List<Book> findBooksByIsbn(String isbn) {
        return isbnIndex.getOrDefault(isbn, List.of()).stream()
                .map(BookInstance::getBookDetails)
                .distinct()
                .toList();
    }
}
