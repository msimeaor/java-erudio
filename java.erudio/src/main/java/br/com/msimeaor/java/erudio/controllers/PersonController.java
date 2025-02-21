package br.com.msimeaor.java.erudio.controllers;

import br.com.msimeaor.java.erudio.models.Person;
import br.com.msimeaor.java.erudio.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PersonController {

  private PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public Person findById(@PathVariable("id") Long id) {
      return service.findById(id);
  }

}
