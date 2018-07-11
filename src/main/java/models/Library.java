package models;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;

    public Library() {
        this.books = new ArrayList<Book>();
        this.borrowers = new ArrayList<Borrower>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(ArrayList<Borrower> borrowers) {
        this.borrowers = borrowers;
    }
}
