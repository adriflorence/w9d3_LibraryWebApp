package db;

import models.Book;
import models.Borrower;
import models.Genre;

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
        Book book1 = new Book("Do Androids Dream Of Electric Sheep?", "Philip K. Dick", Genre.SCIENCE_FICTION);
        Book book2 = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling", Genre.FICTION);
        Book book3 = new Book("Down and Out in Paris and London", "George Orwell", Genre.MEMOIRE);
        Book book4 = new Book("Doppler", "Erlend Loe", Genre.FICTION);
        Book book5 = new Book("The Raging Quiet", "Sherryl Jordan", Genre.FICTION);
        Book book6 = new Book("Extremely Loud & Incredibly Close", "Jonathan Safran Foer", Genre.FICTION);
        Book book7 = new Book("Flowers for Algernon", "Daniel Keyes", Genre.FANTASY);
        Book book8 = new Book("Eating Animals", "Jonathan Safran Foer", Genre.NON_FICTION);
        Book book9 = new Book("Breakfast of Champions", "Kurt Vonnegut", Genre.SATIRE);
        Book book10 = new Book("Cat's Cradle", "Kurt Vonnegut", Genre.SATIRE);
        Book book11 = new Book("The Stranger", "Albert Camus", Genre.PHILOSOPHICAL_FICTION);
        Book book12 = new Book("Brave New World", "Aldous Huxley", Genre.SCIENCE_FICTION);
        Book book13 = new Book("The Catcher in the Rye", "J. D. Salinger", Genre.LITERARY_REALISM);
        Book book14 = new Book("The Great Gatsby", "F. Scott Fitzgerald", Genre.FICTION);
        Book book15 = new Book("One Flew Over the Cuckoo's Nest", "Ken Kesey", Genre.FICTION);
        Book book16 = new Book("It", "Stephen King", Genre.HORROR);
        Book book17 = new Book("This Book doesn't have a borrower", "Mr Test", Genre.LEARNING);


        book1.setCurrentBorrower(borrower1);
        book2.setCurrentBorrower(borrower2);
        book3.setCurrentBorrower(borrower3);
        book4.setCurrentBorrower(borrower1);
        book5.setCurrentBorrower(borrower2);
        book6.setCurrentBorrower(borrower1);
        book7.setCurrentBorrower(borrower1);
        book9.setCurrentBorrower(borrower1);
        book10.setCurrentBorrower(borrower1);
        book11.setCurrentBorrower(borrower1);
        book12.setCurrentBorrower(borrower1);
        book13.setCurrentBorrower(borrower1);
        book14.setCurrentBorrower(borrower1);
        book15.setCurrentBorrower(borrower1);
        book16.setCurrentBorrower(borrower2);
        DBHelper.save(book1);
        DBHelper.save(book2);
        DBHelper.save(book3);
        DBHelper.save(book4);
        DBHelper.save(book5);
        DBHelper.save(book6);
        DBHelper.save(book7);
        DBHelper.save(book8);
        DBHelper.save(book9);
        DBHelper.save(book10);
        DBHelper.save(book11);
        DBHelper.save(book12);
        DBHelper.save(book13);
        DBHelper.save(book14);
        DBHelper.save(book15);
        DBHelper.save(book16);
        DBHelper.save(book17);

    }
}
