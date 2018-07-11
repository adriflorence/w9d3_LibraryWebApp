package controllers;

import db.DBHelper;
import models.Book;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class BooksController {

    public BooksController ()  {
        this.setupEndpoints();
    }

    private void setupEndpoints(){
      
      VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/books", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Book> books = DBHelper.getAll(Book.class);
            model.put("template", "templates/books/index.vtl");
            model.put("books", books);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/books/new", (req,res) ->{
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/books/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/books", (req, res) ->{
           String title = req.queryParams("title");
           String author = req.queryParams("author");
           Book book = new Book(title, author);
           DBHelper.save(book);
           res.redirect("/books");
           return null;
        }, velocityTemplateEngine);
    }
}
