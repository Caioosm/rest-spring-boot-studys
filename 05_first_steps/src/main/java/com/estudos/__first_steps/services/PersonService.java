package com.estudos.__first_steps.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.estudos.__first_steps.controllers.PersonController;
import com.estudos.__first_steps.exceptions.ResourceNotFoundException;
import com.estudos.__first_steps.model.Person;
import com.estudos.__first_steps.repositories.PersonRepository;

@Service
public class PersonService {
    
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    //método para encontrar um usuário pelo ID, usando mock por enquanto
    public Person findById(Long id){

        logger.info("finding one person");
        
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
        entity.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

        return entity;
    }

    //método para encontrar todos os usuários
    public List<Person> findAll(){
        logger.info("finding all persons");

        var persons = repository.findAll();

        persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

        return persons;
    }

    //Método para criar um novo usuário
    public Person create(Person person){
        logger.info("Creating one person");
        
        var entity = repository.save(person);
        entity.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());

        return entity;
    }

    //Método para atualizar um usuário
    public Person update(Person person){
        logger.info("Updating one person");
        
        Person pe = repository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));

        pe.setFirstName(person.getFirstName());
        pe.setLastName(person.getLastName());
        pe.setAddress(person.getAddress());
        pe.setGender(person.getGender());
        
        var entity = repository.save(person);

        entity.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());

        return entity;
    }

    //Método para deletar um usuário por ID
    public void delete(Long id){
        logger.info("Deleting one person");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));

        repository.delete(entity);
    }
}
