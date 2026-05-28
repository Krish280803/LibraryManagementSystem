package com.library.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {

    // ArrayList to store books
    private List<Book> books = new ArrayList<>();

    // HashMap to store users
    private Map<Integer, User> users = new HashMap<>();

    // Check Duplicate Book ID
    public boolean checkBookExists(int bookId) {

        return books.stream()
                .anyMatch(book ->
                        book.getBookId() == bookId);
    }

    // Add Book
    public void addBook(Book book) {

        books.add(book);

        System.out.println(book.getTitle()
                + " added successfully.");
    }

    // Add User
    public void addUser(User user) {

        users.put(user.getUserId(), user);

        System.out.println(user.getUserName()
                + " registered successfully.");
    }

    // Display All Books
    public void displayBooks() {

        System.out.println("\n===== ALL BOOKS =====");

        if (books.isEmpty()) {

            System.out.println("No books available.");

        } else {

            // Lambda Expression
            books.forEach(System.out::println);
        }
    }

    // Issue Book
    public void issueBook(int bookId)
            throws InvalidBookOperationException {

        Book book = findBookById(bookId);

        if (book == null) {

            throw new InvalidBookOperationException(
                    "Book not found.");
        }

        if (book.isIssued()) {

            throw new InvalidBookOperationException(
                    "Book already issued.");
        }

        book.setIssued(true);

        System.out.println(book.getTitle()
                + " issued successfully.");
    }

    // Return Book
    public void returnBook(int bookId)
            throws InvalidBookOperationException {

        Book book = findBookById(bookId);

        if (book == null) {

            throw new InvalidBookOperationException(
                    "Book not found.");
        }

        if (!book.isIssued()) {

            throw new InvalidBookOperationException(
                    "Book was not issued.");
        }

        book.setIssued(false);

        System.out.println(book.getTitle()
                + " returned successfully.");
    }

    // Search Book by ID or Name
    public void searchBook(String keyword) {

        List<Book> result = books.stream()
                .filter(book ->
                        String.valueOf(book.getBookId())
                                .equals(keyword)
                                || book.getTitle()
                                .toLowerCase()
                                .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\n===== SEARCH RESULT =====");

        if (result.isEmpty()) {

            System.out.println("No books found.");

        } else {

            result.forEach(System.out::println);
        }
    }

    // Find Book by ID
    private Book findBookById(int bookId) {

        return books.stream()
                .filter(book ->
                        book.getBookId() == bookId)
                .findFirst()
                .orElse(null);
    }
}