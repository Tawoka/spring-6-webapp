package com.rmorgner.spring6webapp.bootstrap;

import com.rmorgner.spring6webapp.domain.Author;
import com.rmorgner.spring6webapp.domain.Book;
import com.rmorgner.spring6webapp.domain.Publisher;
import com.rmorgner.spring6webapp.repositories.AuthorRepository;
import com.rmorgner.spring6webapp.repositories.BookRepository;
import com.rmorgner.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                       PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author();
    eric.setFirstName("Eric");
    eric.setLastName("Evans");

    Book ddd = new Book();
    ddd.setTitle("Domain Driven Design");
    ddd.setIsbn("123456");

    Author ericSaved = authorRepository.save(eric);
    Book dddSaved = bookRepository.save(ddd);

    Author rod = new Author();
    rod.setLastName("Johnson");
    rod.setFirstName("Rod");

    Book noEJB = new Book();
    noEJB.setTitle("J2EE Development without EJB");
    noEJB.setIsbn("54757585");

    Author rodSaved = authorRepository.save(rod);
    Book noEJBSaved = bookRepository.save(noEJB);

    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEJBSaved);

    Publisher tpp = new Publisher();
    tpp.setPublisherName("The Pragmatic Programmers");
    tpp.setCity("Hometown");
    tpp.setAddress("Long Road");
    tpp.setZip("12345");
    tpp.setState("Not That One!");
    Publisher tppSaved = publisherRepository.save(tpp);

    dddSaved.setPublisher(tppSaved);
    noEJBSaved.setPublisher(tppSaved);

    authorRepository.save(ericSaved);
    authorRepository.save(rodSaved);
    bookRepository.save(dddSaved);
    bookRepository.save(noEJBSaved);

    System.out.println("In Bootstrap");
    System.out.println("Author Count: " + authorRepository.count());
    System.out.println("Book Count: " + bookRepository.count());


    System.out.println("Publisher Count: " + publisherRepository.count());
  }
}
