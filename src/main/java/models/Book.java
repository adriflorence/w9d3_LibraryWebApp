package models;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {

    private int id;
    private String title;
    private String author;
    private Boolean onLoan;
    private Borrower currentBorrower;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.onLoan = false;
        this.currentBorrower = null;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name="onLoan")
    public Boolean getOnLoan() {
        return onLoan;
    }

    public void setOnLoan(Boolean onLoan) {
        this.onLoan = onLoan;
    }

    public void updateOnLoan(){
        if(currentBorrower != null) {
            onLoan = true;
        }
    }

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    public Borrower getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(Borrower currentBorrower) {
        this.currentBorrower = currentBorrower;
    }

}
