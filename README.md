# library-management-system
✅ Problem Statement

Design and implement a Library Management System that allows members to borrow and return books, manages book inventory and availability, tracks loan history, and enables efficient catalog search by title, author, or ISBN.

✅ Core Features

Book Inventory Management: Maintain records of all books and their physical copies.

Member Registration and Tracking: Register library members and track their loan history.

Loan Management: Track borrowed books and due dates.

Borrow/Return System: Issue and return specific book instances to/from members.

Search Catalog: Search books by title, author, or ISBN.

Thread Safety: All core operations are synchronized to ensure thread safety.

Scalability: Easily extendable for fines, reservations, notifications, etc.

✅ Core Entities

Entity	Description

LibrarySystem-Singleton system managing books, members, catalog, and loans

Book-Represents book metadata (ISBN, title, author)

BookInstance-Represents a physical copy of a Book

LibraryMember-Represents a user who can borrow books

BookLoan-Tracks a borrowing record for a specific BookInstance

BookCatalog-Maintains indexed collections of book copies and supports search

BookStatus-Enum representing the state of a book copy

✅ Class Design Overview

1. LibrarySystem
   
Type: Singleton

Fields:

BookCatalog catalog

Map<String, LibraryMember> members

Map<String, BookLoan> loans

Methods:

addNewBook(Book book)

registerMember(String name, String contactInfo)

issueBook(String memberId, String title)

returnBook(String loanId)

searchBooksByTitle(String)

searchBooksByAuthor(String)

2. Book
   
Fields:

String isbn

String title

String author

Purpose: Stores general book information 

3. BookInstance
   
Fields:

String copyId

Book bookDetails

boolean available

Methods:

issue()

returnCopy()

isAvailable()

getBookDetails()

getCopyId()


Example Usage (Java):

LibrarySystem system = LibrarySystem.getInstance();


Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");

system.addNewBook(book);


LibraryMember alice = system.registerMember("Alice", "alice@example.com");


BookLoan loan = system.issueBook(alice.getMemberId(), "Effective Java");

system.returnBook(loan.getLoanId());



