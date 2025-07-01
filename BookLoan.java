package librarymanagementsystem;

import java.time.LocalDate;
import java.util.UUID;

public class BookLoan {
    private final String loanId;
    private final BookInstance bookInstance;
    private final LibraryMember borrower;
    private final LocalDate issueDate;
    private final LocalDate dueDate;
    private boolean isActive = true;

    private static final int MAX_LOAN_DAYS = 14;

    public BookLoan(BookInstance bookInstance, LibraryMember borrower) {
        this.loanId = UUID.randomUUID().toString();
        this.bookInstance = bookInstance;
        this.borrower = borrower;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(MAX_LOAN_DAYS);
    }

    public void closeLoan() {
        bookInstance.returnCopy();
        borrower.removeLoan(this);
        isActive = false;
    }

    public String getLoanId() {
        return loanId;
    }

    public BookInstance getBookInstance() {
        return bookInstance;
    }

    public LibraryMember getBorrower() {
        return borrower;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isActive() {
        return isActive;
    }
}
