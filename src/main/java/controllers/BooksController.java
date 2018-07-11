package controllers;

import db.DBHelper;
import models.Book;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class BooksController {

    public BooksController ()  {
        this.setupEndpoints();
    }

    private void setupEndpoints(){

        get("/books", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Book> books = DBHelper.getAll(Book.class);
            model.put("books", books);
            model.put("template", "templates/books/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
