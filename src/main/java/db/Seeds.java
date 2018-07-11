package db;

import models.Book;
import models.Borrower;

public class Seeds {

    public static void seedData(){

        Borrower borrower1 = new Borrower("Adri", "Florence");
        Borrower borrower2 = new Borrower("Angelina", "Blyth");
        Borrower borrower3 = new Borrower("Harjit", "Singh");
        Book book1 = new Book("Do Androids Dream Of Electric Sheep?", "Philip K. Dick");
        Book book2 = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling");
        Book book3 = new Book("Down and Out in Paris and London", "George Orwell");
        book1.setCurrentBorrower(borrower1);
        book2.setCurrentBorrower(borrower2);
        book3.setCurrentBorrower(borrower3);

    }
}
