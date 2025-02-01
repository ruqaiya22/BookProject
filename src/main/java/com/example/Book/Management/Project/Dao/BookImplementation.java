package com.example.Book.Management.Project.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Book.Management.Project.Model.Book;
import com.example.Book.Management.Project.repo.BookRepository;

@Service 
public class BookImplementation implements BookService {
	
	 @Autowired
	    private BookRepository bookRepository;

	    @Override
	    public List<Book> getAllBooks() {
	        return bookRepository.findAll();  // Retrieve all books from the database
	    }

	    @Override
	    public Book getBookById(Long id) {
	        return bookRepository.findById(id).orElse(null);  // Retrieve book by its ID, returns null if not found
	    }

	    @Override
	    public void saveBook(Book book) {
	        bookRepository.save(book);  // Save new or updated book to the database
	    }

	    @Override
	    public void deleteBook(Long id) {
	        bookRepository.deleteById(id);  // Delete a book by its ID
	    }

	    @Override
	    public Book updateBook(Long id, Book updatedBook) {
	        Optional<Book> existingBook = bookRepository.findById(id);  // Check if the book exists

	        if (existingBook.isPresent()) {
	            // If the book exists, update its details
	            Book book = existingBook.get();
	            book.setTitle(updatedBook.getTitle());
	            book.setAuthor(updatedBook.getAuthor());
	            book.setPrice(updatedBook.getPrice());
	            return bookRepository.save(book);  // Save the updated book
	        }

	        return null;  // Return null if the book with the given ID doesn't exist
	    }

}
