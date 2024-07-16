package com.example.librarysystem.service;

import com.example.librarysystem.Book;
import com.example.librarysystem.BookRequest;
public interface BookService {
    Book getBookById(Integer bookId);
    Integer createBook(BookRequest bookRequest);
    void updateBook(Integer bookId, BookRequest bookRequest);
    void deleteBookById(Integer bookId);
}
