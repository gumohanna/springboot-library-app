package com.springboot.biblioteca.services;

import com.springboot.biblioteca.entities.Book;
import com.springboot.biblioteca.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        if (!bookRepository.existsById(id)){
            throw new IllegalArgumentException("Book not found");
        }
        Optional<Book> obj =  bookRepository.findById(id);
        return obj.get();
    }

    public void deleteBook(Long id){
        if (!bookRepository.existsById(id)){
            throw new IllegalArgumentException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
