package br.com.msimeaor.java.erudio.services;

import br.com.msimeaor.java.erudio.models.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

  private final AtomicLong counter = new AtomicLong();

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
