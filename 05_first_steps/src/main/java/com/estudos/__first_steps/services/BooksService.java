package com.estudos.__first_steps.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.estudos.__first_steps.controllers.BooksController;
import com.estudos.__first_steps.exceptions.ResourceNotFoundException;
import com.estudos.__first_steps.model.Books;
import com.estudos.__first_steps.repositories.BooksRepository;

@Service
public class BooksService {

    private Logger logger = Logger.getLogger(BooksService.class.getName()); 
    
    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Books findById(Long id){
        logger.info("finding one book");
        
        var book = booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record for this id!"));

        book.add(linkTo(methodOn(BooksController.class).findById(id)).withSelfRel());


        return book;
    }

    public List<Books> findAll(){
        logger.info("finding all books");

        var books = booksRepository.findAll();

        books.stream().forEach(b -> b.add(linkTo(methodOn(BooksController.class).findById(b.getId())).withSelfRel()));

        return books;
    }

    public Books create(Books books){
        logger.info("creating one book!");

        var book = booksRepository.save(books);
        book.add(linkTo(methodOn(BooksController.class).findById(book.getId())).withSelfRel());

        return book;
    }

    public Books update(Books books){
        logger.info("updating a book");

        Books book = booksRepository.findById(books.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this id!"));

        book.setAuthor(book.getAuthor());
        book.setLaunchDate(book.getLaunchDate());
        book.setPrice(book.getPrice());
        book.setTitle(book.getTitle());

        var bookss = booksRepository.save(books);

        bookss.add(linkTo(methodOn(BooksController.class).findById(books.getId())).withSelfRel());

        return bookss;
    }

    public void delete(Long id){
        logger.info("deleting one book!");

        Books books = booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this id!"));

        booksRepository.delete(books);
    }
}
