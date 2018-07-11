# Lab - Library Web App

# Objectives
- to practice what has been covered over the past few weeks
- to create a web app which connects to a PostgreSQL database using Java, Hibernate, Spark and Velocity.

## The Task
You are required to build a web app for a library. This library will have a collection of books and a collection of borrowers which will be stored in a PostgreSQL database.

## MVP

Users should be able to perform the full CRUD (Create, Read, Update, Delete) actions on both books and borrowers

Borrowers will be able to borrow books from the library, and return books to the library.

When viewing a particular borrower it should be possible to also see all books currently on loan to that borrower.

When viewing books it should be possible to see if that book is available for loan and if not, the name of the borrower it is currently on loan to.

### Hints

 A `Book` could have the following properties:
  - id (`int`)
  - title (`String`)
  - author (`String`)
  - onLoan (`Boolean`)
  - currentBorrower(`Borrower`)

A `Borrower` could have the following:
 - id (`int`)
 - name (`String`)
 - itemsBorrowed(`Set<Book>`)


## Possible Extensions

* Add styling
* Add a genre to a book e.g. Sci-Fi, Science
* Be able to search for books by genre
* Add other types of items which can be borrowed from the library e.g. Periodicals (***HINT*** you might want to use inheritance for this)
* For each item, show a list of all the borrowers who have borrowed it in the past