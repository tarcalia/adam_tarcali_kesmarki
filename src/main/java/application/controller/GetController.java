package application.controller;

import application.service.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for GET operations with database.
 */
@Service
public class GetController {
    private InputService inputService;
    private PersonService personService;
    private AddressService addressService;
    private ContactService contactService;
    private SearchService searchService;

    public GetController(InputService inputService, PersonService personService,
                         AddressService addressService, ContactService contactService,
                         SearchService searchService) {
        this.inputService = inputService;
        this.personService = personService;
        this.addressService = addressService;
        this.contactService = contactService;
        this.searchService = searchService;
    }

    public void getQuery(Integer userAnswer) {
        if (userAnswer == null) {
            System.out.println("Value cannot be null");
            getQuery(inputService.getNumericInput());
        } else {
            switch (userAnswer) {
                case 1 -> getPersons();
                case 2 -> getAddresses();
                case 3 -> getContacts();
                case 4 -> {System.out.println("Please give search criteria"); search(inputService.getStringInput());}
                case 5 -> System.out.println("Cancelling upload process");
            }
        }
    }

    private void getPersons(){
        System.out.println("All Persons:");
        System.out.println(personService.getUploadedPersons());
    }

    private void getAddresses() {
        System.out.println("All Addresses:");
        System.out.println(addressService.getAddresses());
    }

    private void getContacts() {
        System.out.println("All Contacts");
        System.out.println(contactService.getContacts());
    }

    private void search(String criteria) {
        if (criteria == null) {
            System.out.println("Value cannot be null");
            search(inputService.getStringInput());
        } else {
            List<Object> result = searchService.search(criteria);
            if (result.isEmpty()) {
                System.out.println("No result found");
            } else {
                System.out.println("Found results:");
                result.forEach(System.out::println);
            }
        }
    }
}
