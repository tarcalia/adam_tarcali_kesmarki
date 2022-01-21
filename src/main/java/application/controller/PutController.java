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
 * Service for PUT operations with database.
 */
@Service
public class PutController {
    private final String SUCCESS = "Modified successfully";
    private final String FINAL = "Modify process finished successfully/unsuccessful";
    private InputService inputService;
    private PersonService personService;
    private AddressService addressService;
    private ContactService contactService;

    public PutController(InputService inputService, PersonService personService, AddressService addressService, ContactService contactService) {
        this.inputService = inputService;
        this.personService = personService;
        this.addressService = addressService;
        this.contactService = contactService;
    }

    public void modifyElement(Integer userAnswer) {
        if (userAnswer == null) {
            System.out.println("Value cannot be null");
            modifyElement(inputService.getNumericInput());
        } else {
            switch (userAnswer) {
                case 1 -> modifyPerson();
                case 2 -> modifyAddress();
                case 3 -> modifyContact();
                case 4 -> System.out.println("Cancelling upload process");
            }
        }
    }

    private void modifyPerson() {
        System.out.println("Give id of the person you want to modify");
        Integer tempId = inputService.getNumericInput();
        System.out.println("Give new name of the person:");
        personService.modifyPerson(tempId, inputService.getStringInput());
        System.out.println(SUCCESS);
    }

    private void modifyAddress() {
        System.out.println("Give id of the address you want to modify");
        Integer tempId = inputService.getNumericInput();
        System.out.println("Give address");
        String tempAddress = inputService.getStringInput();
        System.out.println("Give person id where this address belongs to:");
        Optional<Person> tempPerson = personService.getPerson(inputService.getNumericInput());
        if (tempPerson.isPresent()) {
            addressService.modifyAddress(tempId, tempAddress, tempPerson.get());
            System.out.println(SUCCESS);
        } else {
            System.out.println("No person found with this id");
        }
    }

    private void modifyContact() {
        System.out.println("Give id of the contact you want to modify");
        Integer tempId = inputService.getNumericInput();
        System.out.println("Give phone number");
        Integer tempContact = inputService.getNumericInput();
        System.out.println("Give address id where this contact belongs to:");
        Optional<Address> tempAddress = addressService.getAddress(inputService.getNumericInput());
        if (tempAddress.isPresent()) {
            contactService.modifyContact(tempId, tempContact, tempAddress.get());
            System.out.println(SUCCESS);
        } else {
            System.out.println("No contact/address found with this id");
        }
    }
}
