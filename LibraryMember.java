package librarymanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class LibraryMember {
    private final String memberId;
    private final String name;
    private final String contactInfo;
    private final List<BookLoan> activeLoans;

    private static final int MAX_ALLOWED_BOOKS = 5;

    public LibraryMember(String name, String contactInfo) {
        this.memberId = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = contactInfo;
        this.activeLoans = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized boolean canBorrow() {
        return activeLoans.size() < MAX_ALLOWED_BOOKS;
    }

    public synchronized void addLoan(BookLoan loan) {
        activeLoans.add(loan);
    }

    public synchronized void removeLoan(BookLoan loan) {
        activeLoans.remove(loan);
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<BookLoan> getActiveLoans() {
        return new ArrayList<>(activeLoans); 
    }
}
