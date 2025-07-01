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


