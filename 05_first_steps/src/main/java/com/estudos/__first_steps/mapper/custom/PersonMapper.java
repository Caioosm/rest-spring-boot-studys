// package com.estudos.__first_steps.mapper.custom;

// import java.util.Date;

// import org.springframework.stereotype.Service;

// import com.estudos.__first_steps.DTO.PersonVO;
// import com.estudos.__first_steps.model.Person;

// @Service
// public class PersonMapper {

//     public PersonVO convertEntityToVo(Person person){
//         PersonVO vo = new PersonVO();

//         vo.setId(person.getId());
//         vo.setFirstName(person.getFirstName());
//         vo.setLastName(person.getLastName());
//         vo.setGender(person.getGender());
//         vo.setAddress(person.getAddress());
//         vo.setBirthDay(new Date());

//         return vo;
//     }

//     public Person convertVoToEntity(PersonVO person){
//         Person entity = new Person();

//         entity.setId(person.getId());
//         entity.setFirstName(person.getFirstName());
//         entity.setLastName(person.getLastName());
//         entity.setGender(person.getGender());
//         entity.setAddress(person.getAddress());

//         return entity;
//     }

// }
