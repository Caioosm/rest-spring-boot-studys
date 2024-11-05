package com.estudos.__first_steps.controllers;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import com.estudos.__first_steps.model.Person;
import com.estudos.__first_steps.services.PersonService;

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
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for managing people")
public class PersonController {

    @Autowired
    private PersonService personService;

    // request method for find person by id
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds a Person", description = "Finds a Person", tags = {"People"}, responses = {
        @ApiResponse(description = "sucess", responseCode = "200", 
            content =  @Content(schema = @Schema(implementation = Person.class))
        ),
        @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Foud", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public Person findById(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    // request method for find all persons
    //Anottation @Operation from Swagger for method findAll
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Find all People", description = "Find all People", tags = {"People"}, responses = {
        @ApiResponse(description = "sucess", responseCode = "200", 
            content = {
                @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Person.class))
                )
            }),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Foud", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public List<Person> findAll() {
        return personService.findAll();
    }

    // request method for create a one persons
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Create a new Person", description = "Create a new Person by passing in JSON/XML", tags = {"People"}, responses = {
        @ApiResponse(description = "sucess", responseCode = "200", 
            content =  @Content(schema = @Schema(implementation = Person.class))
        ),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    // Request method for update a one person
    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Updates a Person", description = "Updated", tags = {"People"}, responses = {
        @ApiResponse(description = "sucess", responseCode = "200", 
            content =  @Content(schema = @Schema(implementation = Person.class))
        ),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Foud", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    // request method for find person by id
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a Person", description = "Deleted", tags = {"People"}, responses = {
        @ApiResponse(description = "No Content", responseCode = "204", content =  @Content),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Foud", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
