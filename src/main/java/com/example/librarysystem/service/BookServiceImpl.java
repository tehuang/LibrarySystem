package com.example.librarysystem.service;

import com.example.librarysystem.Book;
import com.example.librarysystem.BookRequest;
import com.example.librarysystem.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book getBookById(Integer bookId){
        return bookDao.getBookById(bookId);
    }

    @Override
    public Integer createBook(BookRequest bookRequest){
        return bookDao.createBook(bookRequest);
    }

    @Override
    public void updateBook(Integer bookId, BookRequest bookRequest){
        bookDao.updateBook(bookId, bookRequest);
    }

    @Override
    public void deleteBookById(Integer bookId){
        bookDao.deleteBookById(bookId);
    }
}
