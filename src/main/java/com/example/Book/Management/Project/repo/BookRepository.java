package com.example.Book.Management.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Book.Management.Project.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
