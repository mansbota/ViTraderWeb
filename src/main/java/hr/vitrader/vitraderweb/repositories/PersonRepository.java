package hr.vitrader.vitraderweb.repositories;

import hr.vitrader.vitraderweb.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByFirstName(String firstName);

    Person findByLastName(String lastName);
}
