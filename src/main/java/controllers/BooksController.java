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

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/books", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Book> books = DBHelper.getAll(Book.class);
            model.put("templates", "templates/books/index.vtl");
            model.put("books", books);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/books/new", (req,res) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Book> book = DBHelper.getAll(Book.class);
            model.put("books", book);
            model.put("templates", "templates/books/create.vtl");
            return new ModelAndView(model, "template/layout.vtl");
        }, velocityTemplateEngine);
    }
}
