package com.library.management;


public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {

        String status;

        if (issued) {

            status = "Not Avaliable";
        }

        else {

            status = "Avaliable";
        }

        return "Book ID : " + bookId +
                "\nBook Name : " + title +
                "\nAuthor : " + author +
                "\nStatus : " + status +
                "\n";
    }
}
