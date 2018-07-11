package db;

import models.Book;
import models.Borrower;

public class Seeds {

    public static void seedData(){
        DBHelper.deleteAll(Book.class);
        DBHelper.deleteAll(Borrower.class);

        Borrower borrower1 = new Borrower("Adri", "Florence");
        Borrower borrower2 = new Borrower("Angelina", "Blyth");
        Borrower borrower3 = new Borrower("Harjit", "Singh");
        DBHelper.save(borrower1);
        DBHelper.save(borrower2);
        DBHelper.save(borrower3);
        Book book1 = new Book("Do Androids Dream Of Electric Sheep?", "Philip K. Dick");
        Book book2 = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling");
        Book book3 = new Book("Down and Out in Paris and London", "George Orwell");
        Book book4 = new Book("Doppler", "Erlend Loe");
        Book book5 = new Book("The Raging Quiet", "Sherryl Jordan");
        Book book6 = new Book("Extremely Loud & Incredibly Close", "Jonathan Safran Foer");
        Book book7 = new Book("This book is not on Loan", "Test Author");
        book1.setCurrentBorrower(borrower1);
        book2.setCurrentBorrower(borrower2);
        book3.setCurrentBorrower(borrower3);
        book4.setCurrentBorrower(borrower1);
        book5.setCurrentBorrower(borrower2);
        book6.setCurrentBorrower(borrower1);
        DBHelper.save(book1);
        DBHelper.save(book2);
        DBHelper.save(book3);
        DBHelper.save(book4);
        DBHelper.save(book5);
        DBHelper.save(book6);
        DBHelper.save(book7);

    }
}
