package models;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {

    private int id;
    private String title;
    private String author;
    private Genre genre;
    private Boolean onLoan;
    private Borrower currentBorrower;

    public Book() {
    }

    public Book(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
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

    @Enumerated(value = EnumType.STRING)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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
    @JoinColumn(name = "borrower_id", nullable = true)
    public Borrower getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(Borrower currentBorrower) {
        this.currentBorrower = currentBorrower;
        updateOnLoan();
    }

}
