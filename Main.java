package com.library.management;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        // default books

        library.addBook(
                new Book(101,
                        "Java ",
                        "Tarun"));

        library.addBook(
                new Book(102,
                        "Python ",
                        "Srikrishna"));

        library.addBook(
                new Book(103,
                        "C++",
                        "Varun"));

        int choice;

        do {

            System.out.println("\n WELL COME TO LIBRARY ");

            System.out.println("1. SHOW AVALIBALE BOOKS");
            System.out.println("2. ADD NEW BOOKS");
            System.out.println("3. ISSUE BOOK");
            System.out.println("4. RETURN BOOK");
            System.out.println("5. SEARCH BOOK");
            System.out.println("6. EXIT");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    library.showBooks();
                    break;

                case 2:

                    System.out.print("Enter Book ID : ");

                    int id = sc.nextInt();

                    if (library.checkBookExists(id)) {

                        System.out.println(
                                "Book ID already exists!");
                    }

                    else {

                        sc.nextLine();

                        System.out.print(
                                "Enter Book Name : ");

                        String name = sc.nextLine();

                        System.out.print(
                                "Enter Author Name : ");

                        String author = sc.nextLine();

                        library.addBook(
                                new Book(id,
                                        name,
                                        author));
                    }

                    break;

                case 3:

                    try {

                        System.out.print(
                                "Enter Book ID : ");

                        int issueId = sc.nextInt();

                        library.issueBook(issueId);

                    }

                    catch (
                            InvalidBookOperationException e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                case 4:

                    try {

                        System.out.print(
                                "Enter Book ID : ");

                        int returnId = sc.nextInt();

                        library.returnBook(returnId);

                    }

                    catch (
                            InvalidBookOperationException e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print(
                            "Enter Book ID or Name : ");

                    String keyword = sc.nextLine();

                    library.searchBook(keyword);

                    break;

                case 6:

                    System.out.println("THANK YOU COME AGAIN");
                    break;

                default:

                    System.out.println("Invalid Choice");

                    System.out.println("Exiting Program...");

                    choice = 6;                   
            }

        } 
        while (choice != 6);

       
    }
}
