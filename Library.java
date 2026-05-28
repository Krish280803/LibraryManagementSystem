package com.library.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {

    List<Book> books = new ArrayList<>();

    Map<Integer, User> users = new HashMap<>();

    // add book
    public void addBook(Book book) {

        books.add(book);

    }

    // check duplicate id
    public boolean checkBookExists(int id) {

        return books.stream()
                .anyMatch(book -> book.getBookId() == id);
    }

    // display books
    public void showBooks() {

        if (books.isEmpty()) {

            System.out.println("No books available.");
        }

        else {

            books.forEach(System.out::println);
        }
    }

    // issue book
    public void issueBook(int id)
            throws InvalidBookOperationException {

        Book book = findBook(id);

        if (book == null) {

            throw new InvalidBookOperationException(
                    "Book not found.");
        }

        if (book.isIssued()) {

            throw new InvalidBookOperationException(
                    "Book already issued.");
        }

        book.setIssued(true);

        System.out.println("Book issued successfully.");
    }

    // return book
    public void returnBook(int id)
            throws InvalidBookOperationException {

        Book book = findBook(id);

        if (book == null) {

            throw new InvalidBookOperationException(
                    "Book not found.");
        }

        if (!book.isIssued()) {

            throw new InvalidBookOperationException(
                    "Book was not issued.");
        }

        book.setIssued(false);

        System.out.println("Book returned successfully.");
    }

    // search book
    public void searchBook(String keyword) {

        List<Book> result = books.stream()
                .filter(book ->
                        String.valueOf(book.getBookId())
                                .equals(keyword)

                                ||

                                book.getTitle()
                                        .toLowerCase()
                                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {

            System.out.println("No books found.");
        }

        else {

            result.forEach(System.out::println);
        }
    }

    // find book
    private Book findBook(int id) {

        return books.stream()
                .filter(book -> book.getBookId() == id)
                .findFirst()
                .orElse(null);
    }
}
