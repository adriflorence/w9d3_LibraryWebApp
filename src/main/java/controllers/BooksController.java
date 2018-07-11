package controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.tools.internal.xjc.model.Model;
import db.DBHelper;
import models.Book;
import org.dom4j.rule.Mode;
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


        get("/books/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Book book = DBHelper.find(intId, Book.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("book", book);
            model.put("template", "templates/books/view.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/books/:id/edit", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Book book = DBHelper.find(intId, Book.class);

            HashMap<String, Object> model = new HashMap<>();
            model.put("book", book);
            model.put("template", "templates/books/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/books/:id", (req,res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Book book = DBHelper.find(intId, Book.class);

            String title = req.queryParams("title");
            String author = req.queryParams("author");

            book.setTitle(title);
            book.setAuthor(author);
            DBHelper.save(book);
            res.redirect("/books");
            return null;
        }, velocityTemplateEngine);

    }
}
