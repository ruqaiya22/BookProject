package com.example.Book.Management.Project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Book.Management.Project.Dao.BookService;
import com.example.Book.Management.Project.Model.Book;

@Controller

public class BookController {
	

    private BookService bookService;
	
	public BookController( BookService bookService) {
		this.bookService= bookService;
	}

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/add-book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit-book/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "edit-book";
    }

    @PostMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book book) {
        bookService.updateBook(id, book);
        return "redirect:/";
    }

    @GetMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

}
