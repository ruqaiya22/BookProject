package com.example.Book.Management.Project.Dao;


import java.util.List;

import com.example.Book.Management.Project.Model.Book;

public interface BookService {
	 List<Book> getAllBooks();
	    Book getBookById(Long id);
	    void saveBook(Book book);
	    void deleteBook(Long id);
	    Book updateBook(Long id, Book updatedBook);

}
