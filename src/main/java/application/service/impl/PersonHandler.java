package application.service.impl;

import application.domain.Person;
import application.repository.PersonRepository;
import application.service.InputService;
import application.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class to handle {@link Person} related operations.
 */
@Service
public class PersonHandler implements PersonService {
    PersonRepository personRepository;
    InputService inputService;

    public PersonHandler(PersonRepository personRepository, InputService inputService) {
        this.personRepository = personRepository;
        this.inputService = inputService;
    }

    @Override
    public Optional<Person> getPerson(Integer personId) {
        if (personRepository.findById(personId).isPresent()) {
            return Optional.of(personRepository.findById(personId).get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Person> getUploadedPersons() {
        return personRepository.findAll();
    }

    @Override
    public void addPerson(String name) {
        if (name == null) {
            System.out.println("Person name cannot be null");
            addPerson(inputService.getStringInput());
        } else {
            personRepository.save(new Person(name));
        }
    }

    @Override
    public void modifyPerson(Integer id, String name) {
        if (id == null || name == null) {
            System.out.println("Null parameter given");
        }
        Optional<Person> tempPerson = getPerson(id);
        if (tempPerson.isEmpty()) {
            System.out.println("No person found");
        } else {
            Person existingPerson = tempPerson.get();
            existingPerson.setPersonName(name);
            personRepository.save(existingPerson);
        }
    }

    @Override
    public void deletePerson(Integer id) {
        if (id == null) {
            System.out.println("Null parameter given");
        }
        if (getPerson(id).isEmpty()) {
            System.out.println("No person found");
        } else {
            personRepository.delete(getPerson(id).get());
        }
    }
}
