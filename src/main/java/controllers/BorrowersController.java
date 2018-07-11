package controllers;

import db.DBHelper;
import models.Borrower;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

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

    }


}
