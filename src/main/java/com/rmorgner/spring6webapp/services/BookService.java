package com.rmorgner.spring6webapp.services;

import com.rmorgner.spring6webapp.domain.Book;

public interface BookService {

  Iterable<Book> findAll();

}
