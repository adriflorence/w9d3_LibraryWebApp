package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "borrowers")
public class Borrower {

    private int id;
    private String first_name;
    private String last_name;
    private Set<Book> itemsBorrowed;

    public Borrower(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="first_name")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name="last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @OneToMany(mappedBy="currentBorrower", fetch = FetchType.LAZY)
    public Set<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(Set<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }
}
