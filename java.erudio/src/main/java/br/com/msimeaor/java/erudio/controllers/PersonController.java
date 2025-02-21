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

  @PutMapping("/update/{id}")
  public ResponseEntity<Person> update(@PathVariable("id") Long id,
                                       @RequestBody Person updatedPerson) {
    return service.update(id, updatedPerson);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    return service.delete(id);
  }

}
