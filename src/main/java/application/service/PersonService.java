package application.service;

import application.domain.Person;

import java.util.List;
import java.util.Optional;

/**
 * Service class for {@link Person} related operations.
 */
public interface PersonService {

    /**
     * Get {@link Person} object from the database.
     * @param personId is the person's id which will be searched for.
     * @return Person if exists.
     */
    Optional<Person> getPerson(Integer personId);

    /**
     * Return a list of Uploaded persons;
     * @return a list of persons.
     */
    List<Person> getUploadedPersons();

    /**
     * Save a {@link Person} entity to database.
     * @param name will be the name of the entity
     */
    void addPerson(String name);

    /**
     * Modify a {@link Person} entity in the database.
     * @param id is the person's id which will be searched for.
     * @param name will be the person's new name
     */
    void modifyPerson(Integer id, String name);

    /**
     * Delete a {@link Person} entity from database.
     * @param id will be the identifier which entity should be deleted
     */
    void deletePerson(Integer id);
}
