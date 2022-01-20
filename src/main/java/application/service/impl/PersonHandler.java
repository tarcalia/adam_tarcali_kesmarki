package application.service.impl;

import application.domain.Person;
import application.repository.PersonRepository;
import application.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service class to handle {@link Person} related operations.
 */
@Service
public class PersonHandler implements PersonService {
    PersonRepository personRepository;

    public PersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPerson(Integer personId) {
        if (personRepository.findById(personId).isPresent()) {
            return personRepository.findById(personId).get();
        } else {
            throw new NoSuchElementException("No person with this id found");
        }
    }

    @Override
    public List<Person> getUploadedPersons() {
        return personRepository.findAll();
    }

    @Override
    public void addPerson(String name) {
        personRepository.save(new Person(name));

    }

    @Override
    public void modifyPerson(Integer id, String name) {
        Person tempPerson = getPerson(id);
        tempPerson.setPersonName(name);
        personRepository.save(tempPerson);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.delete(getPerson(id));
    }
}
