package com.kshtriya.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshtriya.springboot.exception.PersonNotFoundException;
import com.kshtriya.springboot.model.Person;
import com.kshtriya.springboot.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonById(Long id) {
		return personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException("Person does not found with mentioned id "));
	}
	
	public List<Person> getAllPerson(){
		return personRepository.findAll(); 
	}
	
	public String deletePerson(Long id) {
		personRepository.deleteById(id);
		return "Person deleted sucessfully";
	}
	
	public Person updatePerson(Long id,Person person) {
		Person existingPerson = personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException("Person does not found with mentioned id "));
		
		if(existingPerson !=null) {
			existingPerson.setName(person.getName());
			existingPerson.setEmail(person.getEmail());
			return personRepository.save(existingPerson);
		}
		return null;
		
		
		
		
	}
}
