package br.com.msimeaor.java.erudio.services;

import br.com.msimeaor.java.erudio.models.Person;
import br.com.msimeaor.java.erudio.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

  private PersonRepository repository;
  private final AtomicLong counter = new AtomicLong();

  public PersonService(PersonRepository repository) {
    this.repository = repository;
  }

  public Person findById(Long id) {
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("First Name");
    person.setLastName("Last Name");
    person.setAddress("Address");
    person.setGender("MALE");
    return person;
  }

}
