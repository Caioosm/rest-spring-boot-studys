package com.estudos.__first_steps.controllers;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import com.estudos.__first_steps.model.Books;
import com.estudos.__first_steps.services.BooksService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/books/v1")
@Tag(name = "Book", description = "Endpoints for managing books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    // request method for find books by id
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds a Books", description = "Finds a Books", tags = {"Book"}, responses = {
        @ApiResponse(description = "sucess", responseCode = "200", 
            content =  @Content(schema = @Schema(implementation = Books.class))
        ),
        @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Foud", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public Books findById(@PathVariable(value = "id") Long id) {
        return booksService.findById(id);
    }

    // request method for find all persons
    //Anottation @Operation from Swagger for method findAll
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Find all Book", description = "Find all Book", tags = {"Book"}, responses = {
        @ApiResponse(description = "sucess", responseCode = "200", 
            content = {
                @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Books.class))
                )
            }),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Foud", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public List<Books> findAll() {
        return booksService.findAll();
    }

    // request method for create a one persons
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Create a new Books", description = "Create a new Books by passing in JSON/XML", tags = {"Book"}, responses = {
        @ApiResponse(description = "sucess", responseCode = "200", 
            content =  @Content(schema = @Schema(implementation = Books.class))
        ),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public Books create(@RequestBody Books books) {
        return booksService.create(books);
    }

    // Request method for update a one books
    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Updates a Books", description = "Updated", tags = {"Book"}, responses = {
        @ApiResponse(description = "sucess", responseCode = "200", 
            content =  @Content(schema = @Schema(implementation = Books.class))
        ),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Foud", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public Books update(@RequestBody Books books) {
        return booksService.update(books);
    }

    // request method for find books by id
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a Books", description = "Deleted", tags = {"Book"}, responses = {
        @ApiResponse(description = "No Content", responseCode = "204", content =  @Content),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Foud", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        booksService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
