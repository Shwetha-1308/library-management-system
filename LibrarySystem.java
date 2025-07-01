package librarymanagementsystem;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LibrarySystem {
    private static LibrarySystem instance;
    private final BookCatalog catalog;
    private final Map<String, LibraryMember> members;
    private final Map<String, BookLoan> loans;

    private LibrarySystem() {
        catalog = new BookCatalog();
        members = new ConcurrentHashMap<>();
        loans = new ConcurrentHashMap<>();
    }

    public static synchronized LibrarySystem getInstance() {
        if (instance == null) {
            instance = new LibrarySystem();
        }
        return instance;
    }

    public void addNewBook(Book book) {
        BookInstance copy = new BookInstance(book);
        catalog.addBookInstance(copy);
    }

    public LibraryMember registerMember(String name, String contactInfo) {
        LibraryMember member = new LibraryMember(name, contactInfo);
        members.put(member.getMemberId(), member);
        return member;
    }

    public synchronized BookLoan issueBook(String memberId, String title) {
        LibraryMember member = members.get(memberId);
        if (member == null || !member.canBorrow()) {
            throw new RuntimeException("Member not allowed to borrow");
        }

        List<BookInstance> availableCopies = catalog.getCopiesByTitle(title);
        for (BookInstance copy : availableCopies) {
            if (copy.isAvailable()) {
                copy.issue();
                BookLoan loan = new BookLoan(copy, member);
                member.addLoan(loan);
                loans.put(loan.getLoanId(), loan);
                System.out.println("Issued: " + copy.getBookDetails().getTitle() + " to " + member.getName());
                return loan;
            }
        }

        throw new RuntimeException("No available copy to issue");
    }

    public synchronized void returnBook(String loanId) {
        BookLoan loan = loans.get(loanId);
        if (loan != null) {
            loan.closeLoan();
        } else {
            throw new RuntimeException("Invalid loan ID");
        }
    }

    public List<Book> searchBooksByTitle(String title) {
        return catalog.findBooksByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return catalog.findBooksByAuthor(author);
    }
}
