package br.com.msimeaor.java.erudio.repositories;

import br.com.msimeaor.java.erudio.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
