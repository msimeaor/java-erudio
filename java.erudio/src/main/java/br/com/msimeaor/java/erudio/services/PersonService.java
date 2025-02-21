package br.com.msimeaor.java.erudio.services;

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
    Person person = repository.findById(id).get();
    return new ResponseEntity<>(person, HttpStatus.OK);
  }

  public ResponseEntity<Person> create(Person person) {
    Person savedPerson = repository.save(person);
    return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
  }

  public List<Person> findAll() {
    return repository.findAll();
  }

}
