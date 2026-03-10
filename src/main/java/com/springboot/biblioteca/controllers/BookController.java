package com.springboot.biblioteca.controllers;

import com.springboot.biblioteca.entities.Book;
import com.springboot.biblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> list = bookService.getAllBooks();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id){
        Book obj = bookService.getBookById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public Book book(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
