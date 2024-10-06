package com.estudos.__first_steps.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
    }

    //método para encontrar todos os usuários
    public List<Person> findAll(){
        logger.info("finding all persons");

        return repository.findAll();
    }

    //Método para criar um novo usuário
    public Person create(Person person){
        logger.info("Creating one person");
        
        return repository.save(person);
    }

    //Método para atualizar um usuário
    public Person update(Person person){
        logger.info("Updating one person");
        
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        
        return repository.save(person);
    }

    //Método para deletar um usuário por ID
    public void delete(Long id){
        logger.info("Deleting one person");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));

        repository.delete(entity);
    }
}
