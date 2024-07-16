package com.example.librarysystem.controller;

import com.example.librarysystem.Book;
import com.example.librarysystem.BookRequest;
import com.example.librarysystem.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Integer bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {
        Integer bookId = bookService.createBook(bookRequest);
        Book book = bookService.getBookById(bookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody BookRequest bookRequest) {
        Book book = bookService.getBookById(bookId);
        //Check if the book exists or not
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //Update the book's data
        bookService.updateBook(bookId, bookRequest);
        Book updateBook = bookService.getBookById(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(updateBook);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
