package com.rmorgner.spring6webapp.services;

import com.rmorgner.spring6webapp.domain.Author;

public interface AuthorService {

  Iterable<Author> findAll();

}
