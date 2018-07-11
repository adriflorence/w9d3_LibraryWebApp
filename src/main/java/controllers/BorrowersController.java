package controllers;

import db.DBHelper;
import models.Book;
import models.Borrower;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class BorrowersController {

    public BorrowersController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/borrowers", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Borrower> borrowers = DBHelper.getAll(Borrower.class);
            model.put("template", "templates/borrowers/index.vtl");
            model.put("borrowers", borrowers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/borrowers/new", (req, res) -> {
            List<Borrower> borrowers = DBHelper.getAll(Borrower.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("borrowers", borrowers);
            model.put("template", "templates/borrowers/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        // CREATE & SAVE NEW BORROWER
        post("/borrowers",  (req, res) -> {
            String firstName = req.queryParams("firstName");
            String lastName = req.queryParams("lastName");

            Borrower newBorrower = new Borrower(firstName, lastName);
            DBHelper.save(newBorrower);
            res.redirect("/borrowers");
            return null;
        }, velocityTemplateEngine);

        // FETCH BORROWER
        get("/borrowers/:id", (req, res) -> {  // fetch manager to update
            int borrower_id = Integer.parseInt(req.params(":id"));
            Borrower borrower = DBHelper.find(borrower_id, Borrower.class);

            List<Book> books = DBHelper.getAll(Book.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("books", books);
            model.put("borrower", borrower);
            model.put("template", "templates/borrowers/view.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        // UPDATE BORROWER
        post("/borrowers/:id", (req, res) -> { // update manager
            int borrower_id = Integer.parseInt(req.params(":id"));
            Borrower borrower = DBHelper.find(borrower_id, Borrower.class);
            String newFirstName = req.queryParams("firstName");
            String newLastName = req.queryParams("lastName");

            List<Book> books = DBHelper.getAll(Book.class);

            borrower.setFirstName(newFirstName);
            borrower.setLastName(newLastName);

            DBHelper.update(borrower);
            res.redirect("/borrowers");
            return null;
        });

        // DELETE BOOK FROM BORROWER'S LIST
//        post("/borrowers/:id", (req, res) -> {
//            int id = Integer.parseInt(req.params(":id"));
//            Borrower borrower = DBHelper.find(id, Borrower.class);
//            borrower.getItemsBorrowed();
//            res.redirect("/borrowers/:id");
//            return null;
//        });


    }


}
