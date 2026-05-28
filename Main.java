package com.library.management;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        // Default Books
        library.addBook(
                new Book(101,
                        "Java Programming",
                        "James Gosling"));

        library.addBook(
                new Book(102,
                        "Python Basics",
                        "Guido Van Rossum"));

        library.addBook(
                new Book(103,
                        "Data Structures",
                        "Mark Allen"));

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Show All Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");

            System.out.print("\nEnter Choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    library.displayBooks();
                    break;

                case 2:

                    System.out.print("Enter Book ID : ");
                    int id = scanner.nextInt();

                    // Check duplicate ID first
                    boolean exists =
                            library.checkBookExists(id);

                    if (exists) {

                        System.out.println(
                                "Book ID already exists!");

                    } else {

                        scanner.nextLine();

                        System.out.print(
                                "Enter Book Title : ");

                        String title =
                                scanner.nextLine();

                        System.out.print(
                                "Enter Author Name : ");

                        String author =
                                scanner.nextLine();

                        library.addBook(
                                new Book(id,
                                        title,
                                        author));
                    }

                    break;

                case 3:

                    try {

                        System.out.print(
                                "Enter Book ID to Issue : ");

                        int issueId = scanner.nextInt();

                        library.issueBook(issueId);

                    } catch (
                            InvalidBookOperationException e) {

                        System.out.println(
                                "Error : "
                                        + e.getMessage());
                    }

                    break;

                case 4:

                    try {

                        System.out.print(
                                "Enter Book ID to Return : ");

                        int returnId = scanner.nextInt();

                        library.returnBook(returnId);

                    } catch (
                            InvalidBookOperationException e) {

                        System.out.println(
                                "Error : "
                                        + e.getMessage());
                    }

                    break;

                case 5:

                    scanner.nextLine();

                    System.out.print(
                            "Enter Book ID or Name : ");

                    String keyword =
                            scanner.nextLine();

                    library.searchBook(keyword);

                    break;

                case 6:

                    System.out.println(
                            "\nThank You!");

                    break;

                default:

                    System.out.println(
                            "Invalid Choice!");
            }

        } while (choice != 6);

        scanner.close();
    }
}