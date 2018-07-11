package controllers;

import db.Seeds;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

        Seeds.seedData();

        staticFileLocation("/public");

        BooksController booksController = new BooksController();
        BorrowersController borrowersController = new BorrowersController();

        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            model.put("template", "templates/index.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
