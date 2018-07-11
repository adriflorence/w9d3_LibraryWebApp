package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "borrowers")
public class Borrower {

    private int id;
    private String firstName;
    private String lastName;
    private Set<Book> itemsBorrowed;

    public Borrower() {
    }

    public Borrower(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy="currentBorrower", fetch = FetchType.LAZY)
    public Set<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(Set<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }

}
