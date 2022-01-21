package application.controller;

import application.domain.Address;
import application.domain.Contact;
import application.domain.Person;
import application.service.AddressService;
import application.service.ContactService;
import application.service.InputService;
import application.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for delete operations.
 */
@Service
public class DeleteController {
    private final String SUCCESS = "Deleted successfully";
    private InputService inputService;
    private PersonService personService;
    private AddressService addressService;
    private ContactService contactService;

    public DeleteController(InputService inputService, PersonService personService, AddressService addressService, ContactService contactService) {
        this.inputService = inputService;
        this.personService = personService;
        this.addressService = addressService;
        this.contactService = contactService;
    }

    public void deleteElement(Integer userAnswer) {
        if (userAnswer == null) {
            System.out.println("Value cannot be null");
            deleteElement(inputService.getNumericInput());
        }
        else {
            switch (userAnswer) {
                case 1 -> deletePerson();
                case 2 -> deleteAddress();
                case 3 -> deleteContact();
                case 4 -> System.out.println("Cancelling deleting process");
            }
        }
    }

    private void deletePerson()  {
        System.out.println("Give id of the person you want to delete:");
        Optional<Person> tempPerson = personService.getPerson(inputService.getNumericInput());
        if (tempPerson.isPresent()) {
            personService.deletePerson(tempPerson.get().getPersonId());
            System.out.println(SUCCESS);
        } else {
            System.out.println("No person found");
        }
    }

    private void deleteAddress() {
        System.out.println("Give id of the address you want to delete:");
        Optional<Address> tempAddress = addressService.getAddress(inputService.getNumericInput());
        if (tempAddress.isPresent()) {
            addressService.deleteAddress(tempAddress.get().getAddressId());
            System.out.println(SUCCESS);
        } else {
            System.out.println("No address found");
        }
    }

    private void deleteContact() {
        System.out.println("Give id of the contact you want to delete:");
        Optional<Contact> tempContact = contactService.getContact(inputService.getNumericInput());
        if (tempContact.isPresent()) {
            contactService.deleteContact(tempContact.get().getContactId());
            System.out.println(SUCCESS);
        } else {
            System.out.println("No contact found");
        }
    }
}
