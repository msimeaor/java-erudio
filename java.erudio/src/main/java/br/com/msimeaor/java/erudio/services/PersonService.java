package br.com.msimeaor.java.erudio.services;

import br.com.msimeaor.java.erudio.exceptions.ResourceNotFoundException;
import br.com.msimeaor.java.erudio.models.Person;
import br.com.msimeaor.java.erudio.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

  private PersonRepository repository;

  public PersonService(PersonRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<Person> findById(Long id) {
    Person person = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
    return new ResponseEntity<>(person, HttpStatus.OK);
  }

  public ResponseEntity<Person> create(Person person) {
    Person savedPerson = repository.save(person);
    return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
  }

  public List<Person> findAll() {
    return repository.findAll();
  }

  public ResponseEntity<Person> update(Long id, Person updatedPerson) {
    Person person = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

    person.setFirstName(updatedPerson.getFirstName());
    person.setLastName(updatedPerson.getLastName());
    person.setGender(updatedPerson.getGender());
    person.setAddress(updatedPerson.getAddress());
    person = repository.save(person);

    return new ResponseEntity<>(person, HttpStatus.OK);
  }

  public ResponseEntity delete(Long id) {
    Person person = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

    repository.delete(person);
    return ResponseEntity.noContent().build();
  }

}
