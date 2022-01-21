package application.controller;

import application.domain.Address;
import application.domain.Person;
import application.service.AddressService;
import application.service.ContactService;
import application.service.InputService;
import application.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for POST operations with database.
 */
@Service
public class PostController {
    private final String SUCCESS = "Uploaded successfully";
    private InputService inputService;
    private PersonService personService;
    private AddressService addressService;
    private ContactService contactService;

    public PostController(InputService inputService, PersonService personService, AddressService addressService, ContactService contactService) {
        this.inputService = inputService;
        this.personService = personService;
        this.addressService = addressService;
        this.contactService = contactService;
    }

    public void uploadElement(Integer userAnswer) {
        if (userAnswer == null) {
            System.out.println("Value cannot be null");
            uploadElement(inputService.getNumericInput());
        } else {
            switch (userAnswer) {
                case 1 -> addPerson();
                case 2 -> addAddress();
                case 3 -> addContact();
                case 4 -> System.out.println("Cancelling upload process");
            }
        }
    }

    private void addPerson() {
        System.out.println("Give name of the person:");
        personService.addPerson(inputService.getStringInput());
        System.out.println(SUCCESS);
    }

    private void addAddress() {
        System.out.println("Give address");
        String tempAddress = inputService.getStringInput();
        System.out.println("Give person id where this address belongs to:");
        Optional<Person> tempPerson = personService.getPerson(inputService.getNumericInput());
        if (tempPerson.isPresent()) {
            addressService.addAddress(tempPerson.get(), tempAddress);
            System.out.println(SUCCESS);
        } else {
            System.out.println("failed to make request");
        }

    }

    private void addContact() {
        System.out.println("Give phone number");
        Integer tempContact = inputService.getNumericInput();
        System.out.println("Give address id where this contact belongs to:");
        Optional<Address> tempAddress = addressService.getAddress(inputService.getNumericInput());
        if (tempAddress.isPresent()) {
            contactService.addContact(tempAddress.get(), tempContact);
            System.out.println(SUCCESS);
        } else {
            System.out.println("failed to make request");
        }

    }

}
