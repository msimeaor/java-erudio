package br.com.msimeaor.java.erudio.controllers;

import br.com.msimeaor.java.erudio.models.Person;
import br.com.msimeaor.java.erudio.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

  private PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Person> findById(@PathVariable("id") Long id) {
      return service.findById(id);
  }

  @PostMapping("/create")
  public ResponseEntity<Person> create(@RequestBody Person person) {
    return service.create(person);
  }

  @GetMapping("/findAll")
  public List<Person> findAll() {
    return service.findAll();
  }

}
