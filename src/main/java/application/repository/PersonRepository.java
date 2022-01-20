package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import application.domain.Person;

import java.util.List;

/**
 * Interface for JPA operators for {@link Person} objects.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findPersonByPersonName(String criteria);
}
