package com.estudos.__first_steps.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.estudos.__first_steps.model.Person;

@Service
public class PersonService {
    
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    //método para encontrar um usuário pelo ID, usando mock por enquanto
    public Person findById(String id){

        logger.info("finding one person");
        
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Caio");
        person.setLastName("cu");
        person.setAddress("pinto grosso - MG");
        person.setGender("Male");

        return person;
    }

    //método para encontrar todos os usuários
    public List<Person> findAll(){

        logger.info("finding all persons");

        List<Person> persons = new ArrayList<>();
        
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        
        return persons;
    }

    public Person create(Person person){
        logger.info("Creating one person");
        
        return person;
    }

    public Person update(Person person){
        logger.info("Updating one person");
        
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one person");
    }

    //mock temporário
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Some Address in Brazil " + i);
        person.setGender("male");
        return person;
    }
}
